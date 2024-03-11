
<%@page import="Baza.Queries"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Tropical</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">
    </head>
    <style>
        #formaTropical {
            border: 5px solid white;
        }

        #HotelTropicalImg {
            margin-left:   100px;
        }


    </style>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="navbar.jsp" %>
                <fieldset name="formaTropical" id="formaTropical">
                    <form method="POST" action="ServletIndexTropical" >


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
                                <% 
          int brojSoba1 = Queries.brojSoba(3001); 
          int brojSpratova1 = Queries.brojSpratova(3001); 
          ArrayList<Soba> tipoviSoba1 = Queries.tipSoba(3001);               
                                %>
                            </div>
                        </div>

                        <!--Ispod opsteg paragrafa-->
                        <p style="color: lightblue; font-size: 25px; font-style: italic;"> Status o hotelu: </p>
                        <table border="1" id="tabelaHotela" align="center">
                            <tr>
                                <td width="100px">Broj soba</td>
                                <td><%= brojSoba1 %></td>
                            </tr>
                            <tr>
                                <td>Broj spratova</td>
                                <td><%= brojSpratova1 %></td>
                            </tr>
                            <tr>
                                <td>Tipovi soba</td>
                                <td>
                                    <% for(Soba s:tipoviSoba1) { %>
                                    <%= s.getTipSobe() %>
                                    <% } %>
                                </td>
                            </tr>
                        </table>                      

                        <br><br>
                        <p align="center">
                            <span style="color: lightblue">Izaberite sobu:</span>
                            <select name="izborTipaSobe" style="background: lightblue;">
                                <% for(Soba s:tipoviSoba1) { %>
                                <option name="optionTipSobe" value="<%= s.getTipSobe() %>" id="optionTipSobe">
                                    <%= s.getTipSobe() %>
                                </option>
                                <% } %>
                            </select>
                            <input type="submit" value="Izaberi" id="btnIzaberiTropical">    
                        <p style="color: lightblue; font-size: 25px; font-style: italic;"> Status o sobama: </p>               
                        <table border="1" id="tabelaHotela" align="center">
                            <th width="150px">Tip sobe</th>
                            <th width="100px">ID Hotela</th>
                            <th width="100px">ID Sobe</th>
                            <th width="100px">Broj sobe</th>
                            <th width="100px">Broj sprata</th>
                            <th width="100px">Klima</th>
                            <th width="100px">Šporet</th>
                            <th width="100px">Terasa</th>
                            <th width="100px">Sef</th>
                                <% 
                                    String tipSobe = (String)request.getAttribute("tipSobe");
                                     ArrayList<Soba> sobe1 = new ArrayList<Soba>(); 
                                     if(tipSobe == null)
                                     {
                                        sobe1 = Queries.selectTipSobe("Jednokrevetna", 3001);
                                     }
                                     else
                                     {
                                        sobe1 = Queries.selectTipSobe(tipSobe, 3001);
                                     }
                                %>
                                <% for(Soba s : sobe1) { %>
                            <tr>
                                <td><%= s.getTipSobe() %></td>
                                <td><%= s.getIDHotela() %></td>
                                <td><%= s.getIDSobe()  %></td>
                                <td><%= s.getBrojSobe() %></td>
                                <td><%= s.getBrojSprata() %></td>
                                <td><%= s.isKlima() %></td>
                                <td><%= s.isSporet() %></td>
                                <td><%= s.isTerasa()  %></td>
                                <td><%= s.isSef() %></td>
                                
                                    <% } %>
                            </tr>

                        </table>
                        <br>

                    </form>
                </fieldset>
                <br>
                <form method="post" action="rezervacijaTropical.jsp">
                    <p align="center"><input type="submit" value="Napravi rezervaciju" id="btnRezervacijaTropical"></p>
                </form>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
