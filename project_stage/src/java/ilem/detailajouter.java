
package ilem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "detailajouter", urlPatterns = {"/detailajouter"})
public class detailajouter extends HttpServlet {

 
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
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
         try {
            Connection con = testcon.getmyConnection();

            String nomprenom = request.getParameter("nom-prenom");
            String[] parts=nomprenom.split("-");
            String part1=parts[0];
              String part2=parts[1];
            
            // recuperer collobateur 
            PreparedStatement ps = con.prepareStatement("select idcol from colaborateur where nom=? and prenom=?");
            ps.setString(1, part1);
            ps.setString(2, part2);
            

            ResultSet rs = ps.executeQuery();
            int idCol = 0, idMat = 0;
            if (rs.first()) {

                idCol = rs.getInt(1);

            }

            // recupere materiel
            String marque = (request.getParameter("marque"));
            int numserie = Integer.parseInt(request.getParameter("numserie"));
              System.out.println(numserie);
            PreparedStatement pr = con.prepareStatement("select  idmateriel from materiel  where numserie=?");
            
            pr.setInt(1, numserie);
            ResultSet rs1 = pr.executeQuery();
            if (rs1.first()) {
                idMat = rs1.getInt(1);
            }
         
        
            
            
            
         
           
                    PreparedStatement po = con.prepareStatement("insert into detailecolaborateur(idcol,idmateriel) values(?,?)");
            po.setInt(1, idCol);
            po.setInt(2, idMat);
            po.executeUpdate();

            request.getRequestDispatcher("detailcolaborateur.jsp").forward(request, response);
                
            
        

        } catch (Exception E) {
            System.out.println("ajouter impossible :" + E.getMessage());
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
