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
@WebServlet(name = "utilisateur", urlPatterns = {"/utilisateur"})
public class utilisateur extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            Connection con = testcon.getmyConnection();
            Statement st = con.createStatement();
          int iduser = Integer.parseInt(request.getParameter("code"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String typerole=request.getParameter("typerole");
            ResultSet rs=st.executeQuery("select idrole from role where typerole='"+typerole+"'");
            if(rs.first()){
                rs.getInt(1);
                int role=rs.getInt(1);
                   PreparedStatement pr=con.prepareStatement("update utilisateur set nom=?,prenom=?,username=?,password=?,idrole=? where iduser=?");
                 pr.setString(1, nom);
                  pr.setString(2, prenom);
                   pr.setString(3, username);
                    pr.setString(4, password);
                    pr.setInt(5, role);
                    pr.setInt(6, iduser);
                    pr.executeUpdate();
                           
            }
            

        } catch (Exception e) {
            System.out.println("update :" + e.getMessage());
        }
        request.getRequestDispatcher("Utilisateur.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
      
            
       

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
