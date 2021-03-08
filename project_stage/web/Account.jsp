<%-- 
    Document   : Account
    Created on : 4 févr. 2020, 10:14:29
    Author     : FATHI
--%>

<%@page import="ilem.testcon"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"%>
<%!
    Connection con;
    Statement st;
    ResultSet rs;


%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/StyleAccount.css">
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">

    </head>
    <body>
        <%
            Connection con = testcon.getmyConnection();
            Statement st = con.createStatement();
           
            int id=Integer.parseInt(request.getParameter("codeA"));
            ResultSet rs = st.executeQuery("select * from utilisateur where iduser=" + id + "");
        while (rs.next()) {

    %>
        <div id="account">
            <form action="utilisateur" method="get">
                <div style="display: none">
                    <label>iduser :</label>
                    <input type="text" name="code" value='<%=rs.getString(1)%>' placeholder="iduser" >


                </div>

                <div>
                    <label>Nom :</label>
                    <input type="text" name="nom"  value='<%=rs.getString(2)%>' placeholder="Nom">
                </div>
                <div>
                    <label>Prenom :</label>
                    <input type="text" name="prenom"   value='<%=rs.getString(3)%>' placeholder="Prenom">
                </div>
                <div>
                    <label>Username :</label>
                    <input type="text" name="username"  value='<%=rs.getString(4)%>' placeholder="User Name">
                </div>
                <div>
                    <label>Password :</label>
                    <input type="password" name="password"  value='<%=rs.getString(5)%>'  placeholder="Password">
                </div>
                <div>
                    <label>Role :</label>

                    <select name="typerole">
                        <%
                            con = testcon.getmyConnection();
                            st = con.createStatement();

                            rs = st.executeQuery("select typerole as cc from role");
                            while (rs.next()) {
                                out.print("<option name='typerole'>" + rs.getString("cc") + "</option>");
                            }
                        %>


                    </select>
                </div>
                <%}%>
                <div>
                    <div>
                        <button type="submit">modifier</button>
                    </div>
                    <div>
                        <button type="reset">Reset</button>
                    </div>
                </div>
            </form>
        </div>



    </body>
</html>
