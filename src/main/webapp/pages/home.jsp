<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 23/09/2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="head.jsp"%>
</head>

<%@include file="menu.jsp"%>

<body>
<div class="container">
    <div class="jumbotron">
        <h1>Welcome to our web application!</h1>
        <div class="col-md-6 col-md-offset-3">
            <p class="col-md-3" ><a class="btn btn-success btn-lg" href="login.jsp" role="button">Sign in</a></p>
            <p class="col-md-3" ><a class="btn btn-primary btn-lg" href="register.jsp" role="button">Sign up</a></p>
        </div>
    </div>
</div>
</body>
</html>
