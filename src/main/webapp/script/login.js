function login() {
    var account = $("#account").val();
    var password = $("#password").val();
    if(!isMailAvailable(account)&&!isPhoneAvailable(account)) {
        alert("请输入正确的邮箱或手机号码");
    }else if(!passwordCheck(password)) {
        alert("密码长度不得小于8位");
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
                        alert("账号不存在");
                        break;
                    case "passwordError":
                        alert("密码错误");
                        break;
                }
            }
        );
    }

}