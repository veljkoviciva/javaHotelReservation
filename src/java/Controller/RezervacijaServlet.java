package Controller;

import Baza.Queries;
import Model.Rezervacija;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;


public class RezervacijaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesija = request.getSession();

        String poruka = "";
        String datumPocetkaRezervacije = request.getParameter("pocetakRezervacije");
        String datumKrajaRezervacije = request.getParameter("krajRezervacije");
        int idSobe = Integer.parseInt(request.getParameter("sobaID"));
        int poeniPoRezervaciji = Integer.parseInt(request.getParameter("ostvareniPoeni"));
        
        sesija.setAttribute("poeniPoRezervaciji", poeniPoRezervaciji);
        int idKlijenta = (int)sesija.getAttribute("uspesnoUlogovan");
        
        try {
            LocalDate p = LocalDate.parse(datumPocetkaRezervacije);
//        System.out.println(p);
            LocalDate k = LocalDate.parse(datumKrajaRezervacije);
//        System.out.println(k);

            if (p.isBefore(k.plusMonths(0)) || p.equals(k.getMonthValue())) {
//            System.out.println("tacan slucaj: " + p + " " + k);
                if (k.isBefore(p.plusDays(11))) {
                    
                    Rezervacija r = new Rezervacija(idKlijenta, idSobe, poeniPoRezervaciji,
                            datumPocetkaRezervacije, datumKrajaRezervacije, true);
                    Queries.napraviRezervaciju(r);
                    
                    sesija.setAttribute("zauzeto", r.isUgovoreno());
                    
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                    
                } else {
                    poruka = "Možete rezervisati najviše 10 dana";
                    request.setAttribute("poruka", poruka);
                    RequestDispatcher rd = request.getRequestDispatcher("rezervacijaUgovor.jsp?id=" + idSobe);
                    rd.forward(request, response);
                }
            } else {
                poruka = "Greška u popunjavanju datuma!";
                request.setAttribute("poruka", poruka);
                RequestDispatcher rd = request.getRequestDispatcher("rezervacijaUgovor.jsp?id=" + idSobe);
                rd.forward(request, response);
//                System.out.println("netacan slucaj:" + p + " " + k);
            }

        } catch (Exception e) {
            e.printStackTrace();
            poruka = "Greška u popunjavanju datuma!";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("rezervacijaUgovor.jsp?id=" + idSobe);
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
