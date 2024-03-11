<%-- 
    Document   : promenaSifre
    Created on : Jun 21, 2023, 3:29:15 AM
    Author     : Milija
--%>

<%
    HttpSession sesija = request.getSession();
    
    if(sesija.getAttribute("uspesnoUlogovan") == null) {
    System.out.println("Nije proslo");
        response.sendRedirect("index.jsp");
    } 
        
    else
        System.out.println("Uspelo je");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promena lozinke</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <fieldset id="fieldsetLogin">
                    <form id="formaLogin" action="PromeniLozinkuServlet" method="post">
                        <h1>Login strana</h1>
                        <table>
                            <tr height="50px">
                                <td>Korisnicko ime:</td>
                                <td><input type="text" name="tbKorisnickoIme"></td>
                            </tr>
                            <tr>
                                <td>Trenutna lozinka:</td>
                                <td><input type="password" name="tbTrenutnaLozinka"></td>
                            </tr>
                            <tr>
                                <td>Nova lozinka:</td>
                                <td><input type="password" name="tbNovaLozinka"></td>
                            </tr>
                        </table>
                        <br><br>
                        <input type="submit" value="Promena lozinke">
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
