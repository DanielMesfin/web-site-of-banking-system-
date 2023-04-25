var password=document.getElementById("password");
var confirmPassword=document.getElementById("cPassword");
function checkPassword(){
    if(password!==confirmPassword){
        window.alert("Please check you password");
        password.alert("Miss Matched Password");
        window.location.href=null;
    }
    
}
