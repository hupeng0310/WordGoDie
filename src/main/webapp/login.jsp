<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>WordGoDie</title>
        <script src="script/jquery.js"></script>
        <script src="script/inputCheck.js"></script>
        <script src="script/login.js"></script>
    </head>
<body>
    <div style="width: 300px;margin-left: 40%">
        <h2 style="margin-left: 50%">登陆</h2>
        <p>账号：<input type="text" id="account" placeholder="邮箱或手机号码"></p>
        <p>密码：<input type="password" id="password"></p>
        <a href="register.jsp">还没有账号？点此注册</a>
        <p style="text-align: center"><input type="button" value="登陆" onclick="login()"></p>
    </div>
</body>
</html>
