<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap.min.css" rel="stylesheet">
        <link href="stil.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid" id="navbar">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><span style="color: white">ITravel</span></a>
                </div>


                <!--                 Collect the nav links, forms, and other content for toggling 
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                    <ul class="nav navbar-nav" id="ulNavbar">
                                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                                        <li><a href="#">Link</a></li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">Action</a></li>
                                                <li><a href="#">Another action</a></li>
                                                <li><a href="#">Something else here</a></li>
                                                <li role="separator" class="divider"></li>
                                                <li><a href="#">Separated link</a></li>
                                                <li role="separator" class="divider"></li>
                                                <li><a href="#">One more separated link</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                    <form class="navbar-form navbar-left">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                        </div>
                                        <button type="submit" class="btn btn-default">Submit</button>
                                    </form>-->

                <ul class="nav navbar-nav navbar-right">
                    <% 
                    HttpSession sesija1 = request.getSession();
                    if(sesija1.getAttribute("uspesnoUlogovan") != null) {
                    %>
                    <li><a href="profilKlijenta.jsp"><span style="color:white">Profil</span></a></li>
                    <li><a href="promenaLozinke.jsp"><span style="color:white">Promeni lozinku</span></a></li>
                        <% } %>
                    
                        <% 
                        String uloga1 = (String)sesija1.getAttribute("uloga");
                        if(sesija1.getAttribute("uspesnoUlogovan") != null && uloga1.equals("Menadzer")) {
                        %>
                    <li><a href="menadzerPanel.jsp"><span style="color:white">Menadzer</span></a></li>
                    <% } %>
                    <% 
                        if(sesija1.getAttribute("uspesnoUlogovan") != null && uloga1.equals("Admin")) {
                        %>
                    <li><a href="adminPanel.jsp"><span style="color:white">Admin</span></a></li>
                    <% } %>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color: rgba(128, 0, 255)"><span style="color:white">Prijava</span> <span class="caret" style="color:white"></span></a>
                        <ul class="dropdown-menu" style="background-color: rgba(128, 0, 255); border-color: white"> 
                         <%   if(sesija1.getAttribute("uspesnoUlogovan") == null) { %>
                            <li><a href="login.jsp" id="dropdownPrijava">Login</a></li>
                            <li><a href="signup.jsp" id="dropdownPrijava">Signup</a></li>
                            <li role="separator" ></li>
                            <% } %>
                            <li><a href="LogoutServlet" class="navbarHover" id="dropdownPrijava">Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <!--</div> /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>
    </body>
</html>
