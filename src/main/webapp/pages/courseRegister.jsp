<%--
  Created by IntelliJ IDEA.
  User: met409
  Date: 02-10-17
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>

<html>
<body>
<div class="container">
    <br/><h2 class="offset-4 col-4">Please choose courses</h2><br/>
    <form action="#" method="POST">
    <div class="table-responsive">
        <table border='1' class="table table-hover table-bordered">

            <tr class="warning">
                <th>Course</th>
                <th>Credits</th>
                <th>Check</th>
            </tr>

            <c:forEach items="${it.cours}" var="cours">

                <tr class="success">

                    <td>
                    <c:out value="${cours.name}" />
                    </td>

                    <td>
                     <c:out value="${cours.credits}" />
                    </td>

                    <td>
                    <%--<input class="form-check-input" type="checkbox" value="${cours}">--%>
                        <input class="" type="checkbox" value="${cours.id}">
                    </td>

                </tr>

            </c:forEach>

        </table>
    </div>
        <input name="register" type="submit" class="col-2 offset-10 btn btn-success btn-md" value="Register" disabled />
    </form>
</div>

</body>
</html>