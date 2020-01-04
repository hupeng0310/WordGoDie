<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WordGoDie 更便捷得背单词</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/layui.css"  media="all">
    <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/script/layui/lay/modules/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/modules/layer/default/layer.css">
</head>
<body style="background-color: #1E9FFF">
    <div class="layui-container" style="background-color: #FF5722;padding: 0px;margin-left: 0px;width: 100%;height: 70px">
        <div class="layui-row">
            <div class="layui-col-md3">
                &nbsp;
            </div>
            <div class="layui-col-md6" style="font-size: 30px;font-weight: bold;color: white; margin-top: 10px">
                <div style="margin-left: 180px">WordGoDie 云上学习</div>
            </div>
            <div class="layui-col-md3" style="margin-top: 10px">
                <div>欢迎您&nbsp;${account}</div>
                <div style="margin-top: 10px;margin-left: 90px">
                    <a href="${pageContext.request.contextPath}/user/logout">退出</a>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
