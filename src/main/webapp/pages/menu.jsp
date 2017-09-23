<%--
  Created by IntelliJ IDEA.
  User: Oussama
  Date: 23/09/2017
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>

<header>
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">Welcome</a>
                <a style="color: lightseagreen" href="#" class="navbar-brand">
                        ${clientConnecte.nom} ${clientConnecte.prenom}
                </a>
            </div>
            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li> <a href="/home"> Home </a> </li>
                    <li> <a href="login.jsp">Login  </a> </li>
                    <li> <a href="register.jsp">Register  </a> </li>
                    <li> <a href="#">Logout  </a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
