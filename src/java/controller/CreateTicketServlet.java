/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Carroutes;
import model.entity.Orders;
import model.entity.Seats;
import model.entity.Tickets;
import model.entity.Users;
import model.repository.OrderRepository;
import model.repository.SeatRepository;
import model.repository.TicketRepository;

/**
 *
 * @author tuna
 */
@WebServlet(name = "CreateTicketServlet", urlPatterns = {"/createticket"})
public class CreateTicketServlet extends HttpServlet {

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
        String seats;
        seats = request.getParameter("lseat");
//        System.out.println(seats);

        String[] listseat = seats.split(",");
        int[] seatids = new int[listseat.length];

        for (int i = 0; i < listseat.length; i++) {
            seatids[i] = Integer.parseInt(listseat[i]);
        }

        HttpSession session = request.getSession();
//        session.setAttribute("lseatS", seatids);
        Carroutes crs = (Carroutes) session.getAttribute("curCarroute");
        int idCar = crs.getCar_id();
        float price = crs.getPrice();

        float total = 0;

        ArrayList<Seats> lSeats = new ArrayList<>();
        SeatRepository sr = new SeatRepository();
        for (int seatid : seatids) {
            total += price;
            Seats s = sr.getSeat(seatid, idCar);
//            System.out.println(s);
            lSeats.add(s);
        }
        session.setAttribute("lseatS", lSeats);
        session.setAttribute("totalPrice", total);

//        for (int seatid : seatids) {
//            System.out.println(seatid);
//        }
        request.getRequestDispatcher("create_ticket.jsp").forward(request, response);
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
//        processRequest(request, response);
        HttpSession session = request.getSession();

        OrderRepository or = new OrderRepository();

        Users u = (Users) session.getAttribute("cur_user");
        int u_id = u.getId();
//        System.out.println(u_id);
        
        float total_price = (float) session.getAttribute("totalPrice");
//        System.out.println(total_price);
        Orders o = new Orders(u_id,0,total_price);
        or.InserOrder(o);
        Orders o_new = or.getNearOrder();
        session.setAttribute("cur_order", o_new);
        
        Carroutes carr = (Carroutes) session.getAttribute("curCarroute");
        System.out.println(carr.getCar_id());
        
        TicketRepository tr = new TicketRepository();
        SeatRepository sr = new SeatRepository();
        ArrayList<Tickets> ltickets = new ArrayList<>();
        ArrayList<Seats> lseats = (ArrayList<Seats>) session.getAttribute("lseatS");
        for (Seats s : lseats) {
            String passName = request.getParameter("passen_name"+s.getSeat_number());
            String passPhone = request.getParameter("passen_phone"+s.getSeat_number());
            Tickets t = new Tickets(carr.getId(),s.getSeat_number(),o_new.getId(), passName, passPhone);
            tr.InserTicket(t);
            sr.setIsBooked(carr.getCar_id(), s.getSeat_number());
            ltickets.add(t);
        }
        session.setAttribute("lticketS", ltickets);
        request.getRequestDispatcher("confirm.jsp").forward(request, response);
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
