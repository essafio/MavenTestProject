<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 22/09/2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="">
        <div class="container">
            <label><b>First Name</b></label>
            <input type="text" placeholder="First Name" name="fname" required><br>

            <label><b>Last Name</b></label>
            <input type="text" placeholder="Last Name" name="lname" required><br>

            <label><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" required><br>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required><br>

            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
            <input type="checkbox" checked="checked"> Remember me<br/>
            <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="reset"  class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
</body>
</html>
