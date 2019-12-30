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