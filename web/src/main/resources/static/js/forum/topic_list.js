$(function() {
    // $("#pagination1").pagination({
    //     currentPage: 1,
    //     totalPage: 12,
    //     callback: function(current) {
    //         $("#current1").text(current)
    //     }
    // });
    //
    // $("#pagination2").pagination({
    //     currentPage: 3,
    //     totalPage: 12,
    //     isShow: false,
    //     count: 6,
    //     prevPageText: "< 上一页",
    //     nextPageText: "下一页 >",
    //     callback: function(current) {
    //         $("#current2").text(current)
    //     }
    // });

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

    //提示
    $("[data-tooltip]").darkTooltip({
        animation:'fadeIn',
        gravity:'south',
        theme:'dark',
        trigger:'hover',
        size: 'small',
        // opacity 透明度 0-1 0.9
        // content Tooltip message 工具提示消息 空
        // size    small, medium, large 小型、 中型、 大型 介质
        // gravity south, west, north, east 重力 南、 西、 北、 东 南
        // theme   主题   dark, light 暗，光 黑暗
        // trigger 触发器 hover, click 将鼠标悬停，请单击 悬停
        // animation 动画 无，flipIn，fadeIn false
        // confirm 确认 为 true，false false
        // yes   是 标签为 Yes 选项的 ' 是 '
        // no   '没有' 选项标签 否
        // finalMessage 在确认的操作结束时显示的消息 ''
    });
});