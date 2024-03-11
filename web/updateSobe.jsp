<%-- 
    Document   : updateSobe
    Created on : Jun 23, 2023, 4:20:37 PM
    Author     : Milija
--%>

<% 
    HttpSession sesija = request.getSession();
    
    String uloga = (String)sesija.getAttribute("uloga");
   
    if(sesija.getAttribute("uspesnoUlogovan") == null || uloga==null || uloga.equals("Klijent")) 
        response.sendRedirect("index.jsp");
        
 
%>
<%@page import="Baza.Queries"%>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmena sobe</title>
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
                <form method="get" action="UpdateSobeServlet">

                    <table border="1" align="center" style="border:3px solid orange; background: gray;">
                        <% 
                            int idSobe = Integer.parseInt(request.getParameter("id"));
                            Soba sobe = Queries.jednaSoba(idSobe);
                        %>
                        <tr>
                            <td>Tip sobe</td>
                            <td><input type="text" name="updateTipSobe" value="<%= sobe.getTipSobe() %>" required></td>
                        </tr>
                        <tr>
                            <td>ID Hotela</td>
                            <td><input type="text" name="updateIDHotela" value="<%= sobe.getIDHotela() %>" readonly></td>
                        </tr>
                        <tr>
                            <td>ID Sobe</td>
                            <td><input type="text" name="updateIDSobe" value="<%= sobe.getIDSobe() %>" readonly></td>
                        </tr>
                        <tr>
                            <td>Broj sobe</td>
                            <td><input type="text" name="updateBrojSobe" value="<%= sobe.getBrojSobe() %>" required></td>
                        </tr>
                        <tr>
                            <td>Broj sprata</td>
                            <td><input type="text" name="updateBrojSprata" value="<%= sobe.getBrojSprata() %>" required></td>
                        </tr>
                        <tr>
                            <td>Dostupnost klime</td>
                            <td><input type="text" name="updateDostpunostKlime" value="<%= sobe.isKlima() %>" required></td>
                        </tr>
                        <tr>
                            <td>Dostupnost sporeta</td>
                            <td><input type="text" name="updateDostpunostSporeta" value="<%= sobe.isSporet() %>" required></td>
                        </tr>
                        <tr>
                            <td>Dostupnost terase</td>
                            <td><input type="text" name="updateDostpunostTerase" value="<%= sobe.isTerasa() %>" required></td>
                        </tr>
                        <tr>
                            <td>Dostupnost sefa</td>
                            <td><input type="text" name="updateDostpunostSefa" value="<%= sobe.isSef() %>" required></td>
                        </tr>
                    </table>  
                        
                        <br>
                        
                    
                        <p align="center"><input type="submit" value="Izmeni" id="btnIzmeniSobu"></p>
                </form>
                        <br>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
