<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 30/09/2017
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<html>
    <body>
        <div class="container">
            <br/><h2 class="offset-4 col-4">My profile</h2><br/>
            <div class="table-responsive">
                <table border='1' class="table table-hover table-bordered">
                    <tr>
                        <td>
                            Name
                        </td>
                        <td>
                            <c:out value="${it.user.fname} ${it.user.lname}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email
                        </td>
                        <td>
                            <c:out value="${it.user.email}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Username
                        </td>
                        <td>
                            <c:out value="${it.user.username}" />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
