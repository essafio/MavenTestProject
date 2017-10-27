<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 23/09/2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>

<html>
    <body>
        <div class="container"><br/>
            <div class="jumbotron">
                <br/><center><h2 class="h2">Welcome to our course platform</h2></center><br/>
                <c:if test="${empty sessionScope.user.fname}">
                    <span class="offset-2">
                        <a class="col-4 btn btn-success btn-md" href="/monapp/login" role="button">Sign in</a>
                        <a class="col-4 btn btn-primary btn-md" href="/monapp/register" role="button">Sign up</a>
                    </span>
                </c:if>
            </div>
        </div>
    </body>
</html>
