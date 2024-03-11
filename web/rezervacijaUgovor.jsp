<%-- 
    Document   : rezervacijaUgovor
    Created on : Jun 21, 2023, 9:58:49 PM
    Author     : Milija
--%>

<% HttpSession sesija = request.getSession();
    
    if(sesija.getAttribute("uspesnoUlogovan") == null) 
        response.sendRedirect("index.jsp");
%>
<%! LocalDate trenutnoVreme = null; %>

<%@page import="Baza.Queries"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ugovor o rezervaciji</title>
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

                <form method="post" action="RezervacijaServlet">
                    <h2 style="color: orange">Ugovor o rezervaciji:</h2>
                    <hr>
                    <% 
                        int idSobe = Integer.parseInt(request.getParameter("id"));
                        int idKlijenta = (int)sesija.getAttribute("uspesnoUlogovan");
                        Klijent k = Queries.podaciOKlijentu(idKlijenta);
                        Soba s = Queries.jednaSoba(idSobe);
                        Hotel h = Queries.podaciOHotelu();
                    %>
                    <div class="row">
                        <div class="col-md-6">
                            <h4 style="color:aquamarine">Podaci o klijentu:</h4>
                            <table border="1" style="color:white; background: gray; border: 5px solid orange">
                                <tr>
                                    <td>ID klijenta:</td>
                                    <td align="center"><%= idKlijenta %></td>
                                </tr>
                                <tr>
                                    <td>Ime:</td>
                                    <td align="center"><%= k.getImeKlijenta() %></td>
                                </tr>
                                <tr>
                                    <td>Prezime:</td>
                                    <td align="center"><%= k.getPrezimeKlijenta() %></td>
                                </tr>
                                <tr>
                                    <td>Datum rođenja:</td>
                                    <td width="100px" align="center"><%= k.getDatumRodjenja() %></td>
                                </tr>
                                <tr>
                                    <td>Trenutno ostvarenih poena:</td>
                                    <td align="center"><%= k.getBrojPoena() %></td>
                                </tr>
                            </table>
                        </div>

                        <div class="col-md-6">
                            <h4 style="color: aquamarine">Podaci o hotelu:</h4>
                            <table border="1" style="color:white; background: gray; border: 5px solid orange">
                                <tr>
                                    <td>Lokacija:</td>
                                    <td><%= h.getLokacija() %></td>
                                </tr>
                                <tr>
                                    <td>Naziv hotela:</td>
                                    <td><%= h.getNazivHotela() %></td>
                                </tr>
                                <tr>
                                    <td>ID hotela:</td>
                                    <td style="background-color: gray"><%= s.getIDHotela() %></td>
                                </tr>
                                <tr>
                                    <td>ID sobe:</td>
                                    <td><%= idSobe %></td><input type="hidden" name="sobaID" value="<%= idSobe %>">
                                </tr>
                                <tr>
                                    <td>Broj sobe:</td>
                                    <td><%= s.getBrojSobe() %></td>
                                </tr>
                                <tr>
                                    <td>Tip sobe:</td>
                                    <td><%= s.getTipSobe() %></td>
                                </tr>
                                <tr>
                                    <td>Broj sprata:</td>
                                    <td><%= s.getBrojSprata() %></td>
                                </tr>
                                <tr>
                                    <td>Dostupnost klime:</td>
                                    <td><%= s.isKlima() %></td>
                                </tr>
                                <tr>
                                    <td>Dostupnost šporeta:</td>
                                    <td><%= s.isSporet() %></td>
                                </tr>
                                <tr>
                                    <td>Dostupnost terase:</td>
                                    <td><%= s.isTerasa() %></td>
                                </tr>
                                <tr>
                                    <td>Dostupnost sefa:</td>
                                    <td><%= s.isSef() %></td>
                                </tr>
                                <tr>
                                    <td>Broj poena uz rezervaciju:</td>
                                    <td><%= s.getPoeni() %></td><input type="hidden" name="ostvareniPoeni" value="<%= s.getPoeni() %>">
                                </tr>
                            </table>       
                        </div>
                    </div>

                    <br><br>
                    <table border="1" style="background: gray; border: 5px solid orange">
                        <th>Datum početka rezervacije</th>
                        <th>Datum kraja rezervacije</th>
                        <tr>
                            <% 
                                
                                trenutnoVreme = java.time.LocalDate.now(); 

                            %>
                            <td align="center"><input type="date" id="pocetakRezervacije" name="pocetakRezervacije" min="<%= trenutnoVreme %>"></td>
                            <td align="center"><input type="date" id="krajRezervacije" name="krajRezervacije" min="<%= trenutnoVreme.plusDays(3) %>"></td>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                    </table>
                    <br>
                    <p align="center"><input type="submit" value="Potvrdi" id="btnPotvrdiRezervaciju"></p>

                </form><br>
                <p align="center" style="color: white">
                    Napomena: Vrednost false za dostupnost klime, šporeta, terase i sefa znači da navedene stavke
                    nisu u ponudi sobe. U suprotnom, ukoliko je vrednost true, jesu sastavni deo ponude.
                </p>
                <br>
                <%@include file="footer.jsp" %>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
