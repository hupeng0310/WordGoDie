$(function () {
    var panel = $(".topicListPanel");
    $.get(
        "/WordGoDie/examination/topicnumber",
        function (result) {
            alert(result);
            panel.innerHTML="";
            for(var i = 1; i <= result; i++) {
                panel.html(panel.innerHTML+= "<div class='topicImg'><div class='topicNumber'>"+i+ "</div></div>");
            }
        }
    );
})