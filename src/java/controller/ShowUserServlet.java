//package controller;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.entity.Users;
//import model.repository.UserRepository;
//
//@WebServlet("/showAllUser")
//
//public class ShowUserServlet extends HttpServlet {
//
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        UserRepository ac = new UserRepository();
//        String keySearch = request.getParameter("keySearch");
//        ArrayList<Users> list = new ArrayList<>();
//        if (keySearch != null) {
////            list = ac.searchUser(keySearch);
//        } else {
//            list = ac.getListUser();
//        }
//
//        request.setAttribute("user", list);
//
//        request.getRequestDispatcher("list_staff_driver.jsp").forward(request, response);
//    }
//
//}
