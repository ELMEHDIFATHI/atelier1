<%-- 
    Document   : Categorie
    Created on : 3 févr. 2020, 19:07:07
    Author     : FATHI
--%>



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
        <div id="categorie_detail" class="container">

            <div class="search">
                <input class="input_search" onkeyup="searchTable();" id="search_detail" type="text" placeholder="chercher par nom de colaborateur">
            </div>
                <%if (u.gettyperole().equalsIgnoreCase("admin")) {%>   
            <div class="add">
                <button class="par_add"  onclick="clickAdd();">ajouter un materiel a un colaborateur</button>
                <form class="form"  action="detailajouter" method="POST"
                      style="display:none" id="form_add_categorie_materiel">

                    <div class="child_form">
                        <label>*nom-prenom</label>
                        <select name="nom-prenom">
                            <%
                                con = testcon.getmyConnection();
                                st = con.createStatement();
                                rs = st.executeQuery("select nom as cc,prenom as LL from colaborateur group by nom,prenom");
                                while (rs.next()) {
                                    out.print("<option name='nom'>" + rs.getString("cc") + "-" + rs.getString("LL") + "</option>");
                                }
                            %>


                        </select>

                    </div>

                    <div class="child_form">
                        <label>*maque</label>
                        <select name="marque">
                            <%
                                con = testcon.getmyConnection();
                                st = con.createStatement();
                                rs = st.executeQuery("select marque as cc from categorie");
                                while (rs.next()) {
                                    out.print("<option name='marque'>" + rs.getString("cc") + "</option>");
                                }
                            %>


                        </select>

                    </div>
                    <div class="child_form">
                        <label>*numserie</label>
                        <select name="numserie">
                            <%
                                con = testcon.getmyConnection();
                                st = con.createStatement();
                                rs = st.executeQuery("select numserie as cc from materiel");
                                while (rs.next()) {
                                    out.print("<option name='numserie'>" + rs.getString("cc") + "</option>");
                                }
                            %>


                        </select>

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
                <table id="table_colaborateur" >
                    <thead>
                        <tr style="background-color: black">
                            <!--                             <th>idcol</th>
                                                        <th>idmat</th>-->
                            <th>nom</th>
                            <th>prenom</th>
                            <th>marque</th>
                            <th>numserie</th>
                            <%if (!u.gettyperole().equalsIgnoreCase("user")) {%>
                            <th>action</th>
                            <th>action</th>
                            <%}%>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            con = testcon.getmyConnection();
                            st = con.createStatement();
                            rs = st.executeQuery("select C.idcol,M.idmateriel,C.nom,C.prenom,cat.marque,M.numserie from detailecolaborateur detail join colaborateur C on(C.idcol=detail.idcol) join materiel  M on (M.idmateriel=detail.idmateriel) join categorie cat on(cat.idcategorie=M.idcategorie)");

                            while (rs.next()) {
                                out.write("<tr>");

                                out.print("<td style='display:none'>" + rs.getString(1) + "</td>");
                                out.print("<td style='display:none'>" + rs.getString(2) + "</td>");
                                out.print("<td>" + rs.getString(3) + "</td>");
                                out.print("<td name='numserie'>" + rs.getString(4) + "</td>");
                                out.print("<td>" + rs.getString(5) + "</td>");
                                out.print("<td>" + rs.getString(6) + "</td>");
                                if (!u.gettyperole().equalsIgnoreCase("user")) {
                                out.print("<td>");
                                out.print("<form action='detail' method='POST'>");
                                out.print("<button type='submit' value='delete' >Supprimer</button>");
                                out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
                                out.print("<input name='codemat' type='hidden' value='" + rs.getString(2) + "' >");
                                out.print("<input name='action' type='hidden' value='delete'>");
                                out.print("</form>");
                                out.print("</td>");

                                out.print("<td>");
                                 
                               out.print("<button type='submit' value='updateup' onclick=' test(event)'>edit</button>");
                                out.print("<input name='codeAup' type='hidden' value='" + rs.getString(1) + "' >");
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
                    <p class="par_add">Edit detail</p>
                    <form class="form" action="detailupdate" method="post">
                        <div class="child_form"  style="display: none">
                            <label>*idcol</label>
                            <input type="text" name="idcol">
                            
                        </div>
                                <div class="child_form" style="display: none">
                            <label>*idmateriel</label>
                             <input type="text" name="idmateriel">
                            

                        </div>
                        <div class="child_form" style="display: none">
                            <label>*nom</label>
                            <input type="text" name="nom">
                            
                        </div>
                        <div class="child_form" style="display: none">
                            <label>*prenom</label>
                            <input type="text" name="prenom">
                            
                        </div>
                                <div class="child_form" style="display: none">
                            <label>*marque</label>
                             <input type="text" name="marque">
                            

                        </div>
                        <div class="child_form">
                            <label>*numserie</label>
                            <select name="numserie">
                                <%
                                    con = testcon.getmyConnection();
                                    st = con.createStatement();
                                    rs = st.executeQuery("select numserie as cc from materiel");
                                    while (rs.next()) {
                                        out.print("<option name='numserie'>" + rs.getString("cc") + "</option>");
                                    }
                                %>


                            </select>

                        </div>
                        <div class="child_form">
                            <div>
                                <button type="submit">modifier</button>
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
        <script >
            function searchTable() {

                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("search_detail");
                filter = input.value.toUpperCase();
                table = document.getElementById("table_colaborateur");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[2];
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

            var verifier = false;
            function clickAdd() {
                verifier = !verifier;
                if (verifier) {
                    document.getElementById("form_add_categorie_materiel").style.display = "flex";
                    document.getElementById("dateclose").style.display = "none";
                    document.getElementById("search_detail").style.display = "none";
                }
                else {
                    document.getElementById("form_add_categorie_materiel").style.display = "none";
                    document.getElementById("dateclose").style.display = "flex";
                    document.getElementById("search_detail").style.display = "flex";
                }
            }

            function test(event) {
                var x = event.target;
                var firstChild = x.parentElement.parentElement.firstElementChild;
                document.querySelector(".cont_edit").style.display = "flex";
                var inputs = document.querySelectorAll(".cont_edit input");

                var v1 = firstChild.innerHTML;
                var v2 = firstChild.nextElementSibling.innerHTML;
                var v3 = firstChild.nextElementSibling.nextElementSibling.innerHTML;
                var v4 = firstChild.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML;
                var v5 = firstChild.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML;
                

                inputs[0].value = v1;
                inputs[1].value = v2;
                inputs[2].value = v3;
                inputs[3].value = v4;
                inputs[4].value = v5;


            }



            function cancelEdit() {
                document.querySelector(".cont_edit").style.display = 'none';
            }

         





        </script>
    </body>
</html>
<%} else {

        response.sendRedirect("login.jsp");
    }%>

