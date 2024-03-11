package Controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletIndexStarPlus extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String tipSobe = request.getParameter("izborTipaSobe");
        RequestDispatcher rd = request.getRequestDispatcher("starPlus.jsp");
        request.setAttribute("tipSobe", tipSobe);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
