package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ilem.User;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
