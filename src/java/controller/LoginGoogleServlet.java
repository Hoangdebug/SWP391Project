package controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.config.GooglePojo;
import org.json.JSONObject;
import utils.GoogleUtils;

@WebServlet(name = "LoginGoogleServlet", urlPatterns = {"/LoginGoogleServlet"})
public class LoginGoogleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String code = "";
    String access_token = "";

    public LoginGoogleServlet() {
        super();
    }

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
            out.println("<title>Servlet LoginGoogleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginGoogleServlet at " + request.getContextPath() + "</h1>");
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
        try {
            System.out.println("get");
            // get code
            String code = request.getParameter("code");
            // format parameters to post
            String urlParameters = "code="
                    + code
                    + "&client_id=638984395947-ot7n2roet029u797d2fnri9ifun9okot.apps.googleusercontent.com"
                    + "&client_secret=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"
                    + "&redirect_uri=http://localhost:8084/vh_express/login/LoginGoogleServlet"
                    + "&grant_type=authorization_code";

            System.out.println(urlParameters);
            //post parameters
            URL url = new URL("https://accounts.google.com/o/oauth2/token");
            URLConnection urlConn = url.openConnection();
            urlConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
            writer.write(urlParameters);
            writer.flush();
            System.out.println(url);
            //get output in outputString 
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
            System.out.println(outputString);
            //get Access Token 
            JsonObject json = (JsonObject) new JsonParser().parse(outputString);
            access_token = json.get("access_token").getAsString();
            System.out.println("123" + access_token);

            //get User Info 
            url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + access_token);
            urlConn = url.openConnection();
            outputString = "";
            reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
            System.out.println(outputString);

//
//            JSONObject gmailjson = new JSONObject(outputString);
//
//            Users user = new Users();
//            user.setUserAccount(gmailjson.getString("email"));
//            user.setUserName(gmailjson.getString("given_name"));            
//            user.setActivationFlag("A");
//            user.setVerificationToken(access_token);            
//            user.setUserGmailId(gmailjson.getString("id"));
//            user.setSignupFlag("G");
//            user.setProfilePic(gmailjson.getString("picture"));
//            
//            UserDB userloginDB = new UserDB();
//            System.out.println("check if 1");
//            if(userloginDB.existsEmail(user))
//            {
//                System.out.println("check if 2");
//                if(userloginDB.existsEmailAndFlag(user))
//                {
//                    Users user1 = (Users) userloginDB.getUser(user);
//                    setUserSession(user1,request);
//                    System.out.println("login and redirect to dashboard");
//                    response.sendRedirect("main.jsp");                    
//                }	
//                else
//                {
//                    System.out.println("check if 3");
//                    HttpSession session = request.getSession();
//                    session.setAttribute("errorMsg", "Wrong Login Type!You have been already registered with Facebook!Try with FB Login"); 
//                    response.sendRedirect("index.html");
//                    System.out.println("if-else");                    
//                }	
//            }	
//            else
//            {                
//                System.out.println("check if 4");
//                userloginDB.addNewUser(user);
//                setUserSession(user,request);                
//                response.sendRedirect("login.jsp");
//                System.out.println("registered and dispatch to dashboard");
//            }        
        writer.close();
        request.getRequestDispatcher("index.html").forward(request, response);        
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

//    public void setUserSession(Users user, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.setAttribute("User", user);
//    }
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
