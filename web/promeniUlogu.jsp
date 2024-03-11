<%-- 
    Document   : promeniUlogu
    Created on : Jun 25, 2023, 5:43:36 AM
    Author     : Milija
--%>

<% 
    HttpSession sesija = request.getSession();
    
    String uloga = (String)sesija.getAttribute("uloga");
    
    if(sesija.getAttribute("uspesnoUlogovan") == null || uloga==null || !uloga.equals("Admin")) 
        response.sendRedirect("index.jsp");
 

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Baza.Queries"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promeni ulogu</title>
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
                    
                <form method="get" action="PromeniUloguServlet">
                    <table border="1" align="center" style="border-color: darkmagenta; background: gray">
                        <th height="100px">ID klijenta</th>
                        <th height="100px">Ime klijenta</th>
                        <th height="100px">Prezime klijenta</th>
                        <th height="100px">Datum rođenja</th>
                        <th height="100px">Korisničko ime</th>
                        <th height="100px">Ukupan broj poena</th>
                        <th height="100px">Uloga</th>
                            <% 
                                   int idKlijenta = Integer.parseInt(request.getParameter("id"));
                                   Klijent k = Queries.jedanKlijent(idKlijenta);     
                            %>
                        <tr height="50px">
                            <td align="center"><%= k.getIDKlijenta() %></td><input type="hidden" name="idKlijenta" value="<%= k.getIDKlijenta() %>">
                            <td align="center"><%= k.getImeKlijenta() %></td>
                            <td align="center"><%= k.getPrezimeKlijenta() %></td>
                            <td align="center"><%= k.getDatumRodjenja() %></td>
                            <td align="center"><%= k.getKorisnickoIme() %></td>
                            <td align="center"><%= k.getBrojPoena() %></td>
                            <td align="center">
                                <% 
                                    if(idKlijenta==4) {
                                %>
                                <input type="text" value="<%= k.getUloga() %>" readonly>
                                <br>
                                <p align="center" style="color: orange"><strong>
                                        Uloga admina je permanentna!
                                    </strong></p>
                                    <% } else { %>
                                    <input type="text" value="<%= k.getUloga() %>" name="promenaUloge" required>
                                <input type="submit" value="Izmeni" style="background: royalblue; color: white">
                                <% } %>
                            </td>
                        </tr>
                    </table>
                    <br>
                </form>
                <br>
                <%@include file="footer.jsp" %>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
                </body>
                </html>
