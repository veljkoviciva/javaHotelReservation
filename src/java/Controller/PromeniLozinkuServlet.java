
package Controller;

import Baza.Queries;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PromeniLozinkuServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String korisnickoIme = request.getParameter("tbKorisnickoIme");
        String trenutnaLozinka = request.getParameter("tbTrenutnaLozinka");
        String novaLozinka = request.getParameter("tbNovaLozinka");
        String poruka = "";
        
//        Validacija za korisnicko ime
        if (korisnickoIme == null || korisnickoIme.equals("")) {
            poruka = "Morate uneti korisnicko ime!";
        }

//        Validacija za trenutnu lozinku
        if (trenutnaLozinka == null || trenutnaLozinka.equals("")) {
            poruka = "Morate uneti trenutnu lozinku!";
        }
        
//        Validacija za novu lozinku
        if (novaLozinka == null || novaLozinka.equals("")) {
            poruka = "Morate uneti novu lozinku!";
        }
        
        if(!poruka.isEmpty()){
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
        }
        
        Queries.promenaLozinke(korisnickoIme, trenutnaLozinka, novaLozinka);
        response.sendRedirect("index.jsp");
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
