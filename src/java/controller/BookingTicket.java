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
import model.entity.Cars;
import model.entity.Seats;
import model.repository.CarRepository;
import model.repository.OrderRepository;
import model.repository.SeatRepository;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "BookingTicket", urlPatterns = {"/booking"})
public class BookingTicket extends HttpServlet {

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
            out.println("<title>Servlet BookingTicket</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingTicket at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("seat-select.jsp").forward(request, response);

        // Lấy thông tin từ request
        int idCar = Integer.parseInt(request.getParameter("idCar"));
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        Date dateStart = Date.valueOf(request.getParameter("datastart"));

        SeatRepository seatRepository = new SeatRepository();

        List<Seats> listseat = new ArrayList<>();

        try {
            listseat = seatRepository.findSeatByDateTrip(idCar, dateStart);
            System.out.println(listseat);
            request.setAttribute("ListSeat", listseat);
        } catch (Exception e) {
            // TODO: handle exception
        }

        Cars car = CarRepository.getIdCar(idCar);
        request.setAttribute("carid", car);

        request.getRequestDispatcher("booking.jsp").forward(request, response);
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
        String passenger_name = request.getParameter("passenger_name");
        String passenger_phone = request.getParameter("passenger_phone");
        String ListTicket = request.getParameter("listSeat");
        if (ListTicket.trim().equals("")) {
            // Lấy thông tin từ request
            int idCar = Integer.parseInt(request.getParameter("idCar"));
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            Date dateStart = Date.valueOf(request.getParameter("datastart"));

            SeatRepository seatRepository = new SeatRepository();

            List<Seats> listseat = new ArrayList<>();

            try {
                listseat = seatRepository.findSeatByDateTrip(idCar, dateStart);
                System.out.println(listseat);
                request.setAttribute("ListSeat", listseat);
            } catch (Exception e) {
                System.out.println(e);
            }
            Cars car = CarRepository.getIdCar(idCar);

            request.setAttribute("car", car);
            String message = "Vui lòng chọn số ghế";
            request.setAttribute("messageerror", message);
            request.getRequestDispatcher("booking.jsp").forward(request, response);
        } else {
            String idListSeatString = ListTicket.substring(1);
            String[] idSeatStrings = idListSeatString.split(" ");
            int[] idSeats = new int[idSeatStrings.length];

            for (int i = 0; i < idSeatStrings.length; i++) {
                idSeats[i] = Integer.parseInt(idSeatStrings[i]);
            }

            // Lấy thông tin từ request
            int idCar = Integer.parseInt(request.getParameter("idCar"));
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            Date dateStart = Date.valueOf(request.getParameter("datastart"));
            HttpSession session = request.getSession();
            
            request.setAttribute("datestart", dateStart);
            OrderRepository order = new OrderRepository();
            
            for (int i = 0; i < idSeats.length; i++) {
                System.out.println("idSEAT" + idSeats[i]);
//                boolean result = busModel.booking(departure, idSeat[i], destination, time, price, date, idBus, idUser, "1", phone);
                boolean result = order.booking(passenger_name, passenger_phone, idSeats[i]);

            }
            response.sendRedirect(
                    request.getContextPath() + "/CheckOutServlet?idCar=" + idCar + "&idUser=" + idUser + "&date=" + dateStart);
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
