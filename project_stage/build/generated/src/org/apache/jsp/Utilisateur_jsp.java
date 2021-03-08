package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ilem.testcon;
import java.sql.*;
import ilem.User;

public final class Utilisateur_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    Connection con;
    Statement st;
    ResultSet rs;


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");


    User u = ((User) request.getSession().getAttribute("user"));

      out.write('\n');
if ( request.getSession().getAttribute("user") != null) {
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/StyleHeader.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div id=\"other\">\n");
      out.write("                <a href=\"Acceuil.jsp\">Acceuil</a>\n");
      out.write("                <a href=\"detailcolaborateur.jsp\">Detail Colaborateur</a>\n");
      out.write("                <a href=\"colaborateur.jsp\">Colaborateur</a>\n");
      out.write("                <a href=\"Materiel.jsp\">Materiel</a>\n");
      out.write("                <a href=\"Categorie.jsp\">Categorie Materiel</a>\n");
      out.write("                 ");
if(u.gettyperole().equalsIgnoreCase("admin")){
      out.write(" \n");
      out.write("                <a href=\"Utilisateur.jsp\"> Utilisateur</a>\n");
      out.write("                <a href=\"role.jsp\"> role</a>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"account\">\n");
      out.write("                 ");
if(u.gettyperole().equalsIgnoreCase("admin")){
      out.write(" \n");
      out.write("                <a href=\"moncompte.jsp\">moncompte</a>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                <a href=\"login.jsp\">logout</a>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("                            ");
} 
    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("\n");
      out.write("            var verifAdd = false;\n");
      out.write("            function testhover() {\n");
      out.write("                verifAdd = !verifAdd;\n");
      out.write("                if (verifAdd) {\n");
      out.write("                    document.getElementById(\"imge\").style.display = \"flex\";\n");
      out.write("                    document.getElementById(\"account\").style.display = \"flex\";\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"imge\").style.display = \"flex\";\n");
      out.write("                    document.getElementById(\"account\").style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');
if (u != null && u.gettyperole().equalsIgnoreCase("admin")) {
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/StyleHeader.css\">\n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("\tpadding: 0;\n");
      out.write("\tmargin: 0;\n");
      out.write("\tbox-sizing: border-box;\n");
      out.write("}\n");
      out.write(".container{\n");
      out.write("\twidth: 100%;\n");
      out.write("\tdisplay: flex;\n");
      out.write("\tflex-direction: column;\n");
      out.write("\tjustify-content: center;\n");
      out.write("\talign-items: center;\n");
      out.write("\tpadding-top:5%;\n");
      out.write("\tfont-family: monospace;\n");
      out.write("}\n");
      out.write(".container>div{\n");
      out.write("\tmargin-bottom: 30px;\n");
      out.write("}\n");
      out.write(".container>.search{\n");
      out.write("\twidth: 80%;\n");
      out.write("\tdisplay: flex;\n");
      out.write("\tjustify-content: center;\n");
      out.write("\talign-items: center;\n");
      out.write("}\n");
      out.write(".container>.search>input{\n");
      out.write("\twidth: 100%;\n");
      out.write("\theight: 40px;\n");
      out.write("\tpadding: 10px;\n");
      out.write("\tborder:1px solid #ccc;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("\tfont-size: 24px;\n");
      out.write("}\n");
      out.write(".container .add button\n");
      out.write("{\n");
      out.write("\tdisplay: flex;\n");
      out.write("\tjustify-content: center;\n");
      out.write("\talign-items: center;\n");
      out.write("\tcolor:white;\n");
      out.write("\tbackground-color:#34647f;\n");
      out.write("\twidth: 200%;\n");
      out.write("\tpadding: 10px;\n");
      out.write("\tfont-size: 32px;\n");
      out.write("        cursor:pointer;\n");
      out.write("}\n");
      out.write(".container>.data{\n");
      out.write("\twidth: 80%;\n");
      out.write("}\n");
      out.write(".container>.data>table{\n");
      out.write("\tborder-collapse: collapse;\n");
      out.write("\twidth: 100%;\n");
      out.write("}\n");
      out.write(".container>.data>table tr td,\n");
      out.write(".container>.data>table tr th{\n");
      out.write("\tpadding: 10px 0px;\n");
      out.write("\ttext-align: center;\n");
      out.write("\tfont-size: 18px;\n");
      out.write("\tcolor: white;\n");
      out.write("}\n");
      out.write(".container>.data>table tr:nth-child(odd){\n");
      out.write("\tbackground-color:#3464ff;\n");
      out.write("}\n");
      out.write(".container>.data>table tr:nth-child(even){\n");
      out.write("\tbackground-color:#34647f;\n");
      out.write("\n");
      out.write("}\n");
      out.write(".container>.data>table tr:hover{\n");
      out.write("\tbackground-color: #aaa;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container>.data>table tr td button{\n");
      out.write("\tcolor: white;\n");
      out.write("\tbackground-color: black;\n");
      out.write("\tborder:1px solid black;\n");
      out.write("\tborder-radius: 2px;\n");
      out.write("\tpadding: 5px;\n");
      out.write("}\n");
      out.write(".container>.data>table tr td button:hover{\n");
      out.write("\tbackground-color: #eee;\n");
      out.write("\tcolor: black;\n");
      out.write("}\n");
      out.write(".container>.data>table tr td a{\n");
      out.write("\tcolor: black;\n");
      out.write("\tbackground-color: tomato;\n");
      out.write("\tborder:1px solid black;\n");
      out.write("\tborder-radius: 2px;\n");
      out.write("\tpadding: 5px 10px;\n");
      out.write("\ttext-decoration: none;\n");
      out.write("}\n");
      out.write(".container>.data>table tr td a:hover{\n");
      out.write("\tbackground-color: red;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<div id=\"utilisateur\" class=\"container\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"search\">\n");
      out.write("\t\t\t<input class=\"input_search\" id=\"search_utilisateur\" onkeyup=\"searchTable();\" type=\"text\" placeholder=\"Search By nom utilisateur\">\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("            <div class=\"add\">   \n");
      out.write("                <button type=\"submit\" onclick=\"window.location.href = 'ajouterutilisateur.jsp';\">ajouter</button>\n");
      out.write("            </div>     \n");
      out.write("\t\t    <div class=\"data\" id=\"dateclose\">\n");
      out.write("                <table id=\"table_utilisateur\" >\n");
      out.write("                    <thead>\n");
      out.write("                        <tr style=\"background-color: black\">\n");
      out.write("<!--                     <th>iduser</th>-->\n");
      out.write("                            <th>nom</th>\n");
      out.write("                            <th>prenom</th>\n");
      out.write("                            <th>username</th>\n");
      out.write("<!--                            <th>password</th>-->\n");
      out.write("                            <th>typerole</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            
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
                        
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\t\n");
      out.write("        </div>\n");
      out.write("                        <script>\n");
      out.write("                              function searchTable() {\n");
      out.write("\n");
      out.write("                    var input, filter, table, tr, td, i, txtValue;\n");
      out.write("                    input = document.getElementById(\"search_utilisateur\");\n");
      out.write("                    filter = input.value.toUpperCase();\n");
      out.write("                    table = document.getElementById(\"table_utilisateur\");\n");
      out.write("                    tr = table.getElementsByTagName(\"tr\");\n");
      out.write("                    for (i = 0; i < tr.length; i++) {\n");
      out.write("                        td = tr[i].getElementsByTagName(\"td\")[1];\n");
      out.write("                        if (td) {\n");
      out.write("                            txtValue = td.textContent;\n");
      out.write("                            if (txtValue.toUpperCase().indexOf(filter) > -1) {\n");
      out.write("                                tr[i].style.display = \"\";\n");
      out.write("                            } else {\n");
      out.write("                                tr[i].style.display = \"none\";\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("               \n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                        </script>\n");
      out.write("</body>>\n");
      out.write("</html>\n");
} else {

        response.sendRedirect("login.jsp");
    }
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
