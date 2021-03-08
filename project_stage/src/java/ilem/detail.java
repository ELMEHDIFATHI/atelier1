package ilem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "detail", urlPatterns = {"/detail"})
public class detail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //

        PrintWriter out = response.getWriter();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        int input = JOptionPane.showConfirmDialog(null,
                "voulez vous continuer?", "Selectionez un choix", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
            try {

                Connection con = testcon.getmyConnection();
                Statement st = con.createStatement();
                int code = Integer.parseInt(request.getParameter("codeA"));
                System.out.println(code);
                int codemat = Integer.parseInt(request.getParameter("codemat"));
                System.out.println("codemat");
        
                st.executeUpdate("delete from detailecolaborateur where idcol= '" + code + "' and idmateriel='"+codemat+"' ");
                request.getRequestDispatcher("detailcolaborateur.jsp").forward(request, response);

            } catch (Exception E) {

                System.out.println("delete imposible :" + E.getMessage());

            }
        } else {
            request.getRequestDispatcher("detailcolaborateur.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
