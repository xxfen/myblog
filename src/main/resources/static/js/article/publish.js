function publishArticle() {
    var articleTitle = document.getElementById("xxf-editor-title").value;
    // var articleContent = $('#my-editormd-html-code').val();
    // var articleContent = $('#my-editormd-markdown-doc').val();
    // var articleContent = $('.my-editormd-html-code').val();
    var articleContent = testEditor.getMarkdown();
    var tags = $('#tagsinputval').val();
    var categories = document.getElementById("select-categories").value;
    var imgUrl = document.getElementById("articleImgUrl").value;
    // var categories = document.getElementById("xxf-editor-title").value;

    if (articleTitle.length === 0) {
        showHint("hint-title-no");
        return;
    }
    console.log("文章内容:" + articleContent + ";");
    if (articleContent.length === 0) {
        showHint("hint-content-no");
        return;
    }
    console.log("文章标签:" + tags + ";");
    if (tags === 0) {
        showHint("hint-tags-no");
        return;
    }
    console.log("文章分类:" + categories + ";");
    if (categories === "choose") {
        showHint("hint-categories-no");
        return;
    }
    console.log("文章封面链接:" + imgUrl + ";");
    if (imgUrl.length === 0) {
        showHint("hint-coverImgUrl-no");
        return;
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: 'article/publishArticle',
        //请求头加token
        /* beforeSend: function (request) {
             request.setRequestHeader("token", getCookie("token"));
         },*/
        contentType: "application/json",
        data: JSON.stringify({
            "articleTitle": articleTitle,
            "imgPath": imgUrl,
            "articleContent": articleContent,
            "articleTags": tags,
            "articleCategories": categories
        }),
        success: function (data) {
            console.log("data is :" + data);
        },
        error: function (jqXHR) {

            // console.log("发生错误：" + jqXHR.toString());
        }

    });

}

//弹出隐藏层
function ShowDiv(show_div, bg_div) {
    document.getElementById(show_div).style.display = 'block';
    document.getElementById(bg_div).style.display = 'block';
    var bgdiv = document.getElementById(bg_div);
    bgdiv.style.width = document.body.scrollWidth;
    // bgdiv.style.height = $(document).height();
    $("#" + bg_div).height($(document).height());
};

//关闭弹出层
function CloseDiv(show_div, bg_div) {
    document.getElementById(show_div).style.display = 'none';
    document.getElementById(bg_div).style.display = 'none';
};


function showHint(show_div) {
    document.getElementById(show_div).style.display = 'block';
    setTimeout(function () {
        document.getElementById(show_div).style.display = 'none';

    }, 2000);

}