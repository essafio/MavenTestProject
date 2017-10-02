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
            <form method="POST" action="/monapp/users" id="registerForm">
                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>First Name</b></label>
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="First Name" name="fname" required autocomplete="off">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Last Name</b></label>
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="Last Name" name="lname" required autocomplete="off">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Email</b></label>
                    <div class="col-6">
                        <input class="form-control" type="email" placeholder="Enter Email" name="email" required autocomplete="off">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Username</b></label>
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="Username" name="username" required autocomplete="off">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Password</b></label>
                    <div class="col-6">
                        <input class="form-control" type="password" placeholder="Enter Password" name="password" required autocomplete="off">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 offset-2 col-form-label"><b>Repeat Password</b></label>
                    <div class="col-6">
                        <input class="form-control" type="password" placeholder="Repeat Password" name="psw_repeat" required autocomplete="off">
                    </div>
                </div>

                <div class="alert alert-success col-8 offset-2" role="alert" style="display: none;" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i></div>
                <div class="text-danger col-8 offset-2" id="error_message">${it.errormsg} </div>

                <button type="reset"  class="offset-2 col-4 btn btn-primary btn-md">Cancel</button>
                <input name="submitButton" type="submit" class="col-4 btn btn-success btn-md" value="Sign up" />
            </form>
        </div>
    </body>
</html>
