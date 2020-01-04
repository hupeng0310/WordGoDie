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
