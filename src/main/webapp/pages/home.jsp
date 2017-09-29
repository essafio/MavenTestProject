<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 23/09/2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        <title>Home</title>
        <%@include file="head.jsp"%>
    </head>

    <%@include file="menu.jsp"%>

    <body>
        <div class="container"><br/>
            <div class="jumbotron">
                <c:forEach items="${it.users}" var="user">
                    ${user.fname}<br>
                </c:forEach>
                <br/><h1 class="offset-2 h1">Welcome to our web application! ${it.name}</h1><br/>
                <span class="offset-2">
                    <a class="col-4 btn btn-success btn-md" href="login.jsp" role="button">Sign in</a>
                    <a class="col-4 btn btn-primary btn-md" href="register.jsp" role="button">Sign up</a>
                </span>
            </div>
        </div>
    </body>
</html>
