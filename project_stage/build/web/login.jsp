<%-- 
    Document   : identification
    Created on : 27 janv. 2020, 08:47:25
    Author     : fathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/StyleLogin.css">
        
    </head>
    <body>
          
           <div id="login">
			<h1 id="title_login">IDENTIFICATION</h1>
                        <form id="form_login"  action="NewServlet" method="post">
                            <div>
					<label>*Username :</label>
					<input type="text" name="username" placeholder="User Name"  style="border: 3px solid red">
				</div>
				<div>
					<label>*Password :</label>
					<input type="password" name="password" placeholder="Password"  style="border: 3px solid red">
				</div>
				<button type="submit">CONNECTER VOUS</button>
			</form>
		
            </div> 
        
        

      
    </body>
</html>
