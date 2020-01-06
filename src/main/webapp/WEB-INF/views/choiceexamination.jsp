<%--
  Created by IntelliJ IDEA.
  User: 25096
  Date: 2020/1/4
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/examination.css">
    <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/script/examination.js"></script>
    <script src="${pageContext.request.contextPath}/script/layui/lay/modules/layer.js"></script>
    <script src="${pageContext.request.contextPath}/script/utils.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/script/layui/css/modules/layer/default/layer.css">
    <title>WordGoDie Examination -- 正在考试中</title>
</head>
<body>
    <div class="layui-container" style="background-color: #393D49;padding: 0px;margin-left: 0px;width: 100%;height: 70px">
        <div class="layui-row">
            <div class="layui-col-md3">
                <div style="color: white;font-size: 16px;margin-top: 24px;margin-left: 10px">
                    正在考试：${account==null?cookie.account.value:account}
                </div>
            </div>
            <div class="layui-col-md6">
                <div style="color: white;font-weight: bold;font-size: 30px;text-align: center;margin-top: 10px">
                    单词拼写考试
                </div>
            </div>
            <div class="layui-col-md3" style="text-align: center">
                <div style="margin-top: 14px">
                    <button class="layui-btn layui-btn-radius" style="background-color: #1E9FFF" onclick="handPaper()">
                        我要交卷
                    </button>
                </div>

            </div>
        </div>
    </div>

    <div>
        <div class="topicPanel">
        <div class="layui-card" style="background-color: #5FB878">
            <div class="layui-card-header topicPanelBody"id="incompleteWord"></div>
            <div class="layui-card-header topicPanelBody" id="partOfSpeech"></div>
            <div class="layui-card-header topicPanelBody" id="interpretation"></div>
            <div class="layui-card-body topicPanelBody" style="height: 80px">
                <input class="layui-input " style="border-radius: 10px;height: 80px;font-size: 35px;text-align: center" id= "answer">
            </div>
        </div>
        </div>
        </div>
        <div class="topicListPanel"></div>
        <div class="topicButtonPanel">
            <div style="margin-left: 20px;margin-top: 20px">
                <button class="layui-btn layui-btn-radius layui-btn-normal" style="width: 90px;float: left" onclick="getLastTopic()">上一题</button>
            </div>
            <div style="margin-right: 20px;margin-top: 20px">
                <button class="layui-btn layui-btn-radius layui-btn-normal" style="float: right;width: 90px" onclick="getTopic()"> 下一题</button>
            </div>
        </div>
    </div>
</body>
</html>
