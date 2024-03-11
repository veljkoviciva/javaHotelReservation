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
        <title>Signup</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <fieldset id="fieldsetSignup">
                    <form id="formaSignup" method="post" action="SignupServlet">
                        <h1>Signup strana</h1>
                        <table>
                            <tr height="50px">
                                <td>Ime:</td>
                                <td><input type="text" name="ime" ></td>
                            </tr> 
                            <tr height="50px">
                                <td>Prezime:</td>
                                <td><input type="text" name="prezime" ></td>
                            </tr>
                            <tr height="50px">
                                <td>Datum rođenja:</td>
                                <td><input type="text" name="datumRodjenja" ></td>
                            </tr>
                            <tr height="50px">
                                <td>Korisnicko ime:</td>
                                <td><input type="text" name="korisnickoIme" ></td>
                            </tr>
                            <tr height="50px">
                                <td>Lozinka:</td>
                                <td><input type="password" name="lozinka" ></td>
                            </tr>
                        </table> 
                        <br><br>
                        <input type="submit" value="Signup">
                    </form>
                    
                    <p align="center" style="color: orange; font-size: 24px">
                        <%= request.getAttribute("poruka")!=null ? request.getAttribute("poruka") : "" %>
                    <p>
                </fieldset>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
