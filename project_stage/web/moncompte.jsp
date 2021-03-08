
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User u1 = (User) request.getSession().getAttribute("user");
%>
<%if (u1 != null && u1.gettyperole().equalsIgnoreCase("admin")) {%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles/StyleAccount.css">
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">
    </head>
    <body>
        <%@include file="Header.jsp"%>

        <div id="account">
            <form action="userupdate" method="get">
                <div style='margin-bottom: 20px;'>
                    <label>Role :</label>
                    <input type="text" name="typerole" placeholder="Nom" value="<%=u1.gettyperole()%>" disabled>
                </div>
                <div style="display: none">
                    <label>iduser :</label>
                    <input type="text" name="iduser" placeholder="Nom" value="<%=u1.getID_USER()%>" >
                   
                </div>
                <div>
                    <label>Nom :</label>
                    <input type="text" name="nom" placeholder="Nom" value="<%=u1.getNOM()%>">
                </div>
                <div>
                    <label>Prenom :</label>
                    <input type="text" name="prenom" placeholder="Prenom" value="<%=u1.getPRENOM()%>">
                </div>
                <div>
                    <label>Username :</label>
                    <input type="text" name="username" placeholder="User Name" value="<%=u1.getUSERNAME()%>">
                </div>
                <div>
                    <label>Password :</label>
                    <input type="password" name="password" placeholder="Password" value="<%=u1.getPASSWORD()%>">
                </div>
                <input type="hidden" name="page" value="61">
                <div>
                    <div>
                        <%if(u1.gettyperole().equalsIgnoreCase("admin")){%>
                        <button type="submit">Update</button>
                        <%}%>
                    </div>
                    <div>
                        <button type="reset">Reset</button>
                    </div>
                </div>
            </form>
        </div>

        <script type="text/javascript">
            document.getElementById("link_aco").style.backgroundColor = "#eee";
            document.getElementById("link_aco").style.color = "black";
        </script>

    </body>
</html>
<%} else {
       
        response.sendRedirect("login.jsp");
    }%>