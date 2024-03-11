<%-- 
    Document   : menadzerPanel
    Created on : Jun 22, 2023, 6:38:15 AM
    Author     : Milija
--%>

<% 
    HttpSession sesija = request.getSession();
    
    String uloga = (String)sesija.getAttribute("uloga");
    
    if(sesija.getAttribute("uspesnoUlogovan") == null || uloga==null || !uloga.equals("Menadzer")) 
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
        <title>Menadzer panel</title>
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
                    <h2>Lista rezervacija po hotelu određenog menadžera</h2>

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
                      /**/
                        String slovniID = String.valueOf(r.getIDSobe());
                        String deoSlovnogID = slovniID.substring(0, 4);
                        /**/  
                        
                        if(deoSlovnogID.equals("3002")==true && (int)sesija.getAttribute("uspesnoUlogovan")==6) {
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
                            <% }
  if (deoSlovnogID.equals("3001")==true &&(int)sesija.getAttribute("uspesnoUlogovan")==5) {
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
                            <% }
                       if(deoSlovnogID.equals("3003")==true && (int)sesija.getAttribute("uspesnoUlogovan")==7) {
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
                            <%  }} %>
                    </table>
                    <br>
                </form>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
