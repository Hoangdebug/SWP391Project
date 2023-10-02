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
import model.config.DBConnect;
import model.entity.SendingEmail;

/**
 *
 * @author ADMIN
 */
public class UserRepository {

    public static String Register(RegisterDao rd) {
        try (Connection conn = DBConnect.getConnection()) {

            String name = rd.getFullname();
            String email = rd.getEmail();
            String pass = rd.getPassword();
            String hash = rd.getHash();
            String authority = rd.getAuthority();

            String query = "Insert into users(fullname, email, password, hashkey, authority) values (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

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

    public static boolean isEmailExists(String email) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT email FROM users WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Trả về true nếu email đã tồn tại, ngược lại trả về false
        } catch (Exception e) {
            System.err.println("Error checking email existence: " + e);
        }
        return false; // Trả về false nếu có lỗi xảy ra
    }
    
    public static String login(LoginDao ld){
        
        String email = ld.getEmail();
        String pass = ld.getPassword();
        String newPass = ld.getNewPass();
        
        try(Connection conn = DBConnect.getConnection()) {
            String query = "Select * from users where email = ?, password = ?, active = 1";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, newPass);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String emaildb = rs.getString("email");
                String passdb = rs.getString("password");
                if (emaildb.equalsIgnoreCase(email) && passdb.equalsIgnoreCase(newPass)) {
                    return "success";
                }
                return "error";
            }
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (Exception e) {
        }
        
        return "error"; 
    }
}
