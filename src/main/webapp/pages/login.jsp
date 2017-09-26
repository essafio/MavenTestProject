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
        <div class="container">
            <br/><h2 class="offset-4 col-4 h2">Please login</h2><br/>

            <form method="post" action="/login">
                <div class="col-4 offset-4">
                    <input class="form-control" type="text" placeholder="Username" name="username" required><br/>
                </div>

                <div class="col-4 offset-4">
                    <input class="form-control" type="password" placeholder="Password" name="psw" required><br/>
                </div>

                <button type="reset" class="offset-5 col-2 btn btn-success">Sign in</button>
            </form>
        </div>
    </body>

</html>
