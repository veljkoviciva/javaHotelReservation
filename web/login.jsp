<%-- 
    Document   : login
    Created on : Jun 20, 2023, 2:57:34 AM
    Author     : Milija
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <fieldset id="fieldsetLogin">
                    <form id="formaLogin" action="LoginServlet" method="post">
                        <h1>Login strana</h1>
                        <!--Dodat red--><input type="hidden" name="idKorisnika">
                        <!--Dodat red--><input type="hidden" name="datumRodjenja">
                        <table>
                            <tr height="50px">
                                <td>Korisnicko ime:</td>
                                <td><input type="text" name="korisnickoIme" ></td>
                            </tr>
                            <tr>
                                <td>Lozinka:</td>
                                <td><input type="password" name="lozinka" ></td>
                            </tr>
                        </table>
                        <br><br>
                        <input type="submit" value="Login">
                    </form>
                    
                    <p align="center" style="color: orange; font-size: 24px">
                        <%= request.getAttribute("poruka")!=null ? request.getAttribute("poruka") : "" %>
                    </p>
                        
                </fieldset>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
