function goExamination(type) {
    if(type == "completion") {
        window.location.href = "/WordGoDie/page?target=choiceexamination";
    } else if(type == "choice") {
        layuiTips("提示","此功能还在开发中，敬请期待")
    }else if(type == "limited") {
        layuiTips("提示","此功能还在开发中，敬请期待")
    } else {
        layuiTips("提示","此功能还在开发中，敬请期待")
    }
}

function showExamination() {
    var account = $("#account").text();
    $.get(
        "/WordGoDie/user/examinationinfo",
        {
            'account':Trim(account)
        },
        function (result) {
            var table = "<div class='table-div'><table class='layui-table' border='1' style='margin-left: 10px'><tr><th class='examination-tb'>账号</th><th class='examination-tb'>正确的题目</th><th class='examination-tb'>总题数</th><th style='width: 170px;height: 25px'>考试时间</th></tr>"
            for(var i = 0;i < result.length;i++) {
                table += "<tr><td class='examination-tb'>" + result[i].account + "</td><td class='examination-tb'>" + result[i].pass_topic+"</td><td class='examination-tb'>" + result[i].topic_num +"</td><td class='examination-tb'>" +result[i].hand_date +"</td></tr>"
            }
            table += "</table></div>";
            layer.open({
                title:['考试信息','text-align:center;'],
                type: 1,
                area: ['600px', '400px'],
                content: table //这里content是一个普通的String
            });
        },
    );

}
//擦除字符串前后端的空格
function Trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
