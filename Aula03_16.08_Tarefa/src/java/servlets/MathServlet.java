/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isabela
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/math-servlet.html"})
public class MathServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IsabelaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div style='text-align:center'>");
            out.println("<h2>Resultado</h2>");
            
            try {
                   float n1 = Float.parseFloat(request.getParameter("n1"));
                   out.println("<h4><b>N1</b>: " + n1 + "</h4>");
                   float n2 = Float.parseFloat(request.getParameter("n2"));
                   out.println("<h4><b>N2</b>: " + n2 + "</h4>");
                   out.println("<br/>");
                   
                   float result = 0;
                   String op = request.getParameter("op");                   
                   
                   switch (op) {

                    case "Soma":
                        result = n1 + n2; break;
                    case "Subtracao":
                        result = n1 - n2; break;
                    case "Divisao":                        
                        result = n1 / n2; break;
                    case "Multiplicacao":
                        result = n1 * n2; break;
                    default: System.out.println("Operação inválida.");
                }                   
                   out.println("<h4><b>" + op + "</b>: " + result + "</h4>");                               
                    }            
                catch (Exception ex) { 
                      out.println("<p style = 'color:red'>"+ex.getMessage()+"</p>");
                }
            
            
            out.println("</br>");
            out.println("</br>");
            out.println("<h3><a href ='index.html'>Voltar</a></h3>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
