
package Controller;

import Baza.Queries;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*Dodat red*/String idKorisnika = request.getParameter("id"); /*Potencijalna greska u ""*/
        String korisnickoIme = request.getParameter("korisnickoIme");
        String lozinka = request.getParameter("lozinka");
        String poruka = "";
        
//        Validacija za korisnicko ime
        if (korisnickoIme == null || korisnickoIme.equals("")) {
            poruka = "Morate uneti korisnicko ime!";
        }

//        Validacija za lozinku
        if (lozinka == null || lozinka.equals("")) {
            poruka = "Morate uneti lozinku!";
        }
        
        if(!poruka.isEmpty()){
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        
//        Dodata cetri reda ispod
        HttpSession sesija = request.getSession();
        sesija.setAttribute("id", idKorisnika);
        sesija.setAttribute("korisnickoIme", korisnickoIme);
        sesija.setAttribute("lozinka", lozinka);

        
        int ulogovanID = Queries.proveraLogin(korisnickoIme, lozinka);
//        Dodat red ispod
        String ulogaKorisnika = Queries.vratiUlogu(korisnickoIme, lozinka);
//        Nova proba
//        int poeniSoba = Queries.vratiBrojPoena();         DOVRSITI NAKON INSERTA HOTELA
//        System.out.println(ulogovanID);
        if(ulogovanID>0){
//            System.out.println("Uspesno ulogovan");
//            HttpSession sesija = request.getSession(); zakomentarisano, iz prosle verzije
            sesija.setAttribute("uspesnoUlogovan", ulogovanID);
//            Dodat sledeci red
            sesija.setAttribute("uloga", ulogaKorisnika);
            
            System.out.println("Atribut iz sesije: " + sesija);
            response.sendRedirect("index.jsp");
        }
        else {
            poruka = "Neuspesno logovanje!";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
