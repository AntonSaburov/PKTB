package edu.javacourse.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SecondSimpleServlet", urlPatterns = {"/second"})
public class SecondServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        response.getWriter().append("Heelo from Second Servlet");

        String superString = "SUPER MEGA TEST FOR REQUEST";

        System.out.println("SECOND SERVLET IS CALLED");
        
        request.getSession().setAttribute("NAME", "First");
        
        request.setAttribute("SimpleName", superString);
        getServletContext().getRequestDispatcher("/secondPage.jsp").forward(request, response);
    }
}
