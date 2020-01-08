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
    layer.open({
        title:['考试信息','text-align:center;'],
        type: 1,
        area: ['500px', '300px'],
        content: "<a href='http://www.baidu.com'>我草泥马</a>" //这里content是一个普通的String
    });
}
