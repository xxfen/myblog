var pageRow = 0;
var pageCurr = 0;

function getMyArticles(categories, pageNum) {

    $.ajax({
        type: "POST",
        dataType: "json",
        url: 'article/myArticles',
        //请求头加token
        /* beforeSend: function (request) {
             request.setRequestHeader("token", getCookie("token"));
         },*/
        contentType: "application/json",
        data: JSON.stringify({
            "categories": categories,
            "pageNum": pageNum,
            "rows": '5'
        }),


        success: function (data) {
            console.log("data is :" + data.toString());
            if (data.code != 200) {
                return;
            }
            var result = data.result;
            Renderer(result);
            console.log("data is :" + result);
            pageRow = result.length;
            console.log(pageRow);
            layui.config({
                base: '../static/js/util/'
            }).use(['element', 'laypage', 'jquery', 'menu', 'layer'], function () {
                var layer = layui.layer;
                element = layui.element, laypage = layui.laypage, $ = layui.jquery , menu = layui.menu;
                laypage.render({
                    elem: 'paging-div'
                    , count: pageRow,//数据总数，从服务端得到
                    // skip: true,
                    curr: pageCurr,//当前页
                    limit: 5,//一页数
                    jump: function (obj, first) {//obj是一个object类型。包括了分页的所有配置信息。first一个Boolean类，检测页面是否初始加载。非常有用，可避免无限刷新。
                        pageCurr = obj.curr;
                        console.log(obj.curr);
                        console.log(first);
                        if (!first) {
                            console.log(first);
                            getMyArticles(categories, obj.curr);
                            // renderPageData(laypageDivId, pageParams, templateId, resultContentId, url);
                        }
                    }
                });

                //  menu.init();

                /*laypage({
                    cont : "page",
                    pages : 5,
                    jump : function(obj){
                        $(".thead").html(getMyArticles("我的故事",obj.curr));
                      //  $('.notice_list thead input[type="checkbox"]').prop("checked",false);
                        form.render();
                    }
                })*/

            });

        },
        error: function (jqXHR) {

            // console.log("发生错误：" + jqXHR.toString());
        }

    });

    function Renderer(data) {
        var str = "";
        console.log(data.length);
        //遍历数据
        $.each(data, function (index, element) {
           /* str += "<tr><td>" + element['name'] + "</td>" +
                "<td>" + element['department'] + "</td>" +
                "<td>" + element['post'] + "</td>" +
                "<td>" + element['frequency'] + "次" + "</td>" +
                "<td>" + element['totalTimes'] + "</td>" +
                "</tr>";*/


          //  console.log(element[imgPath]);

            str +=     "<div class=\"item\">\n" +
"                <div class=\"layui-fluid\">\n" +
"                <div class=\"layui-row\">\n" +
"                <div class=\"layui-col-xs12 layui-col-sm4 layui-col-md5\">\n" +
"              <div class=\"img\"><img src=\"../static/"+element['imgPath']+"\" alt=\"\"></div>\n" +
"                </div>\n" +
"                <div class=\"layui-col-xs12 layui-col-sm8 layui-col-md7\">\n" +
"                <div class=\"item-cont\">\n" +
"                <h3>" +element['articleTitle']+ //文章标题
"            <button class=\"layui-btn layui-btn-danger new-icon\">new</button>\n" +
"                </h3>\n" +
"                <h5>"+element['articleCategories']+"</h5>\n" +
"                <p>\n" +element['articleContent']+//文章内容
"                </p>\n" +
"            <a href=\"/details\" class=\"go-icon\"></a>\n" +
"                </div>\n" +
"                </div>\n" +
"                </div>\n" +
"                </div>\n" +
"                </div>";

        });

        //遍历完成之后
        console.log(str);
        //
      //  $('#list-item').html(str);
        $('#list-item').append(str);
    }

}