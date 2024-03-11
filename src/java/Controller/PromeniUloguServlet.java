
package Controller;

import Baza.Queries;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PromeniUloguServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idKlijenta = Integer.parseInt(request.getParameter("idKlijenta"));
            System.out.println(idKlijenta);
        String uloga = request.getParameter("promenaUloge");
//        String promena = request.getParameter("promenaUloge");
        String poruka = "";
        
        try {
        switch (uloga) {
            case "Klijent":
                    if(uloga.equals("Klijent") || uloga.equals("Menadzer")){
                        Queries.updateUloga(uloga, idKlijenta);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
                        rd.forward(request, response);
                    }
                    else {
                        poruka = "Možete osvežiti samo klijenta i menadžera!";
                        request.setAttribute(poruka, "poruka");
                        RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
                        rd.forward(request, response);
                    }    
                        
                break;
            case "Menadzer":
                if(uloga.equals("Klijent") || uloga.equals("Menadzer")){
                        Queries.updateUloga(uloga, idKlijenta);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
                        rd.forward(request, response);
                    }
                    else {
                        poruka = "Možete osvežiti samo klijenta i menadžera!";
                        request.setAttribute(poruka, "poruka");
                        RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
                        rd.forward(request, response);
                    }    
                        
                break;
            default:
                poruka = "Moguće opcije su Klijent i Menadžer!";
                        request.setAttribute("poruka", poruka);
                        RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
                        rd.forward(request, response);
        }}
        catch(Exception e) {
            poruka = "Greska!";
                        request.setAttribute(poruka, "poruka");
                        RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
                        rd.forward(request, response);
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
