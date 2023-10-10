package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import model.entity.Users;
import model.repository.CarRepository;
import model.repository.OrderRepository;
import model.repository.SeatRepository;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public BookingServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());

        String id = request.getParameter("car_id");
        int idcar = Integer.parseInt(id);
        Date datestart = Date.valueOf(request.getParameter("datestart"));
        System.out.println(datestart + "ngay " + idcar);
//        Seat seatDao = new SeatDao();
        SeatRepository seatRepository = new SeatRepository();
        List<Seats> listSeats = new ArrayList<>();
//findSeatByDateTrip(idBus, date)
        try {
            listSeats = seatRepository.findSeatByDateTrip(idcar, datestart);
            System.out.println(listSeats);
            request.setAttribute("ListSeat", listSeats);
        } catch (Exception e) {
            // TODO: handle exception
        }

        Users user = (Users) session.getAttribute("iduser");
        int idUser = user.getId();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        String realdate = dtf.format(now);
        request.setAttribute("realdate", realdate);
        request.setAttribute("datestart", datestart);
        request.setAttribute("user", user);

//        Bus bus = BusDAO.getIdBus(idBus);
        Cars car = CarRepository.getIdCar(idcar);

//		ArrayList<Seat> listSeat = BusModel.getListBusSeat(idBus);
//		System.out.println("1" + listSeat.size());
//		for (Seat seat : listSeat) {
//			seat.setStatus(false);
//			if (TicketModel.checkIdSeatAndDate(seat.getIdSeat(), date)) {
//				seat.setStatus(true);
//			}
//		}
//		System.out.println("2" + listSeat.size());
//		request.setAttribute("listseat", listSeat);	
        request.setAttribute("carid", car);

        request.getRequestDispatcher("booking.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int idcar = Integer.parseInt(request.getParameter("car_id"));
        System.out.println(idcar);
//        String departure = request.getParameter("departure");
//        String destination = request.getParameter("destination");
//        String time = request.getParameter("time");
//        String price = request.getParameter("price");
            String date = request.getParameter("datestart");
//        String phone = request.getParameter("phone");

        String passenger_name = request.getParameter("passenger_name");
        String passenger_phone = request.getParameter("passenger_phone");
        String message = "";
        int ListTicket = Integer.parseInt(request.getParameter("listSeat"));
        if (ListTicket.trim().equals("")) {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");
            response.getWriter().append("Served at: ").append(request.getContextPath());
            HttpSession session = request.getSession();
            String id = request.getParameter("car_id");
            int carid1 = Integer.parseInt(id);
            Date date1 = Date.valueOf(request.getParameter("datestart"));
            System.out.println(date1 + "ngay " + carid1);
            SeatRepository seat = new SeatRepository();

            List<Seats> listSeats = new ArrayList<Seats>();

            try {
                listSeats = seat.findSeatByDateTrip(carid1, date1);
                System.out.println(listSeats);
                request.setAttribute("ListSeat", listSeats);
            } catch (Exception e) {
                // TODO: handle exception
            }

            Users user = (Users) session.getAttribute("iduser");
            int idUser = user.getId();
            request.setAttribute("date", date1);

            Cars car = CarRepository.getIdCar(carid1);

            request.setAttribute("car", car);
            message = "Vui lòng chọn số ghế";
            request.setAttribute("messageerror", message);
            request.getRequestDispatcher("booking.jsp").forward(request, response);

        } else {
            String idListSeatString = ListTicket.substring(1);
            String idSeat[] = idListSeatString.split(" ");

            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("iduser");
            int idUser = user.getId();

            System.out.println(idUser);
//	Users idUser = (Users) session.getAttribute("userlogin");
            session.setAttribute("datestart", date); 
            OrderRepository order = new OrderRepository();
//       boolean result =busModel.booking(departure, destination, time, price,date, idBus,idUser.getIdUser(),phone);

            for (int i = 0; i < idSeat.length; i++) {
                System.out.println("idSEAT" + idSeat[i]);
//                boolean result = busModel.booking(departure, idSeat[i], destination, time, price, date, idBus, idUser, "1", phone);
                boolean result = order.booking(passenger_name, passenger_phone, idSeat[i]);

            }
            response.sendRedirect(
                    request.getContextPath() + "/CheckOutServlet?idCar=" + idcar + "&idUser=" + idUser + "&date=" + date);
        }

    }
}
