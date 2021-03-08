


<%@page import="ilem.testcon"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"%>
<%!
    Connection con;
    Statement st;
    ResultSet rs;

%>
<%if (u != null && u.gettyperole().equalsIgnoreCase("admin")) {%>
<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">
        <style>
            *{
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}
.container{
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding-top:5%;
	font-family: monospace;
}
.container>div{
	margin-bottom: 30px;
}
.container>.search{
	width: 80%;
	display: flex;
	justify-content: center;
	align-items: center;
}
.container>.search>input{
	width: 100%;
	height: 40px;
	padding: 10px;
	border:1px solid #ccc;
	border-radius: 5px;
	font-size: 24px;
}
.container .add button
{
	display: flex;
	justify-content: center;
	align-items: center;
	color:white;
	background-color:#34647f;
	width: 200%;
	padding: 10px;
	font-size: 32px;
        cursor:pointer;
}
.container>.data{
	width: 80%;
}
.container>.data>table{
	border-collapse: collapse;
	width: 100%;
}
.container>.data>table tr td,
.container>.data>table tr th{
	padding: 10px 0px;
	text-align: center;
	font-size: 18px;
	color: white;
}
.container>.data>table tr:nth-child(odd){
	background-color:#3464ff;
}
.container>.data>table tr:nth-child(even){
	background-color:#34647f;

}
.container>.data>table tr:hover{
	background-color: #aaa;
}

.container>.data>table tr td button{
	color: white;
	background-color: black;
	border:1px solid black;
	border-radius: 2px;
	padding: 5px;
}
.container>.data>table tr td button:hover{
	background-color: #eee;
	color: black;
}
.container>.data>table tr td a{
	color: black;
	background-color: tomato;
	border:1px solid black;
	border-radius: 2px;
	padding: 5px 10px;
	text-decoration: none;
}
.container>.data>table tr td a:hover{
	background-color: red;
}


        </style>
</head>
<body>


	<div id="utilisateur" class="container">

		<div class="search">
			<input class="input_search" id="search_utilisateur" onkeyup="searchTable();" type="text" placeholder="Search By nom utilisateur">
		</div>

            <div class="add">   
                <button type="submit" onclick="window.location.href = 'ajouterutilisateur.jsp';">ajouter</button>
            </div>     
		    <div class="data" id="dateclose">
                <table id="table_utilisateur" >
                    <thead>
                        <tr style="background-color: black">
<!--                     <th>iduser</th>-->
                            <th>nom</th>
                            <th>prenom</th>
                            <th>username</th>
<!--                            <th>password</th>-->
                            <th>typerole</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            
//                             style='display:none'
                            con = testcon.getmyConnection();
                            st = con.createStatement();
                            rs = st.executeQuery("    select u.iduser,u.nom,u.prenom,u.username,u.password,R.typerole from utilisateur u join role r on(u.idrole=r.idrole)");

                            while (rs.next()) {
                                out.write("<tr>");
                                 out.print("<td style='display:none'>" + rs.getString(1) + "</td>");
                                out.print("<td>" + rs.getString(2) + "</td>");
                                out.print("<td>" + rs.getString(3) + "</td>");
                                out.print("<td >" + rs.getString(4) + "</td>");
                              out.print("<td style='display:none'>" + rs.getString(5) + "</td>");
                                 out.print("<td>" + rs.getString(6) + "</td>");

                                out.print("<td>");
                                out.print("<form action='deleteutilisateur' method='post'>");
                                out.print("<button type='submit' value='delete'>Supprimer</button>");
                                out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
                                out.print("<input name='action' type='hidden' value='delete'>");
                                out.print("</form>");
                                out.print("</td>");

                               out.print("<td>");
                                out.print("<form action='Account.jsp'>");
                                out.print("<button type='submit' value='update'>Edit</button>");
                                out.print("<input name='codeA' type='hidden' value='" + rs.getString(1) + "' >");
                                out.print("<input name='action' type='hidden' value='update'>");
                                out.print("</form>");
                                out.print("</td>");

                                out.print("</tr>");

                            }
                        %>

                    </tbody>
                </table>
            </div>
	
        </div>
                        <script>
                              function searchTable() {

                    var input, filter, table, tr, td, i, txtValue;
                    input = document.getElementById("search_utilisateur");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("table_utilisateur");
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
</body>>
</html>
<%} else {

        response.sendRedirect("login.jsp");
    }%>