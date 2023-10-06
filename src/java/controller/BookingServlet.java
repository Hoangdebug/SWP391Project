package controller;

import java.io.IOException;
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
import model.entity.Seats;

import model.entity.Users;
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
        String date = request.getParameter("date");
        System.out.println(date + "ngay " + idcar);
//        Seat seatDao = new SeatDao();
        SeatRepository seatRepository = new SeatRepository();
        List<Seats> listSeats = new ArrayList<>();
//findSeatByDateTrip(idBus, date)
        try {
            listSeats = seatRepository.;
            System.out.println(listSeats);
            request.setAttribute("ListSeat", listSeats);
        } catch (Exception e) {
            // TODO: handle exception
        }

        Users user = (Users) session.getAttribute("userlogin");
        int idUser = user.getId();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String realdate = dtf.format(now);
        request.setAttribute("realdate", realdate);
        request.setAttribute("date", date);
        request.setAttribute("user", user);

        Bus bus = BusDAO.getIdBus(idBus);

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
        request.setAttribute("bus", bus);

        request.getRequestDispatcher("/WEB-INF/view/viewCustomer/Booking.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int idBus = Integer.parseInt(request.getParameter("idBus"));
        System.out.println(idBus);
        String departure = request.getParameter("departure");
        String destination = request.getParameter("destination");
        String time = request.getParameter("time");
        String price = request.getParameter("price");
        String date = request.getParameter("date");
        String phone = request.getParameter("phone");
        String message = "";
        String ListTicket = request.getParameter("listSeat");
        if (ListTicket.trim().equals("")) {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");
            response.getWriter().append("Served at: ").append(request.getContextPath());
            HttpSession session = request.getSession();
            String id = request.getParameter("idBus");
            int idBus1 = Integer.parseInt(id);
            String date1 = request.getParameter("date");
            System.out.println(date1 + "ngay " + idBus1);
            SeatDao seatDao = new SeatDao();

            List<Seat> listSeats = new ArrayList<Seat>();

            try {
                listSeats = seatDao.findSeatByDateTrip(idBus1, date1);
                System.out.println(listSeats);
                request.setAttribute("ListSeat", listSeats);
            } catch (Exception e) {
                // TODO: handle exception
            }

            Users user = (Users) session.getAttribute("userlogin");
            int idUser = user.getIdUser();
            request.setAttribute("date", date1);

            Bus bus = BusDAO.getIdBus(idBus1);

            request.setAttribute("bus", bus);
            message = "Vui lòng chọn số ghế";
            request.setAttribute("messageerror", message);
            request.getRequestDispatcher("/WEB-INF/view/viewCustomer/Booking.jsp").forward(request, response);

        } else {
            String idListSeatString = ListTicket.substring(1);
            String idSeat[] = idListSeatString.split(" ");

            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("userlogin");
            int idUser = user.getIdUser();

            System.out.println(idUser);
//	Users idUser = (Users) session.getAttribute("userlogin");
            session.setAttribute("date", date);
            BusDAO busModel = new BusDAO();
//       boolean result =busModel.booking(departure, destination, time, price,date, idBus,idUser.getIdUser(),phone);

            for (int i = 0; i < idSeat.length; i++) {
                System.out.println("idSEAT" + idSeat[i]);
                boolean result = busModel.booking(departure, idSeat[i], destination, time, price, date, idBus, idUser, "1", phone);

            }
            response.sendRedirect(
                    request.getContextPath() + "/CheckOutServlet?idBus=" + idBus + "&idUser=" + idUser + "&date" + date);
        }

    }
}
