function register() {
    var email = $("#email").val();
    var account = $("#account").val();
    var password = $("#password").val();
    if(!isMailAvailable(email)) {
        alert("请输入正确的电子邮箱");
    }else if(!isPhoneAvailable(account)){
        alert("请输入正确的手机号码");
    }else if(!passwordCheck(password)) {
        alert("密码长度不得小于8位");
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
                        alert("该邮箱已注册");
                        break;
                    case "accountRegistered":
                        alert("该手机号码已注册");
                        break;
                    case "failed":
                        alert("注册失败");
                }
            }
        );
    }
}