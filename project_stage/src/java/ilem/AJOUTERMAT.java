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

/**
 *
 * @author FATHI
 */
@WebServlet(name = "AJOUTERMAT", urlPatterns = {"/AJOUTERMAT"})
public class AJOUTERMAT extends HttpServlet {

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
                      response.setContentType("text/html;charset=UTF-8");
         try {
            Connection con = testcon.getmyConnection();

            int num = Integer.parseInt(request.getParameter("num"));
            String des = request.getParameter("desc");
            String marque = (request.getParameter("marque"));
//            int idmat = Integer.parseInt(request.getParameter("id"));
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select idcategorie from categorie  where marque='" + marque + "' ");
            if (rs.first()) {
                rs.getInt(1);
                int id = rs.getInt(1);
                PreparedStatement ps = con.prepareStatement("insert into materiel(numserie,description,idcategorie) values(?,?,?)");
                ps.setInt(1, num);
                ps.setString(2, des);
                ps.setInt(3, id);
           
                ps.executeUpdate();
                 
            }

        } catch (Exception E) {
            System.out.println("ajouter :" + E.getMessage());
        }
         request.getRequestDispatcher("Materiel.jsp").forward(request, response);
       
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
