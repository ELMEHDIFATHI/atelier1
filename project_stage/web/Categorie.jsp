
<%@page import="ilem.User"%>
<%@page import="ilem.testcon"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"%>
<%!
    Connection con;
    Statement st;
    ResultSet rs;

%>

<%if (u != null) {%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/StyleOther.css">
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">
    </head>
    <body>
        <div id="categorie_materiel" class="container">

            <div class="search">
                <input class="input_search" onkeyup="searchTable();" id="search_detail" type="text" placeholder="chercher par marque">
            </div>

            <%if (u.gettyperole().equalsIgnoreCase("admin")) {%>   
            <div class="add">
                <button class="par_add"  onclick="clickAdd();">ajouter Cat Materiel</button>
                <form class="form"  action="ajoutercat" method="POST"
                      style="display:none" id="form_add_categorie_materiel">

                    <div class="child_form">
                        <label>*marque materiel</label>
                        <input type="text" name="marque">
                    </div>
                    <div class="child_form">
                        <div>
                            <button type="submit">ajouter</button>
                        </div>
                        <div>
                            <button type="reset">Reset</button>
                        </div>
                    </div>
                </form>
            </div>
            <%}%>
            <div class="data" id="dateclose">
                <table id="table_colaborateur-materiel" >
                    <thead>
                        <tr style="background-color: black">
                            <!--                         <th>Id Cat Materiel</th>-->
                            <th>Marque Materiel</th>
                                <%if (!u.gettyperole().equalsIgnoreCase("user")) {%>
                            <th>Action</th>
                            <th>Action</th>
                                <%}%>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            con = testcon.getmyConnection();
                            st = con.createStatement();
                            rs = st.executeQuery("select  * from categorie");

                            while (rs.next()) {
                                out.write("<tr>");

                                out.print("<td style='display:none'>" + rs.getString(1) + "</td>");
                                out.print("<td>" + rs.getString(2) + "</td>");

//                               
                                if (u.gettyperole().equalsIgnoreCase("admin")) {
                                    out.print("<td>");

                                    out.print("<form onclick='sup();' action='Categorie' method='Post'>");
                                    out.print("<button type='submit' value='delete' id='sup' >Supprimer</button>");
                                    out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
                                    out.print("<input name='action' type='hidden' value='delete'>");
                                    out.print("</form>");
                                    out.print("</td>");

                                    out.print("<td>");

                                    out.print("<button type='submit'  name='codeA' value='update' onclick=' test(event)'>edit</button>");
                                    out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
                                    out.print("<input name='action' type='hidden' value='update'>");

                                    out.print("</td>");
                                }

                                out.print("</tr>");

                            }
                        %>

                    </tbody>
                </table>
            </div>

            <%if (!u.gettyperole().equalsIgnoreCase("user")) {%>   
            <div class="cont_edit">
                <div class="edit">
                    <p class="par_add">Edit Cat Materiel</p>
                    <form class="form" action="Categorie" method="get">
                        <div class="child_form" style="display:none;">
                            <label>*id cat materiel</label>
                            <input type="text" name="idcat">
                        </div>
                        <div class="child_form">
                            <label>*marque materiel</label>
                            <input type="text" name="marque">
                        </div>
                        <div class="child_form">
                            <div>
                                <button type="submit">Edit</button>
                            </div>
                            <div>
                                <button type="button" onclick="cancelEdit();">Cancel</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%}%>
        </div>
        <script src="scripts/ScriptCatMateriel.js"> </script>
        
        <script> 
          function searchTable() {

                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("search_detail");
                filter = input.value.toUpperCase();
                table = document.getElementById("table_colaborateur-materiel");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1];
                    if (td) {
                        txtValue = td.textContent;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        
      </script>
    </body>
</html>
<%} else {

        response.sendRedirect("login.jsp");
    }%>
