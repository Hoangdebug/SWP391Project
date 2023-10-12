package controller;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.entity.Seats;
import model.repository.SeatRepository;

@WebServlet("/ListSeatsServlet")
public class ListSeatsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String carId = request.getParameter("idCar");

        SeatRepository sr = new SeatRepository();
        ArrayList<Seats> sList = sr.getListSeats(carId);

        HttpSession session = request.getSession(true);
        session.setAttribute("sList", sList);
//        response.sendRedirect("listseat");
        request.getRequestDispatcher("seat-select.jsp").forward(request, response);
        // Set the list of available seats as an attribute in the request

    }
}
