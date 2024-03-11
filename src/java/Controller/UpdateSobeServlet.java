
package Controller;

import Baza.Queries;
import Model.Soba;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateSobeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String poruka = "";
        int brojPoena = 0;
        

        try {
            int idHotela = Integer.parseInt(request.getParameter("updateIDHotela"));
            int idSobe = Integer.parseInt(request.getParameter("updateIDSobe"));
            String tipSobe = request.getParameter("updateTipSobe");
            int brojSobe = Integer.parseInt(request.getParameter("updateBrojSobe"));
            int brojSprata = Integer.parseInt(request.getParameter("updateBrojSprata"));
            boolean dostupnostKlime = Boolean.parseBoolean(request.getParameter("updateDostpunostKlime"));
                String upisKlime = request.getParameter("updateDostpunostKlime");
                String upisSporeta = request.getParameter("updateDostpunostSporeta");
                String upisTerase = request.getParameter("updateDostpunostTerase");
                String upisSefa = request.getParameter("updateDostpunostSefa");
            boolean dostupnostSporeta = Boolean.parseBoolean(request.getParameter("updateDostpunostSporeta"));
            boolean dostupnostTerase = Boolean.parseBoolean(request.getParameter("updateDostpunostTerase"));
            boolean dostupnostSefa = Boolean.parseBoolean(request.getParameter("updateDostpunostSefa"));
           
            
            switch(idHotela) {
                case 3001: {
//                    System.out.println(proces);
//            response.sendRedirect("index.jsp");
            if(tipSobe.equals("Jednokrevetna") || tipSobe.equals("Dvokrevetna") || 
                    tipSobe.equals("Trokrevetna") || tipSobe.equals("Cetvorokrevetna") ||
                    tipSobe.equals("Petokrevetna")) {
                if(brojSobe>30 && idHotela==3001){
                    if((brojSprata <= 3 && brojSprata > 0) && idHotela==3001){
                        if((upisKlime.equals("false") || upisKlime.equals("true")) && (upisTerase.equals("false") || upisTerase.equals("true"))
                                    && (upisSporeta.equals("false") || upisSporeta.equals("true")) && 
                                (upisSefa.equals("false") || upisKlime.equals("true"))) {
                            
                            Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, dostupnostKlime, dostupnostSporeta, dostupnostTerase, dostupnostSefa);
                            Queries.updateSobe(s);
                            
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                            
                        }
                        else
                            poruka = "Vrednosti za dostupnost klime, šporeta, terase i sefa mora biti true ili false";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                    }
                    else
                        poruka = "Broj sprata mora biti između 1 i 3";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                }
                else 
                    poruka = "Broj sobe mora biti veći od 30";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
            }
            else 
                poruka = "Moguce vrednosti za sobu: Jednokrevetna, Dvokrevetna, Trokrevetna, Cetvorokrevetna, Petokrevetna";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                break;
                }
                
                case 3002: {
//                    System.out.println(proces);
//            response.sendRedirect("index.jsp");
            if(tipSobe.equals("Jednokrevetna") || tipSobe.equals("Dvokrevetna") || 
                    tipSobe.equals("Trokrevetna") || tipSobe.equals("Cetvorokrevetna") ||
                    tipSobe.equals("Petokrevetna")) {
                if(brojSobe>130 && idHotela==3002){
                    if((brojSprata <= 3 && brojSprata > 0) && idHotela==3002){
                        if((upisKlime.equals("false") || upisKlime.equals("true")) && (upisTerase.equals("false") || upisTerase.equals("true"))
                                    && (upisSporeta.equals("false") || upisSporeta.equals("true")) && 
                                (upisSefa.equals("false") || upisKlime.equals("true"))) {
                            
                            Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, dostupnostKlime, dostupnostSporeta, dostupnostTerase, dostupnostSefa);
                            Queries.updateSobe(s);
                            
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                            
                        }
                        else
                            poruka = "Vrednosti za dostupnost klime, šporeta, terase i sefa mora biti true ili false";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                    }
                    else
                        poruka = "Broj sprata mora biti između 1 i 3";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                }
                else 
                    poruka = "Broj sobe mora biti veći od 130";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
            }
            else 
                poruka = "Moguce vrednosti za sobu: Jednokrevetna, Dvokrevetna, Trokrevetna, Cetvorokrevetna, Petokrevetna";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                break;
                }
                
            case 3003: {
//                    System.out.println(proces);
//            response.sendRedirect("index.jsp");
            if(tipSobe.equals("Jednokrevetna") || tipSobe.equals("Dvokrevetna") || 
                    tipSobe.equals("Trokrevetna") || tipSobe.equals("Cetvorokrevetna") ||
                    tipSobe.equals("Petokrevetna")) {
                if(brojSobe>120 && idHotela==3003){
                    if((brojSprata <= 4 && brojSprata > 0) && idHotela==3003){
                        if((upisKlime.equals("false") || upisKlime.equals("true")) && (upisTerase.equals("false") || upisTerase.equals("true"))
                                    && (upisSporeta.equals("false") || upisSporeta.equals("true")) && 
                                (upisSefa.equals("false") || upisKlime.equals("true"))) {
                            
                            Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, dostupnostKlime, dostupnostSporeta, dostupnostTerase, dostupnostSefa);
                            Queries.updateSobe(s);
                            
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                            
                        }
                        else
                            poruka = "Vrednosti za dostupnost klime, šporeta, terase i sefa mora biti true ili false";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                    }
                    else
                        poruka = "Broj sprata mora biti između 1 i 4";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                }
                else 
                    poruka = "Broj sobe mora biti veći od 120";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
            }
            else 
                poruka = "Moguce vrednosti za sobu: Jednokrevetna, Dvokrevetna, Trokrevetna, Cetvorokrevetna, Petokrevetna";
                            request.setAttribute("poruka", poruka);
                            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
                            rd.forward(request, response);
                break;
                }
                
            default:
               response.sendRedirect("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
            }}
            catch (NumberFormatException e) {
            e.printStackTrace();
            poruka = "Greska prilikom unosa";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("updateSobe.jsp?id=" + request.getParameter("updateIDSobe"));
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
