var articleId = "";


$.ajax({
    type: 'HEAD', // 获取头信息，type=HEAD即可
    url: window.location.href,
    async: false,
    success: function (data, status, xhr) {
        articleId = xhr.getResponseHeader("articleId");
    }
});

//通过文章id请求文章信息
$.ajax({
    type: 'get',
    url: '/article/' + articleId,
    dataType: 'json',
    async: false,
    data: {
        // id: articleId,
    },
    success: function (data) {

        if (data.code === 200) {
            putInArticle(data.result);
        } else {
            $('.content').html('');
            var error = $('<div class="article"><div class="zhy-article-top"><div class="error">' +
                '<img src="https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/static/img/register_success.jpg">' +
                '<p>没有找到这篇文章哦</p>' +
                /*  '<p>可能不小心被博主手残删掉了吧</p>' +*/
                '<div class="row">' +
                '<a href="/">返回首页</a>' +
                '</div>' +
                '</div></div></div>');
            $('.content').append(error);
        }
    },
    error: function () {

    }
});

//填充文章
function putInArticle(data) {
    // todo
    var articleTop = '<div class="title">\n' +
        '        <h3>' + data.articleTitle + '</h3>\n' +
        '        <p class="cont-info"><span class="data">' + data.publishDate + '</span><span class="types">' + data.articleCategories + '</span></p>\n' +
        '    </div>';
    console.log(articleTop);
    console.log(data.articleContent);
    $("#details_title").html(articleTop);

    $("#doc-content").html(data.articleContent);
    //articleEditor.text(data.articleContent);
}