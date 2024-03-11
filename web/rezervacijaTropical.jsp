<%-- 
    Document   : rezervacija
    Created on : Jun 21, 2023, 2:17:09 PM
    Author     : Milija
--%>

<%@page import="Baza.Queries"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rezervacija</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="navbar.jsp" %>
                <form action="rezervacijaUgovor.jsp" method="post">
                    <% 
                        HttpSession sesija = request.getSession();
    
                        if(sesija.getAttribute("uspesnoUlogovan") == null) { %>
                    <p align="center" style="color: orange; font-size: 30px">
                        Da biste mogli da rezervišete sobu, potrebno je da se ulogujete ili kreirate nalog.
                    </p>
                    <% } else {%>
                    <div class="row">
                        <div class="col-md-4">
                            <h1>Hotel Tropical</h1>
                            <img src="Slike/Hotel4.jpg" width="250" height="250" id="HotelTropicalImg">

                        </div>

                        <div class="col-md-8" >
                            <br><br><br>
                            <h4 style="background: lightblue; border-bottom: 5px solid mediumslateblue;
                                border-left: 5px solid mediumslateblue; border-top:  5px solid mediumslateblue;">
                                Hotel Tropical se nalazi u Paraliji. Hotel u ponudi ima bazen,
                                ali ne i parking. Nalazi se na 20m od plaže.
                            </h4>
                        </div>
                    </div>
                    <hr>
                    <h3>Rezervacija:</h3>


                    <table border="1" style="color: white">
                        <th width="100px">ID sobe</th>
                        <th width="100px">Broj sobe</th>
                        <th width="150px">Tip sobe</th>
                        <th width="100px">Broj sprata</th>
                        <th width="100px">ID hotela</th>
                        <th width="100px">Klima</th>
                        <th width="100px">Sporet</th>
                        <th width="100px">Terasa</th>
                        <th width="100px">Sef</th>

                        <% 
                            ArrayList<Soba> sveSobe = new ArrayList<Soba>();
                            sveSobe = Queries.izborSobaPoHotelu(3001);
                            for(Soba lista:sveSobe) {
                        %>
                        <tr align="center">
                            <td><%= lista.getIDSobe() %></td>
                            <td><%= lista.getBrojSobe() %></td>
                            <td><%= lista.getTipSobe()  %></td>
                            <td><%= lista.getBrojSprata() %></td>
                            <td><%= lista.getIDHotela() %></td>
                            <td><%= lista.isKlima() %></td>
                            <td><%= lista.isSporet() %></td>
                            <td><%= lista.isTerasa()  %></td>
                            <td><%= lista.isSef() %></td>
                            <td style="border: none"><!--<input type="submit" value="Rezervisi" id="btnRezervisiSobu">-->
                                <a href="rezervacijaUgovor.jsp?id=<%= lista.getIDSobe() %>" id="btnRezervisiSobu">Rezervacija</a>
                            <td>

                                <% 
                                   int id = (int)sesija.getAttribute("uspesnoUlogovan");
                                   if((sesija.getAttribute("uloga").equals("Admin") || id==5)) { 
                                %>
                            <td style="border: none"><!--<input type="submit" value="Izmeni" id="btnIzmeniSobu">-->
                                <a href="updateSobe.jsp?id=<%= lista.getIDSobe() %>&proces=updateSobaTropical" id="btnIzmeniSobu">Izmeni</a>
                            <td>
                            <td style="border: none"><!--<input type="submit" value="Izbrisi" id="btnIzbrisiSobu">-->
                                <a href="DeleteSobeServlet?id=<%= lista.getIDSobe() %>&proces=deleteSobaTropical" id="btnIzbrisiSobu">Izbrisi</a>
                            <td>
                                <% } %>
                        </tr>
                        <% } %>

                    </table>
                    <% 
                           if(sesija.getAttribute("uloga").equals("Admin") || sesija.getAttribute("uloga").equals("Menadzer")) { 
                    %>
                    <br><br>
                    <p align="center" style=""><!--<input type="submit" value="Kreiraj" id="btnKreirajSobu">-->
                        <a href="insertSoba.jsp" id="btnKreirajSobu">Kreiraj</a>
                    </p>
                    <% } %>
                        <% } %>
                </form>
                <br>
                <%@include file="footer.jsp" %>

            </div>
        </div>
    </body>
</html>
