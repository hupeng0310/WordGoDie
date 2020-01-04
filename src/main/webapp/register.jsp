<%--
  Created by IntelliJ IDEA.
  User: hupeng
  Date: 2019/12/30
  Time: 下午3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WordGoDie注册-新用户注册</title>
    <script src="script/jquery.js"></script>
    <script src="script/utils.js"></script>
    <script src="script/register.js"></script>
</head>
<body>
<div style="width: 300px;margin-left: 40%">
    <h2 style="margin-left: 50%">注册</h2>
    <p>邮箱：<input type="text" id="email"></p>
    <p>账号：<input type="text" id="account"></p>
    <p>密码：<input type="password" id="password"></p>
    <a href="login.jsp">已有账号？点此登陆</a>
    <p style="text-align: center"><input type="button" value="注册" onclick="register()"></p>
</div>
</body>
</html>
