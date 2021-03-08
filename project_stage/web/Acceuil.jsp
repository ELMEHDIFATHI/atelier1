


<%@page import="ilem.testcon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@include file="Header.jsp" %>
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
        <link rel="stylesheet" type="text/css" href="styles/StyleAcceuil.css">
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">
    </head>
    <body>
        <div id="acceuil">
		<div>
			<div id="total_mat">
				<h1>Total Materiel</h1>
                                
                                
                                    <%
                                      
                                                con=testcon.getmyConnection();
                                           st=con.createStatement();
                                           rs=st.executeQuery("select  count(idmateriel) as cc from  materiel");
                                           if(rs.first()){
                                              out.print("<p>"+rs.getInt("cc")+"</p>");

                                           }
                                            
                                           
                                    
                                    %>
                                  
                                
                               
			</div>
			<div id="total_cat_mat">
				<h1>Total Cat Materiel</h1>
				 <%
                                      
                                                con=testcon.getmyConnection();
                                           st=con.createStatement();
                                           rs=st.executeQuery("select  count(idcategorie) as dd from  categorie");
                                           if(rs.first()){
                                              out.print("<p>"+rs.getInt("dd")+"</p>");

                                           }
                                            
                                           
                                    
                                    %>
			</div>
		</div>
		<div>
			<div id="total_col">
				<h1>Total Colaborateur</h1>
				<%
                                      
                                           con=testcon.getmyConnection();
                                           st=con.createStatement();
                                           rs=st.executeQuery("select  count(idcol) as col from  colaborateur");
                                           if(rs.first()){
                                              out.print("<p>"+rs.getInt("col")+"</p>");

                                           }
                                            
                                           
                                    
                                    %>
			</div>
		</div>
	</div>
    </body>
</html>
<%} else {

        response.sendRedirect("login.jsp");
    }%>
