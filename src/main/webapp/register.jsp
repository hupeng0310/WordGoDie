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
    <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/script/utils.js"></script>
    <script src="${pageContext.request.contextPath}/script/register.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/layui.css"  media="all">
    <%--     单独引用layer组件   --%>
    <script src="${pageContext.request.contextPath}/script/layui/lay/modules/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/modules/layer/default/layer.css">
</head>
<body background="${pageContext.request.contextPath}/img/register.jpg">
    <div style="padding: 20px; margin-left: 34%;margin-top:12%; width: 500px ;background: rgba(0,0,0,0.1)">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header" style="text-align: center;font-weight: bold">加入WordGoDie - - 注册</div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱:</label>
                            <div class="layui-input-inline">
                                <input style="width: 240px" class="layui-input" type="text" id="email">
                            </div>
                        </div>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <label class="layui-form-label">账号:</label>
                            <div class="layui-input-inline">
                                <input style="width: 240px" class="layui-input" type="text" id="account">
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
                        <a href="${pageContext.request.contextPath}/login.jsp">已有账号？点此登录</a>
                    </div>
                    <div class="layui-card-body" style="text-align: center">
                        <button type="button" class="layui-btn" onclick="register()">注册</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
