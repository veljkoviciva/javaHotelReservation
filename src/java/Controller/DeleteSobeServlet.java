
package Controller;

import Baza.Queries;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteSobeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idSobe = Integer.parseInt(request.getParameter("id"));
        String proces = request.getParameter("proces");
        
        try {
           switch(proces) {
               case "deleteSobaStarPlus":
                   Queries.deleteSoba(idSobe);
                   response.sendRedirect("rezervacijaStarPlus.jsp");
                   break;
               case "deleteSobaTropical":
                   Queries.deleteSoba(idSobe);
                   response.sendRedirect("rezervacijaTropical.jsp");
                   break;
               case "deleteSobaSunset":
                   Queries.deleteSoba(idSobe);
                   response.sendRedirect("rezervacijaSunset.jsp");
                   break;
           }
        }
        catch(Exception e) {
            e.printStackTrace();
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
