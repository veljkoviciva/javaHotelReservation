<%-- 
    Document   : index
    Created on : May 27, 2023, 9:26:39 PM
    Author     : Milija
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ITravel</title>

        <%--<%@include  file="bootstrap.min.css" %>--%>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stil.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="navbar.jsp" %>
                <form>
                    <h1>Ponuda:</h1>
                    <%@include file="jumbotronIndex.jsp" %>
                    <%@include file="footer.jsp" %>
                    
                </form>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
