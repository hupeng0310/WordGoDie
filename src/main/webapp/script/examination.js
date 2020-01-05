$(function () {
    $.get(
        "/WordGoDie/examination/topicnumber",
        function (result) {
            alert(result);
        }
    );
})