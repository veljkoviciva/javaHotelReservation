<%-- 
    Document   : createSoba
    Created on : Jun 22, 2023, 8:48:12 PM
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
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kreiranje sobe</title>
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
                        
                
                <form action="InsertSobeServlet" method="get" id="formInsertSoba"> <!-- potencijalna izmena u POST-->
                    <div class="row">
                        <div class="col-md-6">
                            <table border="1" align="center">
                                
                                <tr>
                                    <th width="200px" height="100px">Hotel: </th>
                                    <td>
                                        <% int id = (int)sesija.getAttribute("uspesnoUlogovan");
                                           if(id==4) { %>
                                        <select name="selectNazivHotela">
                                        <%
                                            ArrayList<Hotel> spisakHotela = new ArrayList<>();
                                            spisakHotela = Queries.naziviHotela();
                                            for(Hotel h:spisakHotela) {
                                        %>
                                        <option name="optionNazivHotela" value="<%= h.getIDHotela() %>"><%= h.getNazivHotela() %></option>
                                         <!--Ovde dolazi u obzir za value h.getIDHotela()-->   
                                        <% } %>    
                                        </select>
                                        <% } %>
                                        <% if(id==5) { %>
                                        <select name="selectNazivHotela">
                                        <%
                                            Hotel h1 = Queries.izborHotela(3001);
                                        %>
                                        <option name="optionNazivHotela" value="<%= h1.getIDHotela() %>"><%= h1.getNazivHotela() %></option>
                                         <!--Ovde dolazi u obzir za value h.getIDHotela()-->   
                                        </select>
                                        <% } %>
                                        <% if(id==6) { %>
                                        <select name="selectNazivHotela">
                                        <%
                                            Hotel h2 = Queries.izborHotela(3002);
                                        %>
                                        <option name="optionNazivHotela" value="<%= h2.getIDHotela() %>"><%= h2.getNazivHotela() %></option>
                                         <!--Ovde dolazi u obzir za value h.getIDHotela()-->   
                                        </select>
                                        <% } %>
                                        <% if(id==7) { %>
                                        <select name="selectNazivHotela">
                                        <%
                                            Hotel h3 = Queries.izborHotela(3003);
                                        %>
                                        <option name="optionNazivHotela" value="<%= h3.getIDHotela() %>"><%= h3.getNazivHotela() %></option>
                                         <!--Ovde dolazi u obzir za value h.getIDHotela()-->   
                                        </select>
                                        <% } %>
                                    </td>
                                    </tr>
                                    <tr>
                                        <th width="200px" height="100px">ID sobe:</th>
                                        <td><input type="text" name="insertIDSobe" required></td>
                                    </tr>
                                    <tr>
                                        <th width="200px" height="100px">Tip sobe:</th>
                                        <td>
                                            <select name="selectTipSobe">
                                                <option value="Jednokrevetna">Jednokrevetna</option>
                                                <option value="Dvokrevetna">Dvokrevetna</option>
                                                <option value="Trokrevetna">Trokrevetna</option>
                                                <option value="Cetvorokrevetna">Cetvorokrevetna</option>
                                                <option value="Petokrevetna">Petokrevetna</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th width="200px" height="100px">Broj sobe: </th>
                                        <td><input type="text" name="insertBrojSobe" required></td>
                                    </tr> 
                                    <tr>
                                        <th width="200px" height="100px">Broj sprata:</th>
                                        <td><input type="text" name="insertBrojSprata" required></td>
                                    </tr>  
                            </table>
                        </div>

                        <div class="col-md-6">
                            <table border="1" align="center">
                                <tr>
                                    <th width="200px" height="100px">Dostupnost klime: </th>
                                    <td>
                                        <select name="dostupnostKlime">
                                            <option name="nemaKlima" value="false">Nema</option>
                                            <option name="imaKlima" value="true">Ima</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="200px" height="100px">Dostupnost šporeta:</th>
                                    <td>
                                        <select name="dostupnostSporeta">
                                            <option name="nemaSporet" value="false">Nema</option>
                                            <option name="imaSporet" value="true">Ima</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="200px" height="100px">Dostupnost terase: </th>
                                    <td>
                                        <select name="dostupnostTerase">
                                            <option name="nemaTerasa" value="false">Nema</option>
                                            <option name="imaTerasa" value="true">Ima</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="200px" height="100px">Dostupnost sefa: </th>
                                    <td>
                                        <select name="dostupnostSefa">
                                            <option name="nemaSef" value="false">Nema</option>
                                            <option name="imaSef" value="true">Ima</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <br>
                    <p align="center"><input type="submit" value="Kreiraj sobu"></p>
                </form>
                <br>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>
</html>
