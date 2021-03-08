


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
        <link rel="stylesheet" type="text/css" href="styles/StyleOther.css">
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">
    </head>
    <body>

        <div  id="materiel" class="container">
            <div class="search">
                <input class="input_search" id="search_materiel" onkeyup="searchTable()" type="text" placeholder="chercher par numserie">
            </div>
               <%if (u.gettyperole().equalsIgnoreCase("admin")) {%>   
            <div class="add">
                <button class="par_add" onclick="clickAdd();">ajouter materiel</button>
                <form action="AJOUTERMAT"  method="POST" class="form" style="display:none" id="add_form_materiel">
                    <div class="child_form" style="display:none">
                        <label>id</label>
                        <input type="text" name="id">
                    </div>
                    <div class="child_form" >
                        <label>numserie</label>
                        <input type="text" name="num">
                    </div>
                    <div class="child_form">
                        <label>description</label>
                        <input type="text" name="desc">
                    </div>
                    <div class="child_form">
                        <label>marque</label>
                        <select name="marque">
                            <%
                                con = testcon.getmyConnection();
                                st = con.createStatement();
                                rs = st.executeQuery("select marque as cc from categorie");
                                while (rs.next()) {
                                    out.print("<option >" + rs.getString("cc") + "</option>");
                                }
                            %>


                        </select>

                    </div>
                    <div class="child_form">
                        <div>
                            <button type="submit">ajouter</button>
                        </div>
                        <div>
                            <button type="reset" >reset</button>
                        </div>
                    </div>

                </form>
            </div>
                              <%}%>
            <div class="data" id="dateclose">
                <table id="table_materiel">
                    <thead>
                        <tr  style="background-color: black">
                            <!--                            <th>idmateriel</th>-->
                            <th>numserie</th>
                            <th>discription</th>
                            <th>marque</th>
                           <%if (u.gettyperole().equalsIgnoreCase("admin")) {%>   
                            <th>Action</th>
                            <th>Action</th>
                            <%}%>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            con = testcon.getmyConnection();
                            st = con.createStatement();
                            rs = st.executeQuery("select m.idmateriel,m.numserie,m.description,c.marque from materiel m join  categorie c on(m.idcategorie=c.idcategorie)");

                            while (rs.next()) {

                                out.write("<tr>");
                                out.print("<td style='display:none'>" + rs.getString(1) + "</td>");
                                out.print("<td>" + rs.getString(2) + "</td>");
                                out.print("<td>" + rs.getString(3) + "</td>");
                                out.print("<td>" + rs.getString(4) + "</td>");
                                     if (u.gettyperole().equalsIgnoreCase("admin")) {
                                out.print("<td>");
                                out.print("<form action='materiel' method='post'>");
                                out.print("<button type='submit' value='delete' onclick='confirmation()'>Supprimer</button>");
                                out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
                                out.print("<input name='action' type='hidden' value='delete'>");
                                out.print("</form>");
                                out.print("</td>");

                                out.print("<td>");

                                out.print("<button type='submit' value='update' name='codeup'  onclick=' test(event)'>edit</button>");

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
                    <p class="par_add">Edit Materiel</p>
                    <form class="form" action="materiel" method="get">
                        <div  class="child_form" style="display: none">
                            <label>*id MATERIEL</label>
                            <input type="text"  name="id">
                        </div>
                        <div class="child_form">
                            <label>*numserie</label>
                            <input type="text" name="numserie">
                        </div>
                        <div class="child_form">
                            <label>*description</label>
                            <input type="text" name="description">
                        </div>
                        <div class="child_form">
                            <label>marque</label>
                            <select name="marque">
                                <%                                con = testcon.getmyConnection();
                                    st = con.createStatement();
                                    rs = st.executeQuery("select marque as cc from categorie");
                                    while (rs.next()) {
                                        out.print("<option >" + rs.getString("cc") + "</option>");
                                    }
                                %>


                            </select>
                        </div>

                        <div class="child_form">
                            <div><button type="submit">Edit</button>
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
        <script type="text/javascript" >
            function searchTable() {

                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("search_materiel");
                filter = input.value.toUpperCase();
                table = document.getElementById("table_materiel");
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

            var verifier = false;
            function clickAdd() {
                verifier = !verifier;
                if (verifier) {
                    document.getElementById("add_form_materiel").style.display = "flex";
                    document.getElementById("dateclose").style.display = "none";
                    document.getElementById("search_materiel").style.display = "none";
                }
                else {
                    document.getElementById("add_form_materiel").style.display = "none";
                    document.getElementById("dateclose").style.display = "flex";
                    document.getElementById("search_materiel").style.display = "flex";
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
//                var v4=firstChild.nextElementSibling..nextElementSibling.nextElementSibling.innerHTML;
                inputs[0].value = v1
                inputs[1].value = v2;
                inputs[2].value = v3;
//                inputs[3].value = v4;

            }



            function cancelEdit() {
                document.querySelector(".cont_edit").style.display = 'none';
            }
            function confirmation() {
                var txt;
                var r = confirm("VOULEZ  SUPPRIMER!");
                if (r == true) {
                    txt = "You pressed OK!";
                } else {
                    txt = "You pressed Cancel!";
                }
            }





        </script>
    </body>
</html>
<%} else {

        response.sendRedirect("login.jsp");
    }%>