function isPhoneAvailable(phonevalue){
    var phoneReg = /^1[3-5,7,8]\d{9}$/;
    if(phoneReg.test(phonevalue)){
        return true;
    }else{
        return false;
    }
}
function isMailAvailable(mailvalue) {
    var mailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    if(mailReg.test(mailvalue)){
        return true;
    }else{
        return false;
    }
}

function passwordCheck(password) {
    if(password.length > 8) {
        return true;
    }else {
        return false;
    }
}

//重新封装layui的提示框，默认为居中提示框
function layuiTips(title,context) {
        layer.open({
            title:title,
            type: 1
            ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
            ,id: 'layerDemo' //防止重复弹出
            ,content: '<div style="padding: 20px 100px;">'+ context +'</div>'
            ,btn: '关闭'
            ,btnAlign: 'c' //按钮居中
            ,shade: 0 //不显示遮罩
            ,yes: function(){
                layer.closeAll();
            }
        });
}