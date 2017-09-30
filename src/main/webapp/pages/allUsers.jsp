<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 30/09/2017
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>

<html>
    <body>
        <div class="container">
            <br/><h2 class="offset-4 col-4">All users</h2><br/>
            <div class="table-responsive">
                <table border='1' class="table table-hover table-bordered">
                    <tr class="warning">
                        <th>Name</th>
                        <th>Email</th>
                        <th>Username</th>
                    </tr>
                    <c:forEach items="${it.users}" var="user">
                        <tr class="success">
                            <td>
                                <c:out value="${user.fname} ${user.lname}" />
                            </td>
                            <td>
                                <c:out value="${user.email}" />
                            </td>
                            <td>
                                <c:out value="${user.username}" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
