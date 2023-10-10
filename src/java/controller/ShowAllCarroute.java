/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Carroutes;
import model.entity.Cars;
import model.entity.Users;
import model.repository.CarroutesRepository;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ShowAllCarroute", urlPatterns = {"/showcarroute"})
public class ShowAllCarroute extends HttpServlet {

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
            out.println("<title>Servlet ShowAllCarroute</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowAllCarroute at " + request.getContextPath() + "</h1>");
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

        Date datestart = Date.valueOf(request.getParameter("datastart"));
        int car_id = Integer.parseInt(request.getParameter("car_id"));
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("iduser");

        ArrayList<Carroutes> listCarroute = CarroutesRepository.getListCarroutes();

        request.setAttribute("listcar", listCarroute);
        session.setAttribute("datestart", datestart);

        request.getRequestDispatcher("welcome_member.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Date datestart = Date.valueOf(request.getParameter("datastart"));
        int car_id = Integer.parseInt(request.getParameter("car_id"));
        HttpSession session = request.getSession();
        
        Users users = (Users) session.getAttribute("iduser");
        
        if(datestart != null){
            ArrayList<Carroutes> listcar = CarroutesRepository.getListCarroutes();
            request.setAttribute("listCar", listcar);
            request.getRequestDispatcher("welcome_member.jsp").forward(request, response);
        }else{
            session.setAttribute("datestart", datestart);
            response.sendRedirect(request.getContextPath()+"/booking?car_id=?" + car_id +"&idUser="+users.getId()+"&datestart"+datestart);
        }
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
