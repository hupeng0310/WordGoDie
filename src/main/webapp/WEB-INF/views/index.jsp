<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WordGoDie 云端学习</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/modules/layer/default/layer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/script/layui/lay/modules/layer.js"></script>
    <script src="${pageContext.request.contextPath}/script/utils.js"></script>
    <script src="${pageContext.request.contextPath}/script/index.js"></script>
</head>
<body background="${pageContext.request.contextPath}/img/index.jpg" >
    <div class="layui-container" style="background-color: #1E9FFF;padding: 0px;margin-left: 0px;width: 100%;height: 70px">
        <div class="layui-row">
            <div class="layui-col-md3">
                &nbsp;
            </div>
            <div class="layui-col-md6" style="font-size: 30px;font-weight: bold;color: white; margin-top: 10px">
                <div style="margin-left: 180px">WordGoDie 高效学习</div>
            </div>
            <div class="layui-col-md3" style="margin-top: 10px">
                <div>欢迎您&nbsp;${account==null?cookie.account.value:account}
                </div>
                <div style="margin-top: 10px;margin-left: 90px">
                    <a href="${pageContext.request.contextPath}/user/logout">退出</a>
                </div>
            </div>
        </div>
    </div>
    <div class="function-container" style="margin-top: 250px">
        <div class="function-panel" style="margin-left: 300px">
            <div class="function-tips">
                单词拼写<br/>
                补全部分单词

            </div>
            <button type="button" class="layui-btn layui-btn-lg layui-btn-primary layui-btn-radius" style="background-color: white" onclick="goExamination('completion')">开始测试</button>
        </div>
        <div class="function-panel">
            <div class="function-tips">
                单词翻译<br/>
                单项选择单词释义
            </div>
            <button type="button" class="layui-btn layui-btn-lg layui-btn-primary layui-btn-radius" style="background-color: white" onclick="goExamination('choice')">开始测试</button>
        </div>
        <div class="function-panel">
            <div class="function-tips">
                限时测试<br/>
                共计五十题
            </div>
            <button type="button" class="layui-btn layui-btn-lg layui-btn-primary layui-btn-radius" style="background-color: white" onclick="goExamination('limited')">开始测试</button>
        </div>
    </div>
</body>
</html>
