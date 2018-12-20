$(function(){
    let sw1= false;
    let sw2= false;
    $('body').click(function(){
        $(".message-panel").hide();
        $(".user-panel").hide();
        sw1= false;
        sw2= false;
    });
    $('.message-panel').click(function (event) {event.stopPropagation();})
    $('.top-message').click(function (event) {
        event.stopPropagation();
        if(sw1){
            $('.message-panel').hide();
            sw1 = false;
        }else{
            $('.message-panel').show();
            sw1 = true;
        }
    })

    $('.user-panel').click(function (event) {event.stopPropagation();})
    $('.top-username').click(function (event) {
        event.stopPropagation();
        if(sw2){
            $('.user-panel').hide();
            sw2 = false;
        }else{
            $('.user-panel').show();
            sw2 = true;
        }
    })
});