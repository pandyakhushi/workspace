function validation() {
    if (document.formfill.Username.value == "") {
        document.getElementById("result").innerHTML="Enter Username*";
        return false;
    }
    else if (document.formfill.Username.value.length < 6) {
        document.getElementById("result").innerHTML = "Enter Atleast 10 letter*";
        return false;
    }
        else if (document.formfill.Email.value == "") {
             document.getElementById("result").innerHTML = "Enter your valid Email*";
            return false;
        }
    else if (document.formfill.Password.value == "") {
            document.getElementById("result").innerHTML = "Enter your Password*";
            return false;
        }
        else if (document.formfill.Password.value.length <8) {
            document.getElementById("result").innerHTML = "Password must be 8-digits*";
            return false;
        }
         else if (document.formfill.cpassword.value == "") {
             document.getElementById("result").innerHTML = "Enter Confirm Password*";
            return false;
        }
        else if (document.formfill.Password.value !== document.formfill.cpassword.value) {
             document.getElementById("result").innerHTML = "Password doesn't matched*";
            return false;
        }
    }
