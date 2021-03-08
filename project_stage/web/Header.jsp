<%-- 
    Document   : Header
    Created on : 17 févr. 2020, 08:37:32
    Author     : FATHI
--%>

<%@page import="ilem.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    User u = ((User) request.getSession().getAttribute("user"));
%>
<%if ( request.getSession().getAttribute("user") != null) {%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">
    </head>
    <body>
        <div id="header">
            <div id="other">
                <a href="Acceuil.jsp">Acceuil</a>
                <a href="detailcolaborateur.jsp">Detail Colaborateur</a>
                <a href="colaborateur.jsp">Collaborateur</a>
                <a href="Materiel.jsp">Materiel</a>
                <a href="Categorie.jsp">Categorie Materiel</a>
                 <%if(u.gettyperole().equalsIgnoreCase("admin")){%> 
                <a href="Utilisateur.jsp"> Utilisateur</a>
                <a href="role.jsp"> role</a>
                <%}%>
            </div>

    



            <div id="account">
                 <%if(u.gettyperole().equalsIgnoreCase("admin")){%> 
                <a href="moncompte.jsp">moncompte</a>
                <%}%>
                <a href="login.jsp">logout</a>
            </div>
                
                            <%} 
    %>



        </div>
        <script>


            var verifAdd = false;
            function testhover() {
                verifAdd = !verifAdd;
                if (verifAdd) {
                    document.getElementById("imge").style.display = "flex";
                    document.getElementById("account").style.display = "flex";
                } else {
                    document.getElementById("imge").style.display = "flex";
                    document.getElementById("account").style.display = "none";
                }
            }
        </script>

    </body>

</html>

