var divs=new Array();
divs[0]="errFirst";
divs[1]="errLast";
divs[2]="errEmail";
divs[3]="errUid";
divs[4]="errPwd";
divs[5]="errConfirm";

function validate(){
    var inputs=new Array();
    inputs[0]=document.getElementById('fname').value;
    inputs[1]=document.getElementById('lname').value;
    inputs[2]=document.getElementById('email').value;
    inputs[3]=document.getElementById('username').value;
    inputs[4]=document.getElementById('password').value;
    inputs[5]=document.getElementById('psw-repeat').value;

    var errors= new Array();
    errors[0]="<span>Please enter your First name!</span>";
    errors[1]="<span>Please enter your Last name!</span>";
    errors[2]="<span>Please enter your e-mail-id!</span>";
    errors[3]="<span>Please enter your User Id!</span>";
    errors[4]="<span>Please enter your Password!</span>";
    errors[5]="<span>Please enter your Confirm Password!</span>";

    for(i in inputs){
        var errMsg=errors[i];
        var divMsg=divs[i];
        if(inputs[i]=="") {
            document.getElementById(divMsg).innerHTML = errMsg;
        }
        else if(i==2){
            var atpos=inputs[i].indexOf("@");
            var dotpos=inputs[i].lastIndexOf(".");
            if(atpos<1 || dotpos<atpos+2 || dotpos+2>= inputs[i].length)
                document.getElementById('errEmail').innerHTML="<span>Enter valid e-mail adderss!!</span>";
            else
                document.getElementById(divMsg).innerHTML="OK!";
        }
        else if(i==5){
            var ff=document.getElementById('pwd').value;
            var ss=document.getElementById('confirm').value;
            if(ss!=ff)
                document.getElementById("errConfirm").innerHTML="<span>Your password does not match..!!</span>";
            else
                document.getElementById(divMsg).innerHTML="OK!";
        }
        else
            document.getElementById(divMsg).innerHTML="OK!";
    }
}

function finalValidate()
{
    var count = 0;
    for(i=0;i<6;i++){
        var divMsg = divs[i];

        if(document.getElementById(divMsg).innerHTML == "OK!")
            count = count + 1;
    }

    if(count == 6)
        document.getElementById("errFinal").innerHTML = "All the data you entered is correct!!!";
    else
        document.getElementById("errFinal").innerHTML="Please enter all the required fields.!!";
}