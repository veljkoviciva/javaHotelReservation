package Controller;

import Baza.Queries;
import Model.Klijent;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String datumRodjenja = request.getParameter("datumRodjenja");
        String korisnickoIme = request.getParameter("korisnickoIme");
        String lozinka = request.getParameter("lozinka");
        String poruka = "";

//        Validacija za ime
        if (ime == null || ime.equals("")) {
            poruka = "Morate uneti svoje ime!";
        }

//        Validacija za prezime
        if (prezime == null || prezime.equals("")) {
            poruka = "Morate uneti svoje prezime!";
        }

//        Validacija za datum rodjenja
        if (datumRodjenja == null || datumRodjenja.equals("")) {
            poruka = "Morate uneti svoj datum rodjenja!";
        }

//        Validacija za korisnicko ime
        if (korisnickoIme == null || korisnickoIme.equals("")) {
            poruka = "Morate uneti korisnicko ime!";
        }

//        Validacija za lozinku
        if (lozinka == null || lozinka.equals("")) {
            poruka = "Morate uneti lozinku!";
        }
        
//        Provera da li postoji poruka
        if(!poruka.isEmpty()){
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
        }
        
        Klijent k = new Klijent(0, ime, prezime, datumRodjenja, korisnickoIme, lozinka, 0);
        Queries.insertKlijent(k);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
