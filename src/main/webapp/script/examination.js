//预加载题目列表
$(function () {
    var panel = $(".topicListPanel");
    $.get(
        "/WordGoDie/examination/topicnumber",
        function (result) {
            panel.innerHTML="";
            for(var i = 1; i <= result; i++) {
                panel.html(panel.innerHTML+= "<div class='topicImg' id = '"+ i+"' onclick='topicNumberClick(this.id)' onmouseover=\"topicImgOnMouseOver(this.id)\" onmouseout=\"topicImgOnMouseOut(this.id)\"><div class='topicNumber'>"+i+ "</div></div>");
                if(i == (result -1)) {
                    panel.html(panel.innerHTML + "<div style='height: 25px;width: 180px'>&nbsp;sss</div>")
                }
            }
        }
    );
})


function setTopicPanel (incompleteWord,partOfSpeech,interpretation) {
    $("#incompleteWord").html(incompleteWord);
    $("#partOfSpeech").html(partOfSpeech);
    $("#interpretation").html(interpretation);
}


function getTopic() {
    clearAnswerInput();
    uploadAnswer();
    $.get(
        "/WordGoDie/examination/topic",
        function (result) {
            if(result.error != "endOfTopic") {
                setTopicPanel(result.incompleteWord,result.partOfSpeech,result.interpretation);
                onCheckedTopicNumberColor();
            } else {
                layuiTips("信息","这是最后一个单词啦");
            }
        }
    );

}



function getLastTopic() {
    clearAnswerInput();
    uploadAnswer();
    $.get(
        "/WordGoDie/examination/lasttopic",
        function (result) {
            if(result.error != "topOfTopic") {
                setTopicPanel(result.incompleteWord,result.partOfSpeech,result.interpretation);
                onCheckedTopicNumberColor();
            } else {
                layuiTips("信息","这是第一一个单词啦");
            }
        }
    );

}

function getTopicByIndex(index) {
    $.get(
        "/WordGoDie/examination/indexoftopic?index=" + index,
        function (result) {
            if(result.error == "outOfBounds") {
                layuiTips("警告","没有这个单词");
            } else {
                setTopicPanel(result.incompleteWord,result.partOfSpeech,result.interpretation);
            }
        }
    );
}

//点击按钮图标切换题目
function topicNumberClick(id) {
    clearAnswerInput();
    uploadAnswer();
    $.get(
        "/WordGoDie/examination/indexoftopic?index=" + id,
        function (result) {
            if(result.error == "outOfBounds") {
                layuiTips("警告","没有这个单词");
            } else {
                setTopicPanel(result.incompleteWord,result.partOfSpeech,result.interpretation);
                onCheckedTopicNumberColor();
            }
        }
    );
}
//提交答案
function uploadAnswer() {
    $.get(
        "/WordGoDie/examination/gettopicindex",
        function (index) {
            $.get(
                "/WordGoDie/examination/uploadanswer",
                {
                    'index':index,
                    'answer':$("#answer").val()
                }
            )
        }
    )
}

function handPaperButton() {
    layer.open({
        type: 1
        ,offset: 'auto'
        ,id: 'layerDemo'+'hanPaperButton' //防止重复弹出
        ,content: '<div style="padding: 20px 100px;"> 确认交卷？</div>'
        ,btn: '确认'
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
            handPaper();
        }
    });
}
//交卷功能
function handPaper() {
    $.get(
        "/WordGoDie/examination/gettopicindex",
        function (index) {
            $.get(
                "/WordGoDie/examination/uploadanswer",
                {
                    'index':index,
                    'answer':$("#answer").val()
                },
                function () {
                    $.get(
                        "/WordGoDie/examination/handpaper",
                             function (score) {
                                 layer.open({
                                     type: 1
                                     ,offset: 'auto'
                                     ,id: 'layerDemo'+'handPaper' //防止重复弹出
                                     ,content: '<div style="padding: 20px 100px;"> 交卷成功，您一共作对'+score+ '题</div>'
                                     ,btn: '确认'
                                     ,btnAlign: 'c' //按钮居中
                                     ,shade: 0 //不显示遮罩
                                     ,yes: function(){
                                         window.location.href = "/WordGoDie/page?target=index";
                                     }
                                 });
                             }
                    );
                }
            )
        }
    )
}


//初始化预先加载当前题号位置的题目
$(function () {
    $.get(
        "/WordGoDie/examination/gettopicindex",
        function (index) {
                getTopicByIndex(parseInt(index) + 1);
        }
    )
});

//主页刷新时当前被选择的题目题号变色
$(function () {
    onCheckedTopicNumberColor();
})

//修改当前被选择的题目题号颜色
function onCheckedTopicNumberColor() {
    $(".topicImg").css("background-color","#2F4056");
    $.get(
        "/WordGoDie/examination/gettopicindex",
        function (index) {
            $(".topicImg:eq(" + index+")").css("background-color","#FF5722");
        }
    )
}
//鼠标浮动题号变色
function topicImgOnMouseOver(id) {
    if($("#"+id).css("background-color") != "rgb(255, 87, 34)"){
        $("#"+id).css("background-color","#5FB878");
    }

}

function topicImgOnMouseOut(id) {
    if($("#"+id).css("background-color") != "rgb(255, 87, 34)"){
        $("#"+id).css("background-color","#2F4056");
    }
}

function clearAnswerInput() {
    $("#answer").val("");
}