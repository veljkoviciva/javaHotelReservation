package Controller;

import Baza.Queries;
import Model.Soba;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertSobeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String poruka = "";
        int brojPoena = 0;

        try {
            int idHotela = Integer.parseInt(request.getParameter("selectNazivHotela"));
            int idSobe = Integer.parseInt(request.getParameter("insertIDSobe"));
            String tipSobe = request.getParameter("selectTipSobe");
            int brojSobe = Integer.parseInt(request.getParameter("insertBrojSobe"));
            int brojSprata = Integer.parseInt(request.getParameter("insertBrojSprata"));
            boolean dostupnostKlime = Boolean.parseBoolean(request.getParameter("dostupnostKlime"));
            boolean dostupnostSporeta = Boolean.parseBoolean(request.getParameter("dostupnostSporeta"));
            boolean dostupnostTerase = Boolean.parseBoolean(request.getParameter("dostupnostTerase"));
            boolean dostupnostSefa = Boolean.parseBoolean(request.getParameter("dostupnostSefa"));

            if (/*nazivHotela.equals("Tropical")*/idHotela==3001) {
                if (idSobe > 30010 && idSobe<30020) {
                    if (brojSobe > 30) {
                        if (brojSprata <= 3 && brojSprata > 0) {
//                            request.setAttribute("brojPoena", 5);
                            brojPoena = 5;

                            Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, 
                                    brojPoena, dostupnostKlime, dostupnostSporeta, dostupnostTerase, 
                                    dostupnostSefa, false);
                            Queries.insertSoba(s);
                            
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                        } else 
                            poruka = "Broj sprata mora biti između 1 i 3";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                            rd.forward(request, response);
                    } else 
                        poruka = "Broj sobe mora biti veći od 30";
                        request.setAttribute("poruka", poruka);
                        RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                        rd.forward(request, response);
                } else 
                    poruka = "ID sobe mora biti između od 30010 i 30020";
                    request.setAttribute("poruka", poruka);
                    RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                    rd.forward(request, response);
            } 
            
            else if (/*nazivHotela.equals("Sunset")*/idHotela==3003) {
                if (idSobe > 30030) {
                    if (brojSobe > 120) {
                        if (brojSprata <= 4 && brojSprata > 0) {
//                            request.setAttribute("brojPoena", 10);
                            brojPoena = 10;

                            Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, 
                                    brojPoena, dostupnostKlime, dostupnostSporeta, dostupnostTerase, 
                                    dostupnostSefa, false);
                            Queries.insertSoba(s);
                            
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                        } else 
                            poruka = "Broj sprata mora biti između 1 i 4";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                            rd.forward(request, response);
                    } else 
                        poruka = "Broj sobe mora biti veći od 120";
                        request.setAttribute("poruka", poruka);
                        RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                        rd.forward(request, response);
                } else 
                    poruka = "ID sobe mora početi od 30030";
                    request.setAttribute("poruka", poruka);
                    RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                    rd.forward(request, response);
            }
                
            else { //StarPlus 3002
                if (idSobe > 30020 && idSobe < 30030) {
                    if (brojSobe > 130) {
                        if (brojSprata <= 3 && brojSprata > 0) {
//                            request.setAttribute("brojPoena", 15);
                            brojPoena = 15;

                            Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, 
                                    brojPoena, dostupnostKlime, dostupnostSporeta, dostupnostTerase, 
                                    dostupnostSefa, false);
                            Queries.insertSoba(s);
                            
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                        } else 
                            poruka = "Broj sprata mora biti između 1 i 3";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                            rd.forward(request, response);
                    } else 
                        poruka = "Broj sobe mora biti veći od 130";
                        request.setAttribute("poruka", poruka);
                        RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                        rd.forward(request, response);
                } else 
                    poruka = "ID sobe mora biti između 30020 i 30030";
                    request.setAttribute("poruka", poruka);
                    RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
                    rd.forward(request, response);   
                }

         }catch (NumberFormatException e) {
            e.printStackTrace();
            poruka = "Greska prilikom unosa";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("insertSoba.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
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
