$(function () {
    var panel = $(".topicListPanel");
    $.get(
        "/WordGoDie/examination/topicnumber",
        function (result) {
            panel.innerHTML="";
            for(var i = 1; i <= result; i++) {
                panel.html(panel.innerHTML+= "<div class='topicImg'><div class='topicNumber' id = '"+ i+"' onclick='topicNumberClick(this.id)'>"+i+ "</div></div>");
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
    uploadAnswer();
    $.get(
        "/WordGoDie/examination/topic",
        function (result) {
            if(result.error != "endOfTopic") {
                setTopicPanel(result.incompleteWord,result.partOfSpeech,result.interpretation);
            } else {
                layuiTips("信息","这是最后一个单词啦");
            }
        }
    );
}



function getLastTopic() {
    uploadAnswer();
    $.get(
        "/WordGoDie/examination/lasttopic",
        function (result) {
            if(result.error != "topOfTopic") {
                setTopicPanel(result.incompleteWord,result.partOfSpeech,result.interpretation);
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

function topicNumberClick(id) {
    uploadAnswer();
    getTopicByIndex(id);
}
//提交答案
function uploadAnswer() {
    $.get(
        "/WordGoDie/examination/gettopicindex",
        function (index) {
            $.get(
                "/WordGoDie/examination/uploadanswer",
                {
                    'index':index -1,
                    'answer':$("#answer").val()
                }
            )
        }
    )
}
//交卷
function handPaper() {
    uploadAnswer();
    $.get(
        "/WordGoDie/examination/handpaper",
        function (score) {
            layuiTips("交卷","您一共做对"+score+"题");
        }
    )
}


//预先加载当前题号位置的题目
$(function () {
    $.get(
        "/WordGoDie/examination/gettopicindex",
        function (index) {
            getTopicByIndex(parseInt(index)+1);
        }
    )
});