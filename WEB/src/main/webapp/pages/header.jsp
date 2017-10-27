<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 23/09/2017
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<html>
<head>
    <title>Web App</title>
    <%@include file="head.jsp"%>
</head>

<header>
    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a href="/" class="navbar-brand">Welcome <span class="text-success"> ${sessionScope.user.fname} ${sessionScope.user.lname}</span> </a>
        <div id="navbarText" class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"> <a class="nav-link" href="/"> Home </a> </li>
                <c:if test="${empty sessionScope.user.fname}">
                    <li class="nav-item"> <a class="nav-link" href="/monapp/login">Login  </a> </li>
                    <li class="nav-item"> <a class="nav-link" href="/monapp/register">Register  </a> </li>
                </c:if>
                <c:if test="${not empty sessionScope.user.fname}">
                    <li class="nav-item"> <a class="nav-link" href="/monapp/courseRegister">Course registration</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="/monapp/users">All users</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="/monapp/logout">Logout  </a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>