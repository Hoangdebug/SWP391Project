/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import dao.LoginDao;
import dao.RegisterDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.config.DBContext;
//import model.config.DBConnect;
import model.entity.SendingEmail;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ADMIN
 */
public class UserRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String Register(RegisterDao rd) {
        String sql = "Insert into users(fullname, email, password, hashkey, authority) values (?, ?, ?, ?, ?)";

//        try ( Connection conn = DBConnect.getConnection()) {
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            String name = rd.getFullname();
            String email = rd.getEmail();
            String pass = rd.getPassword();
            String hash = rd.getHash();
            String authority = rd.getAuthority();

//            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, hash);
            ps.setString(5, authority);

            int i = ps.executeUpdate();

            if (i != 0) {
                SendingEmail se = new SendingEmail(email, hash);
                se.sendMail();
                return "SUCCESS";
            }
            ps.close();

        } catch (Exception e) {
            System.err.println("RegisterRepository File:: " + e);
        }
        return "error";
    }

    public boolean isEmailExists(String email) {
        String sql = "SELECT email FROM users WHERE email = ?";

//        try ( Connection conn = DBConnect.getConnection()) {
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
//            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Trả về true nếu email đã tồn tại, ngược lại trả về false
        } catch (Exception e) {
            System.err.println("Error checking email existence: " + e);
        }
        return false; // Trả về false nếu có lỗi xảy ra
    }

    public String login(LoginDao ld) {

        String email = ld.getEmail();
        String pass = ld.getPassword();
        String newPass = ld.getNewPass();

        String sql = "Select * from users where email = ? and password = ? and active = '0'";
//        try ( Connection conn = DBConnect.getConnection()) {
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
//            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, newPass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("vao roi do");
//                ps.setString(1, rs.getString("email"));
//                ps.setString(2, rs.getString("password"));
//                String emaildb = rs.getString("email");
////                String emaildb = rs.getString(3);
//                String passdb = rs.getString("password");
                String auth = rs.getString("authority");
//                if (emaildb.equalsIgnoreCase(email)) {
//                if (emaildb.equalsIgnoreCase(email) && passdb.equalsIgnoreCase(newPass)) {
                if ("ROLE_MEMBER".equals(auth)) {
                    return "success_member";
                } else if ("ROLE_ADMIN".equals(auth)) {
                    return "success_admin";
                }
//                } 
            }
            rs.close();
            ps.close();
//            conn.close();

        } catch (Exception e) {
            System.out.println("khong nhan database");
        }

        return "error";
    }

    // Phương thức để lấy thông tin quyền của người dùng từ cơ sở dữ liệu
    public String getUserAuthority(String email) {
        String authority = null;
        String sql = "SELECT authority FROM users WHERE email = ?";

//        try ( Connection conn = DBConnect.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(query);
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                authority = rs.getString("authority");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc email");
        }

        return authority;
    }

    public static void main(String[] args) {
        UserRepository ur = new UserRepository();
        String fullName = new String("Nguyen Anh Tu");
        String email = new String("nnguyenttu1@gmail.com");
        String pass = new String("tu123");
        String newPass = DigestUtils.md5Hex(pass);

        String authority = new String("ROLE_MEMBER");
//        LoginDao ld = new LoginDao(email,pass);        
//        LoginDao ld = new LoginDao();
//        ld.setEmail(email);
//        ld.setNewPass(newPass);
//        System.out.println(newPass);
//        System.out.println(ur.login(ld));
        RegisterDao rd = new RegisterDao(fullName,email,pass,authority);
        System.out.println(ur.Register(rd));

    }

}
