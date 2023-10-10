/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        try {
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String newPass = DigestUtils.md5Hex(pass);

            LoginDao ld = new LoginDao();
            ld.setEmail(email);
            ld.setPassword(pass);
            ld.setNewPass(newPass);

            UserRepository ur = new UserRepository();
            String userAuthority = ur.getUserAuthority(email); // Lấy thông tin quyền của người dùng từ cơ sở dữ liệu
            int id = ur.getIdByEmail(email);
            String cur_name = ur.getUserName(email);
            System.out.println(userAuthority);
            String getdb = ur.login(ld);
            if (getdb.contains("success")) {
                HttpSession session = request.getSession(true);
                session.setAttribute("session_user", email);
                session.setAttribute("role", userAuthority);
                session.setAttribute("cur_name", cur_name);
                session.setAttribute("iduser", id);

                // Kiểm tra quyền của người dùng và chuyển hướng tương ứng
                if ("ROLE_MEMBER".equals(userAuthority)) {
                    response.sendRedirect("welcome_member.jsp");
                } else if ("ROLE_STAFF".equals(userAuthority)) {
                    response.sendRedirect("welcome_staff.jsp");
                } else if ("ROLE_DRIVER".equals(userAuthority)) {
                    response.sendRedirect("welcome_driver.jsp");
                } else if ("ROLE_ADMIN".equals(userAuthority)) {
                    response.sendRedirect("welcome_admin.jsp");
                } else {
                    response.sendRedirect("welcome.jsp"); // Trường hợp mặc định
                }
            } else {
                response.sendRedirect("login");
            }
        } catch (Exception e) {
            System.err.println("Lỗi: " + e);
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
