var Token = "";
var AdminId = "";

function login() {

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    showdiv();
    $.ajax({
        type: "POST",
        dataType: "json",
        url: 'api/account/login',
        //请求头加token
        /* beforeSend: function (request) {
             request.setRequestHeader("token", token);
         },*/
        contentType: "application/json",
        data: JSON.stringify({
            "name": username,
            "password": password
        }),
        success: function (data) {
            hidediv();

            console.log("data is :" + data);
            if (data.code == 1) {
                var result = data.result;

                if (result.departments != undefined) {
                    var Departments = result.departments;
                    var leaveTypes = result.leaveTypes;
                    console.log("Tepartments.id is :" + Departments[0].id)
                }
                console.log(JSON.stringify(leaveTypes));
                console.log("Tepartments is :" + Departments);
                setCookie("departments", JSON.stringify(Departments), 1);
                Token = result.token;
                AdminId=  result.id;
                setCookie("token", Token, 1);
                setCookie("adminId", AdminId, 1);
                // alert(result.tepartments[0].id)
                //alert("登陆成功");""
                window.location.href = "createExcel.html";
                //  window.location.href = "\\res\\leave\\leave201905.xls";
                // window.history.back(-1); //返回到上一个页面
            } else {
                alert(data.message)
            }
            //

        },
        error: function (jqXHR) {
            hidediv();
            console.log("发生错误：" + jqXHR.toString());
        }

    });

    function showdiv() {

        if (showdiv_display = document.getElementById('isShow').style.display == 'none') {//如果show是隐藏的

            document.getElementById('isShow').style.display = 'block';//show的display属性设置为block（显示）

        }

    }

    function hidediv() {
        if (showdiv_display = document.getElementById('isShow').style.display == 'block') {//如果show是显示的

            document.getElementById('isShow').style.display = 'none';//show的display属性设置为none（隐藏）

        }
    }

    /**
     *
     * @param cname
     * @param cvalue
     * @param exdhours  小时
     */
    function setCookie(cname, cvalue, exdhours) {
        var d = new Date();
        d.setTime(d.getTime() + (exdhours * 60 * 60 * 1000));
        var expires = "expires=" + d.toUTCString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    }
}

function isExecuteLogin() {
    if (Token == "") {
        showLogin();
    } else {
        hideLogin();
    }

}

function showLogin() {
    if (showdiv_display = document.getElementById('loginView').style.display == 'none') {//如果show是隐藏的

        document.getElementById('loginView').style.display = 'block';//show的display属性设置为block（显示）

    }
}

function hideLogin() {
    if (showdiv_display = document.getElementById('loginView').style.display == 'block') {//如果show是显示的

        document.getElementById('loginView').style.display = 'none';//show的display属性设置为none（隐藏）

    }
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}