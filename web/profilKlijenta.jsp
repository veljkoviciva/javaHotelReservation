<%-- 
    Document   : profilKlijenta
    Created on : Jun 21, 2023, 2:27:44 PM
    Author     : Milija
--%>
<% 
    HttpSession sesija = request.getSession();
    
    if(sesija.getAttribute("uspesnoUlogovan") == null) 
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
        <title>Profil</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="navbar.jsp" %>
                <form method="post" action="ProfilKlijentaServlet" id="formProfilKlijenta">
                    
                    <% 
                        int id = (int)sesija.getAttribute("uspesnoUlogovan");
                        Klijent k = Queries.podaciOKlijentu(id);
                    %>
                    
                    <h2><strong>Profil korisnika</strong></h2>
                    <hr>
                    <table id="tabelaProfilKlijenta" height="300px">
                        <tr>
                            <td>ID:</td>
                            <td><%= id %></td>
                        </tr>
                        <tr>
                            <td>Korisničko ime:</td>
                            <td><%= sesija.getAttribute("korisnickoIme")%></td>
                        </tr>
                        <tr>
                            <td>Lozinka:</td>
                            <td><input type="password" value="<%= sesija.getAttribute("lozinka")%>" readonly></td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td><%= sesija.getAttribute("uloga")%></td>
                        </tr>
                        <tr>
                            <td>Datum rođenja:</td>
                            <td><%= k.getDatumRodjenja() %></td>
                        </tr>
                        <tr> 
                            <td>Broj poena:</td>
                            <td><%= k.getBrojPoena() %></td>
                        </tr>
                    </table><br>
                    
                    
                    <h3>Rezervacije: </h3>
                    <table border="1" align="center" style="border: 3px solid darkmagenta; background: gray; color: white">
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
                        ArrayList<Rezervacija> sveRezervacije = Queries.sveRezervacijePoKorisniku((int)sesija.getAttribute("uspesnoUlogovan"));
                        for(Rezervacija r:sveRezervacije) {
                            Klijent klijent = Queries.podaciOKlijentu((int)sesija.getAttribute("uspesnoUlogovan"));  
                            
                        %>
                        <tr height="50px">
                            <td align="center"><%= r.getIDRezervacije() %></td>
                            <td align="center"><%= r.getIDKlijenta() %></td>
                            <td align="center"><%= klijent.getImeKlijenta() %></td>
                            <td align="center"><%= klijent.getPrezimeKlijenta() %></td>
                            <td align="center"><%= klijent.getDatumRodjenja() %></td>
                            <td align="center"><%= klijent.getBrojPoena() %></td>
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
                </form>
                        <br>
                <%@include file="footer.jsp" %>
            </div>
        </div>
    </body>
</html>
