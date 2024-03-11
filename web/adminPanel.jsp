<%-- 
    Document   : adminPanel
    Created on : Jun 22, 2023, 6:16:10 AM
    Author     : Milija
--%>

<% 
    HttpSession sesija = request.getSession();
    
    String uloga = (String)sesija.getAttribute("uloga");
    
    if(sesija.getAttribute("uspesnoUlogovan") == null || uloga==null || !uloga.equals("Admin")) 
        response.sendRedirect("index.jsp");
 

%>
<%@page import="Baza.Queries"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin panel</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="navbar.jsp" %>
                
                <p align="center" style="color: orange; font-size: 24px">
                        <%= request.getAttribute("poruka")!=null ? request.getAttribute("poruka") : "" %>
                    </p>
                        
                
                <form id="formAdminPanel">
                    <fieldset align="center" height="50px">
                        <a href="insertSoba.jsp" id="btnInsertSoba">Kreiraj sobu</a>
                    </fieldset>
                    
                    <hr>
                    <h2>Lista rezervacija</h2>

                    <table border="1" align="center" style="border: 3px solid darkmagenta; color: white">
                        <th height="100px">ID rezervacije</th>
                        <th height="100px">ID klijenta</th>
                        <th height="100px">Ime klijenta</th>
                        <th height="100px">Prezime klijenta</th>
                        <th height="100px">Datum rođenja</th>
                        <th height="100px">Ukupan broj poena</th>
                        <th height="100px">ID sobe</th>
                        <th height="100px">Početak rezervacije</th>
                        <th height="100px">Kraj rezervacije</th>

                        <% 
                        ArrayList<Rezervacija> sveRezervacije = Queries.sveRezervacije();
                        for(Rezervacija r:sveRezervacije) {
                            Klijent k = Queries.podaciOKlijentu(r.getIDKlijenta());  
                            
                        %>
                        <tr height="50px">
                            <td align="center"><%= r.getIDRezervacije() %></td>
                            <td align="center"><%= r.getIDKlijenta() %></td>
                            <td align="center"><%= k.getImeKlijenta() %></td>
                            <td align="center"><%= k.getPrezimeKlijenta() %></td>
                            <td align="center"><%= k.getDatumRodjenja() %></td>
                            <td align="center"><%= k.getBrojPoena() %></td>
                            <td align="center"><%= r.getIDSobe() %></td>
                            <td align="center"><%= r.getDatumPocetka() %></td>
                            <td align="center"><%= r.getDatumKraja() %></td>
                            <td align="center" style="border: none">
                                <a href="DeleteRezervacijuServlet?id=<%= r.getIDRezervacije() %>" id="btnIzbrisiRezervaciju">Izbrisi</a>
                            </td>
                        <tr>
                           <% } %> 
                    </table>
                    
                    <hr>
                    
                    <h2>Lista klijenata</h2>
                    <table border="1" align="center" style="border: 3px solid darkmagenta; color: white">
                        <th height="100px">ID klijenta</th>
                        <th height="100px">Ime klijenta</th>
                        <th height="100px">Prezime klijenta</th>
                        <th height="100px">Datum rođenja</th>
                        <th height="100px">Korisničko ime</th>
                        <th height="100px">Ukupan broj poena</th>
                        <th height="100px">Uloga</th>
                        

                        <% 
                        ArrayList<Klijent> sviKlijenti = Queries.listaKlijenata();
                            for(Klijent k:sviKlijenti) {     
                        %>
                        <tr height="50px">
                            <td align="center"><%= k.getIDKlijenta() %></td>
                            <td align="center"><%= k.getImeKlijenta() %></td>
                            <td align="center"><%= k.getPrezimeKlijenta() %></td>
                            <td align="center"><%= k.getDatumRodjenja() %></td>
                            <td align="center"><%= k.getKorisnickoIme() %></td>
                            <td align="center"><%= k.getBrojPoena() %></td>
                            <td align="center"><%= k.getUloga() %></td>
                            <td align="center" style="border: none">
                               <% Klijent jedanKlijent = Queries.jedanKlijent(k.getIDKlijenta());
                               int k1 = jedanKlijent.getIDKlijenta();
//                                   int id = (int)k.getIDKlijenta(); 
                                    if(!(k1==4) && !(k1==5) && !(k1==6) && !(k1==7)) { %>
                                <a href="DeleteKlijentaServlet?id=<%= k.getIDKlijenta() %>" id="btnIzbrisiKlijenta">Izbrisi</a>
                                <% } %>
                                <a href="promeniUlogu.jsp?id=<%= k.getIDKlijenta() %>&uloga=<%= k.getUloga() %>" id="btnIzmeniKlijenta">Promeni ulogu</a>
                            </td>
                        <tr>
                           <% } %> 
                    </table>
                    <br>
                </form>
                    <br>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
