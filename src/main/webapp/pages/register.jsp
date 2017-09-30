<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 22/09/2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>


    <body>
        <div class="container">
            <br/><h2 class="offset-2 h2">Please enter your information</h2><br/>
            <form method="POST" action="/monapp/users">
                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>First Name</b></label>
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="First Name" name="fname" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Last Name</b></label>
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="Last Name" name="lname" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Email</b></label>
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="Enter Email" name="email" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Username</b></label>
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="Username" name="username" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Password</b></label>
                    <div class="col-6">
                        <input class="form-control" type="password" placeholder="Enter Password" name="password" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Repeat Password</b></label>
                    <div class="col-6">
                        <input class="form-control" type="password" placeholder="Repeat Password" name="psw-repeat" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2"></label>
                    <div class="col-6">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="offset-2 form-check-input" type="checkbox" checked="checked"> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <button type="reset"  class="offset-2 col-4 btn btn-primary btn-md">Cancel</button>
                <button type="submit" class="col-4 btn btn-success btn-md">Sign Up</button>
            </form>
        </div>
    </body>
</html>
