<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>WordGoDie</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/layui.css"  media="all">
        <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/script/utils.js"></script>
        <script src="${pageContext.request.contextPath}/script/login.js"></script>
<%--     单独引用layer组件   --%>
        <script src="${pageContext.request.contextPath}/script/layui/lay/modules/layer.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/modules/layer/default/layer.css">
    </head>
<body background="${pageContext.request.contextPath}/img/login.jpeg">
    <div style="padding: 20px; margin-left: 34%;margin-top:12%; width: 500px ;background: rgba(0,0,0,0.1)">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header" style="text-align: center;font-weight: bold">登录WordGoDie - - 登录</div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <label class="layui-form-label">账号:</label>
                            <div class="layui-input-inline">
                                <input style="width: 240px" class="layui-input" type="text" id="account" placeholder="邮箱或手机号码">
                            </div>
                        </div>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input style="width: 240px" class="layui-input" type="password" id="password">
                            </div>
                        </div>
                    </div>
                    <div class="layui-card-body">
                        <a href="register.jsp">还没有账号？点此注册</a>
                    </div>
                    <div class="layui-card-body" style="text-align: center">
<%--                        <p style="text-align: center"><input type="button" value="登陆" onclick="login()"></p>--%>
                        <button type="button" class="layui-btn" onclick="login()">登录</button>
                    </div>
                 </div>
            </div>
        </div>
    </div>
</body>
</html>
