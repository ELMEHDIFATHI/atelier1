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
@WebServlet(name = "role", urlPatterns = {"/role"})
public class role extends HttpServlet {

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
            String typerole = (String) request.getParameter("typerole");
           
           
          
            PreparedStatement ps = con.prepareStatement("insert into role(typerole) values(?)");
              ps.setString(1, typerole);
            ps.executeUpdate();
           
                request.getRequestDispatcher("role.jsp").forward(request, response);
            
        } catch (Exception E) {
            System.out.println("ajouter :" + E.getMessage());
        }

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
        //processRequest(request, response);
         
         
              int input = JOptionPane.showConfirmDialog(null, 
                "voulez vous continuer?", "Selectionez un choix",JOptionPane.YES_NO_CANCEL_OPTION);
        if(input==0){
         try {
            Connection con = testcon.getmyConnection();
            Statement st = con.createStatement();
                int code = Integer.parseInt(request.getParameter("codeA"));
               
                ResultSet rs= st.executeQuery("select nom,prenom,r.typerole from utilisateur u JOIN role r ON(r.idrole=u.idrole) where u.idrole='"+code+"'");
               if(rs.first()){
                   String nom=rs.getString(1);
                   String prenom=rs.getString(2);
                   String type=rs.getString(3);
                   
                    JOptionPane.showMessageDialog(null, "il faut que vous supprimez ce utilisateur '"+nom+"','"+prenom+"','"+type+"' avant de supprimer ce role");
                   
                             request.getRequestDispatcher("Utilisateur.jsp").forward(request, response);  
                     

               }else{
                   st.executeUpdate("delete from role where idrole=" + code + "");
                        request.getRequestDispatcher("role.jsp").forward(request, response);  
               }
          
                
   
        }
            
          catch (Exception E) {
            System.out.println("delete :" + E.getMessage());
            }
        }else{
              request.getRequestDispatcher("role.jsp").forward(request, response);
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
