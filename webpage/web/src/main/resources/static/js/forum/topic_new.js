$(function() {
    /*
    回复
     */
    var E = window.wangEditor
    var editor2 = new E('.myEditor')
    editor2.create()

    /*
    标签
     */
    $('#topicTag').tagsInput({
        interactive: true,
        placeholder: '回车添加标签',
        // minChars: 2,
        // maxChars: 10, // if not provided there is no limit
        limit: 4, // if not provided there is no limit
        // validationPattern: new RegExp('^[a-zA-Z]+$'), // a pattern you can use to validate the input
        width: '500px', // standard option is 'auto'
        // height: '100px', // standard option is 'auto'
    });
});