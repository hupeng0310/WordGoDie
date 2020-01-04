function register() {
    var email = $("#email").val();
    var account = $("#account").val();
    var password = $("#password").val();
    if(!isMailAvailable(email)) {
        layuiTips("警告","请输入正确的电子邮箱");
    }else if(!isPhoneAvailable(account)){
        layuiTips("警告","请输入正确的手机号码");
    }else if(!passwordCheck(password)) {
        layuiTips("警告","密码长度不得小于8位");
    }else {
        $.post(
            "/WordGoDie/user/register",
            {
                "email":email,
                "account":account,
                "password":password
            },
            function (result) {
                var resultJson = jQuery.parseJSON(result);
                switch (resultJson.registerStatue) {
                    case "success":
                        window.location.href = "/WordGoDie/page?target=index";
                        break;
                    case "emailRegistered":
                        layuiTips("注册失败","该邮箱已被注册");
                        break;
                    case "accountRegistered":
                        layuiTips("注册失败","该手机号码已被注册");
                        break;
                    case "failed":
                        layuiTips("注册失败","发生了一个错误");
                }
            }
        );
    }
}