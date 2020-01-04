function login() {
    var account = $("#account").val();
    var password = $("#password").val();
    if(!isMailAvailable(account)&&!isPhoneAvailable(account)) {
        layuiTips("警告","请输入正确的邮箱或密码");
    }else if(!passwordCheck(password)) {
        layuiTips("警告","密码长度不得小于8位");
    }else{
        $.post(
            "/WordGoDie/user/login",
            {
                "account":account,
                "password":password
            },
            function (result) {
                var resultJson = jQuery.parseJSON(result);
                switch (resultJson.loginStatue) {
                    case "success":
                        window.location.href = "/WordGoDie/page?target=index";
                        break;
                    case "accountNotFound":
                        layuiTips("登录错误","账号不存在");
                        break;
                    case "passwordError":
                        layuiTips("登录错误","密码错误");
                        break;
                }
            }
        );
    }

}