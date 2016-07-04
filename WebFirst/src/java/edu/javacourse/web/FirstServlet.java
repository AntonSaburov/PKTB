package edu.javacourse.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{

    @Override
    public void init() throws ServletException {
        System.out.println("INIT STAGE FINISHED");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //request.setCharacterEncoding("UTF-8");
        //request.getParameter("");
        //request.getHeader("1231");
        
        //response.setCharacterEncoding("");
        //response.setContentType("text/html");
        //response.getOutputStream().write(b);
        response.getWriter().append("<strong>Hello from Simple Servlet</strong>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
