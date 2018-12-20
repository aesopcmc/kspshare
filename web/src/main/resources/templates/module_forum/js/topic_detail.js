$(function() {
    /*
    回复
     */
    var E = window.wangEditor
    var editor2 = new E('.myEditor')
    editor2.create()

    /*
    分页
     */
    $("#pagination3").pagination({
        currentPage: 4,
        totalPage: 16,
        isShow: true,
        count: 7,
        homePageText: "首页",
        endPageText: "尾页",
        prevPageText: "上一页",
        nextPageText: "下一页",
        callback: function(current) {
            $("#current3").text(current)
        }
    });
    $("#pagination4").pagination({
        currentPage: 4,
        totalPage: 16,
        isShow: true,
        count: 7,
        homePageText: "首页",
        endPageText: "尾页",
        prevPageText: "上一页",
        nextPageText: "下一页",
        callback: function(current) {
            $("#current3").text(current)
        }
    });

    $("#getPage").on("click", function() {
        var info = $("#pagination3").pagination("getPage");
        alert("当前页数：" + info.current + ",总页数：" + info.total);
    });

    $("#setPage").on("click", function() {
        $("#pagination3").pagination("setPage", 1, 10);
    });

});