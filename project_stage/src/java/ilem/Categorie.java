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
@WebServlet(name = "Categorie", urlPatterns = {"/Categorie"})
public class Categorie extends HttpServlet {

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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try{
            
            Connection con=testcon.getmyConnection();
          String marque=request.getParameter("marque");
          int idcat=Integer.parseInt(request.getParameter("idcat"));
            PreparedStatement pr=con.prepareStatement("update categorie set marque=? where idcategorie=?");
            pr.setString(1, marque);
            pr.setInt(2, idcat);
            pr.executeUpdate();
            
        }catch(Exception E){
            System.out.println("updatee :"+E.getMessage());
        }
        request.getRequestDispatcher("Categorie.jsp").forward(request, response);
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
       

         int input = JOptionPane.showConfirmDialog(null, 
                "voulez vous continuer?", "Selectionez un choix",JOptionPane.YES_NO_CANCEL_OPTION);
        if(input==0){
        try {
            Connection con = testcon.getmyConnection();
            Statement st = con.createStatement();
            int code = Integer.parseInt(request.getParameter("codeA"));
            
               ResultSet rs= st.executeQuery("select marque from categorie where idcategorie=" + code + "");
               if(rs.first()){
                   String nom=rs.getString(1);
                    JOptionPane.showMessageDialog(null, "il faut que vous supprimez cette marque '"+nom+"' avant de supprimer ce materiel");
                   
                             request.getRequestDispatcher("Materiel.jsp").forward(request, response);  
                     

               }
               else{
                st.executeUpdate("delete from categorie where idcategorie=" + code + "");
                 request.getRequestDispatcher("Categorie.jsp").forward(request, response);
            }
               
            
        } catch (Exception E) {
            System.out.println("delete :" + E.getMessage());

        }
        }else{
            request.getRequestDispatcher("Categorie.jsp").forward(request, response);
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
