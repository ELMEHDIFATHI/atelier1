


<%@page import="ilem.utilisateur"%>
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
        
      <div id="colaborateur" class="container">

            <div class="search">
                <input class="input_search" id="search_role" onkeyup="searchTable();" type="text" placeholder="Search By role">
            </div>

            <div class="add">
                <button class="par_add" onclick="clickAdd();">ADD role</button>
                <form class="form"   action="role"  method="get"  style="display:none;" id="form_add_role">

                   
                    <div class="child_form">
                        <label>typerole</label>
                        <input type="text" name="typerole">
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

            <div class="data" id="dateclose">
                <table id="table_role" >
                    <thead>
                        <tr style="background-color: black">
<!--                            <th>idrole</th>-->
                            <th>typerole</th>

                            <th>delete</th>
<!--                            <th>update</th>-->
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            con = testcon.getmyConnection();
                            st = con.createStatement();
                            rs = st.executeQuery("select  * from role");

                            while (rs.next()) {
                                out.write("<tr>");
                                out.print("<td style='display:none'>" + rs.getString(1) + "</td>");
                                out.print("<td>" + rs.getString(2) + "</td>");
                                

                                out.print("<td>");
                                out.print("<form action='role' method='post'>");
                                out.print("<button type='submit' value='delete'>Supprimer</button>");
                                out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
                                out.print("<input name='action' type='hidden' value='delete'>");
                                out.print("</form>");
                                out.print("</td>");

                                out.print("<td>");

//                                out.print("<button type='submit'  name='codeA' value='update' onclick=' test(event)'>edit</button>");
//                                out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
//                                out.print("<input name='action' type='hidden' value='update'>");

                                out.print("</td>");

                                out.print("</tr>");

                            }
                        %>

                    </tbody>
                </table>
            </div>

            <div class="cont_edit">
                <div class="edit">
                    <p class="par_add">Edit role</p>
                    <form class="form" action="role" method="get">
                        <div  class="child_form" style="display: none">
                            <label>*id role</label>
                            <input type="text"  name="id">
                        </div>
                        <div class="child_form">
                            <label>*typerole</label>
                            <input type="text" name="nom">
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
        </div>
                        <script>
                                 function searchTable() {

                    var input, filter, table, tr, td, i, txtValue;
                    input = document.getElementById("search_role");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("table_role");
                    tr = table.getElementsByTagName("tr");
                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[0];
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
                   var  verifier=false;
              function clickAdd(){
                  verifier =! verifier;
                  if(verifier){
                      document.getElementById("form_add_role").style.display="flex";
                      document.getElementById("dateclose").style.display="none";
                          document.getElementById("search_role").style.display="none";       
                  }
                  else{
                       document.getElementById("form_add_role").style.display="none";
                      document.getElementById("dateclose").style.display="flex";
                         document.getElementById("search_role").style.display="flex";
                  }
              }
                            
                            
                            
                        </script>

    </body>
</html>
<%} else {

        response.sendRedirect("login.jsp");
    }%>