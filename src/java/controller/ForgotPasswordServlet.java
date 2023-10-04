/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Users;
import model.repository.UserRepository;
import org.apache.catalina.User;

/**
 *
 * @author ptd
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/ForgotPasswordServlet"})
public class ForgotPasswordServlet extends HttpServlet {

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

        String url = "";

        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("confirmPassword");
        String oldPassword = request.getParameter("oldPassword");

        UserRepository user_repository = new UserRepository();

        HttpSession session = request.getSession();
//        Users user = (Users) session.getAttribute("USER");

        try {
            url = "fogot_pass.jsp";
            String email = request.getParameter("email");
            int result = user_repository.checkValidEmail(email);
            if (password.equals(passwordConfirm)) {
                if (result > 0) {
                    response.sendRedirect("otpConfirm.jsp");
                    String otp = generateOTP(6);
                    session.setAttribute("OTP", otp);
                    session.setAttribute("USER_ID", result);
                    session.setAttribute("PASSWORD", passwordConfirm);
                    sendOTPEmail(email, otp);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // Method to generate a random OTP
    private static String generateOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            otp.append(numbers.charAt(index));
        }

        return otp.toString();
    }

    // Method to send the OTP via email
    private void sendOTPEmail(String recipientEmail, String otp) throws MessagingException {
        // SMTP server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // SMTP server authentication credentials
        String username = "Nguyennhatanh.dev@gmail.com";
        String password = "Anhnguyenkt090";

        // Create a session with SMTP server
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Create an email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Nguyennhatanh.dev@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for password reset is: " + otp);

        // Send the email
        Transport.send(message);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
