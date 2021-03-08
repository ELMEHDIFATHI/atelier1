package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ilem.testcon;
import java.sql.*;
import ilem.User;

public final class Acceuil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
if (u != null) {
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/StyleAcceuil.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/StyleHeader.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"acceuil\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t<div id=\"total_mat\">\n");
      out.write("\t\t\t\t<h1>Total Materiel</h1>\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                                    ");

                                      
                                                con=testcon.getmyConnection();
                                           st=con.createStatement();
                                           rs=st.executeQuery("select  count(idmateriel) as cc from  materiel");
                                           if(rs.first()){
                                              out.print("<p>"+rs.getInt("cc")+"</p>");

                                           }
                                            
                                           
                                    
                                    
      out.write("\n");
      out.write("                                  \n");
      out.write("                                \n");
      out.write("                               \n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"total_cat_mat\">\n");
      out.write("\t\t\t\t<h1>Total Cat Materiel</h1>\n");
      out.write("\t\t\t\t ");

                                      
                                                con=testcon.getmyConnection();
                                           st=con.createStatement();
                                           rs=st.executeQuery("select  count(idcategorie) as dd from  categorie");
                                           if(rs.first()){
                                              out.print("<p>"+rs.getInt("dd")+"</p>");

                                           }
                                            
                                           
                                    
                                    
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t<div id=\"total_col\">\n");
      out.write("\t\t\t\t<h1>Total Colaborateur</h1>\n");
      out.write("\t\t\t\t");

                                      
                                           con=testcon.getmyConnection();
                                           st=con.createStatement();
                                           rs=st.executeQuery("select  count(idcol) as col from  colaborateur");
                                           if(rs.first()){
                                              out.print("<p>"+rs.getInt("col")+"</p>");

                                           }
                                            
                                           
                                    
                                    
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
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
