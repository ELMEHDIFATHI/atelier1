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
 * @author user
 */
@WebServlet(name = "utilisateurajouter", urlPatterns = {"/utilisateurajouter"})
public class utilisateurajouter extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet utilisateurajouter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet utilisateurajouter at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
        processRequest(request, response);
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
            String nom = request.getParameter("nom");
            System.out.println(nom);
            String prenom = request.getParameter("prenom");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Connection con = testcon.getmyConnection();
            Statement st = con.createStatement();
            String role = request.getParameter("typerole");
            ResultSet rs = st.executeQuery("select idrole from role where typerole='" + role + "'");
            if (rs.first()) {
                rs.getInt(1);
                int id = rs.getInt(1);
                PreparedStatement ps = con.prepareStatement("insert into utilisateur(nom,prenom,username,password,idrole) values(?,?,?,?,?)");
                ps.setString(1, nom);
                ps.setString(2, prenom);
                ps.setString(3, username);
                ps.setString(4, password);
                ps.setInt(5, id);
                ps.executeUpdate();
                request.getRequestDispatcher("Utilisateur.jsp").forward(request, response);
            }

        } catch (Exception E) {
            System.out.println("ajouter :" + E.getMessage());
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
