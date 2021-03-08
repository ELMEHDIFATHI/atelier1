package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ilem.User;
import ilem.testcon;
import java.sql.*;
import ilem.User;

public final class Categorie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                <a href=\"colaborateur.jsp\">Collaborateur</a>\n");
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
      out.write('\n');
if (u != null) {
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/StyleOther.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/StyleHeader.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"categorie_materiel\" class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"search\">\n");
      out.write("                <input class=\"input_search\" onkeyup=\"searchTable();\" id=\"search_detail\" type=\"text\" placeholder=\"chercher par marque\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
if (u.gettyperole().equalsIgnoreCase("admin")) {
      out.write("   \n");
      out.write("            <div class=\"add\">\n");
      out.write("                <button class=\"par_add\"  onclick=\"clickAdd();\">ajouter Cat Materiel</button>\n");
      out.write("                <form class=\"form\"  action=\"ajoutercat\" method=\"POST\"\n");
      out.write("                      style=\"display:none\" id=\"form_add_categorie_materiel\">\n");
      out.write("\n");
      out.write("                    <div class=\"child_form\">\n");
      out.write("                        <label>*marque materiel</label>\n");
      out.write("                        <input type=\"text\" name=\"marque\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"child_form\">\n");
      out.write("                        <div>\n");
      out.write("                            <button type=\"submit\">ajouter</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <button type=\"reset\">Reset</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <div class=\"data\" id=\"dateclose\">\n");
      out.write("                <table id=\"table_colaborateur-materiel\" >\n");
      out.write("                    <thead>\n");
      out.write("                        <tr style=\"background-color: black\">\n");
      out.write("                            <!--                         <th>Id Cat Materiel</th>-->\n");
      out.write("                            <th>Marque Materiel</th>\n");
      out.write("                                ");
if (!u.gettyperole().equalsIgnoreCase("user")) {
      out.write("\n");
      out.write("                            <th>Action</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

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
                        
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
if (!u.gettyperole().equalsIgnoreCase("user")) {
      out.write("   \n");
      out.write("            <div class=\"cont_edit\">\n");
      out.write("                <div class=\"edit\">\n");
      out.write("                    <p class=\"par_add\">Edit Cat Materiel</p>\n");
      out.write("                    <form class=\"form\" action=\"Categorie\" method=\"get\">\n");
      out.write("                        <div class=\"child_form\" style=\"display:none;\">\n");
      out.write("                            <label>*id cat materiel</label>\n");
      out.write("                            <input type=\"text\" name=\"idcat\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"child_form\">\n");
      out.write("                            <label>*marque materiel</label>\n");
      out.write("                            <input type=\"text\" name=\"marque\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"child_form\">\n");
      out.write("                            <div>\n");
      out.write("                                <button type=\"submit\">Edit</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <button type=\"button\" onclick=\"cancelEdit();\">Cancel</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script src=\"scripts/ScriptCatMateriel.js\"> </script>\n");
      out.write("        \n");
      out.write("        <script> \n");
      out.write("          function searchTable() {\n");
      out.write("\n");
      out.write("                var input, filter, table, tr, td, i, txtValue;\n");
      out.write("                input = document.getElementById(\"search_detail\");\n");
      out.write("                filter = input.value.toUpperCase();\n");
      out.write("                table = document.getElementById(\"table_colaborateur-materiel\");\n");
      out.write("                tr = table.getElementsByTagName(\"tr\");\n");
      out.write("                for (i = 0; i < tr.length; i++) {\n");
      out.write("                    td = tr[i].getElementsByTagName(\"td\")[1];\n");
      out.write("                    if (td) {\n");
      out.write("                        txtValue = td.textContent;\n");
      out.write("                        if (txtValue.toUpperCase().indexOf(filter) > -1) {\n");
      out.write("                            tr[i].style.display = \"\";\n");
      out.write("                        } else {\n");
      out.write("                            tr[i].style.display = \"none\";\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        \n");
      out.write("      </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
} else {

        response.sendRedirect("login.jsp");
    }
      out.write('\n');
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
