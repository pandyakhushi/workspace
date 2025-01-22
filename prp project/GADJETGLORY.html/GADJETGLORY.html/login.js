
function validation() {
    if (document.loginform.Username.value == "") {
        document.getElementById("final").innerHTML = "Enter Username*";
        return false;
    }
    else if (document.loginform.Username.value.length < 6) {
        document.getElementById("final").innerHTML = "Enter Atleast 6 letters*";
        return false;
    }

     else if (document.loginform.Email.value == "") {
            document.getElementById("final").innerHTML = "Enter valid email id*";
            return false;
        }
    
      else if (document.loginform.Password.value == "") {
            document.getElementById("final").innerHTML = "Enter password*";
            return false;
        }
    }