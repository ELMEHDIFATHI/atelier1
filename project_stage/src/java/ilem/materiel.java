/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author FATHI
 */
@WebServlet(name = "materiel", urlPatterns = {"/materiel"})
public class materiel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try {

            Connection con = testcon.getmyConnection();
            String description = request.getParameter("description");

            String marque = request.getParameter("marque");

            int numserie = Integer.parseInt(request.getParameter("numserie"));
            int idmat = Integer.parseInt(request.getParameter("id"));
            System.out.println(idmat);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select idcategorie from categorie  where marque='" + marque + "' ");
            if (rs.first()) {
                rs.getInt(1);
                int code = rs.getInt(1);
                PreparedStatement ps = con.prepareStatement("UPDATE materiel SET numserie=?,description=?,idcategorie=? WHERE idmateriel=?");

                ps.setInt(1, numserie);
                ps.setString(2, description);
                ps.setInt(3, code);
                ps.setInt(4, idmat);
                ps.executeUpdate();

            }

        } catch (Exception E) {
            System.out.println("update :" + E.getMessage());

        }
        request.getRequestDispatcher("Materiel.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/Oror occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
       
        
              int input = JOptionPane.showConfirmDialog(null, 
                "voulez vous continuer?", "Selectionez un choix",JOptionPane.YES_NO_CANCEL_OPTION);
        if(input==0){
        try {
            Connection con = testcon.getmyConnection();
            Statement st = con.createStatement();
            int code = Integer.parseInt(request.getParameter("codeA"));

            st.executeUpdate("delete from materiel where idmateriel=" + code + "");
              request.getRequestDispatcher("Materiel.jsp").forward(request, response);

        } catch (Exception E) {
            System.out.println("delete :" + E.getMessage());

        }
        
        } else{
                response.sendRedirect("Materiel.jsp");
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
