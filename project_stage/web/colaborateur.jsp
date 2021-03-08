




<%@page import="ilem.User"%>
<%@page import="ilem.testcon"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"%>
<%@page import="ilem.role"%>

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
			<input class="input_search" id="search_colaborateur" onkeyup="searchTable();" type="text" placeholder="chercher par nom  de colaborateur Colaborateur">
		</div>
               <%if (u.gettyperole().equalsIgnoreCase("admin")) {%> 
		<div class="add">
			<button class="par_add" onclick="clickAdd();">Ajouter Collaborateur</button>
                        <form class="form"   action="COLABORATEURADD"  method="POST"  style="display:none;" id="form_add_colaborateur">
				
				<div class="child_form">
					<label>*nom</label>
                                        <input type="text" name="nom">
				</div>
				<div class="child_form">
					<label>*prenom</label>
					<input type="text" name="prenom">
				</div>
				<div class="child_form">
					<label>*adresse</label>
					<input type="text" name="adresse"> 
				</div>
				<div class="child_form">
					<label>*email</label>
					<input type="email" name="email">
				</div>
				<div class="child_form">
					<label>*management</label>
                                        <input type="text" name="management">
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
<!--                           <th>id</th>-->
                            <th>nom</th>
                            <th>prenom</th>
                            <th>adresse</th>
                            <th>email</th>
                            <th>management</th>
                           <%if (u.gettyperole().equalsIgnoreCase("admin")) {%> 
                            <th>Action</th>
                            <th>Action</th>
                            <%}%>
                          
                        </tr>
                    </thead>
                    
                        <%
                            con = testcon.getmyConnection();
                            st = con.createStatement();
                            rs = st.executeQuery("select  * from colaborateur");

                            while (rs.next()) {
                                out.write("<tr>");
                                 out.print("<td style='display:none'>" + rs.getString(1) + "</td>");
                                out.print("<td>" + rs.getString(2) + "</td>");
                                out.print("<td>" + rs.getString(3) + "</td>");
                                out.print("<td>" + rs.getString(4) + "</td>");
                                out.print("<td>" + rs.getString(5) + "</td>");
                                out.print("<td>" + rs.getString(6) + "</td>");
                                   if (u.gettyperole().equalsIgnoreCase("admin")) { 
                                out.print("<td>");
                                out.print("<form action='colaborateur' method='post'>");
                                out.print("<button type='submit' value='delete'>Supprimer</button>");
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

                    
                </table>
            </div>
		   
		<div class="cont_edit">
                       <%if (u.gettyperole().equalsIgnoreCase("admin")) {%> 
			<div class="edit">
				<p class="par_add">modifier Collaborateur</p>
                                <form class="form" action="colaborateur" method="get">
                                    <div  class="child_form" style="display: none">
						<label>*id colabolateur</label>
                                                <input type="text"  name="id">
					</div>
					<div class="child_form">
						<label>*nom</label>
						<input type="text" name="nom">
					</div>
					<div class="child_form">
						<label>*prenom</label>
						<input type="text" name="prenom">
					</div>
					<div class="child_form">
						<label>*adresse</label>
						<input type="text" name="adresse">
					</div>
					<div class="child_form">
						<label>*email</label>
                                                <input type="email" name="email">
					</div>
					<div class="child_form">
						<label>*management</label>
                                                <input type="text" name="management">
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
                        <script src="scripts/ScriptColaborateur.js"></script>
                       
</body>
</html>
<%} else {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }%>
