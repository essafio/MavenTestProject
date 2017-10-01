<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 22/09/2017
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>

<html>
    <body>
        <div class="container">
            <br/><h2 class="offset-4 col-4 h2 text-success">${it.msg}</h2><br/>
            <br/><h2 class="offset-4 col-4 h2">Please login</h2><br/>

            <form method="POST" action="/monapp/login">
                <div class="col-4 offset-4">
                    <input class="form-control" type="text" placeholder="Username" name="username" value="${it.user.username}" required><br/>
                </div>

                <div class="col-4 offset-4">
                    <input class="form-control" type="password" placeholder="Password" name="password" required><br/>
                </div>

                <button type="submit" class="offset-5 col-2 btn btn-success">Sign in</button>
            </form>
        </div>
    </body>

</html>
