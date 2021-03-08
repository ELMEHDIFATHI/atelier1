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
        
        <link rel="stylesheet" type="text/css" href="styles/StyleHeader.css">
        <style>
           *{
	padding:0;
	margin: 0;
	box-sizing: border-box;
}

#account{
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}
#account>form{
	width: 70%;
	margin-top: 5%;
	display: flex;
	flex-direction: column;
	background-color: #34647f;
	padding: 24px 20px;
	color: white;
	font-size: 24px;
	font-family: monospace;
}
#account>form>div{
	display: flex;
	flex-direction: column;
	width: 100%;
	margin-bottom: 30px;
}
#account>form>div>input{
	width: 100%;
	height: 40px;
	border-radius: 5px;
	padding: 10px;
	border:1px solid #ccc;
	font-size: 18px;
}


#account>form>div:last-child{
	display: flex;
	flex-direction: row;
}

#account>form>div:last-child>div:first-child{
	flex-grow: 1;
}
#account>form>div:last-child>div>button{
	width: 100px;
	background-color: black;
	color:white;
	padding: 14px 16px;
	border:1px solid black;
	border-radius: 5px;
}
#account>form>div:last-child{
	margin-bottom: 0px;
}


        </style>
        
    </head>
    <body>
        <div id="account">
            <form action="utilisateurajouter" method="post">
                     
			<div>
				<label>Nom :</label>
				<input type="text" name="nom" placeholder="Nom">
			</div>
			<div>
				<label>Prenom :</label>
				<input type="text" name="prenom" placeholder="Prenom">
			</div>
			<div>
				<label>Username :</label>
				<input type="text" name="username" placeholder="UserName">
			</div>
			<div>
				<label>Password :</label>
				<input type="password" name="password" placeholder="Password">
			</div>
                        <div>
                            <label>typerole :</label>
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
              
			<div>
				<div>
					<button type="submit">ajouter</button>
				</div>
				<div>
					<button type="reset">Reset</button>
				</div>
			</div>
                
		</form>
	</div>

    </body>
</html>
