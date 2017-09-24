<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 22/09/2017
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Login</title>
        <%@include file="head.jsp"%>
    </head>

    <%@include file="menu.jsp"%>

    <body>
        <form action="">
            <div class="container">

                <label><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" required><br>

                <label><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required><br>

                <div class="clearfix">
                    <button type="submit" class="">Sign In</button>
                </div>
            </div>
        </form>
    </body>
</html>
