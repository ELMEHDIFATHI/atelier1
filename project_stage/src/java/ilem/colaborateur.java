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
@WebServlet(name = "colaborateur", urlPatterns = {"/colaborateur"})
public class colaborateur extends HttpServlet {

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
            String nom = (String) request.getParameter("nom");
            String prenom = (String) request.getParameter("prenom");
            String adresse = (String) request.getParameter("adresse");
            String email = (String) request.getParameter("email");
            String management = (String) request.getParameter("management");
            int idcol = Integer.parseInt(request.getParameter("id"));
                           System.out.println(idcol);

            PreparedStatement ps = con.prepareStatement("UPDATE colaborateur SET nom=?,prenom=?,adresse=?,email=?,management=? WHERE idcol=?");
            ps.setInt(6, idcol);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, adresse);
            ps.setString(4, email);
            ps.setString(5, management);
            ps.executeUpdate();

        } catch (Exception E) {
            System.out.println("updateghghgh :" + E.getMessage());

        }
                request.getRequestDispatcher("colaborateur.jsp").forward(request, response);
    
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
        //processRequest(request, response);  
        response.setContentType("text/html;charset=UTF-8");
  


        // String req="insert into Colaborateur values("+idcol+",'"+nom+"','"+prenom+"','"+adresse+"','"+email+"','"+management+"')";
       
     int input = JOptionPane.showConfirmDialog(null, 
                "voulez vous continuer?", "Selectionez un choix",JOptionPane.YES_NO_CANCEL_OPTION);
        if(input==0){
         try {
            Connection con = testcon.getmyConnection();
            Statement st = con.createStatement();
        int code = Integer.parseInt(request.getParameter("codeA"));
            
                st.executeUpdate("delete from colaborateur where idcol=" + code + "");
                   request.getRequestDispatcher("colaborateur.jsp").forward(request, response);    
        }
            
          catch (Exception E) {
            System.out.println("delete :" + E.getMessage());

        }
       
     
    }else{
               response.sendRedirect("colaborateur.jsp");
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
