package com.servlets;

import java.io.IOException;

/**
 * Created by Oussama on 22/09/2017.
 */
public class MyServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/pages/home.jsp").forward(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String fname = request.getParameter("fname");
        request.setAttribute("fname", fname);
        this.getServletContext().getRequestDispatcher("/pages/home.jsp").forward(request, response);
    }

}
