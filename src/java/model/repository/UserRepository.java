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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.config.DBConnect;
import model.entity.SendingEmail;
import model.entity.Users;
import org.apache.catalina.User;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ADMIN
 */
public class UserRepository {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

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

    public String getUserName(String email) {
        String fullname = null;
        String sql = "SELECT fullname FROM users WHERE email = ?";

        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return fullname = rs.getString("fullname");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc email");
        }
        return null;
    }

    public int checkValidEmail(String email) throws SQLException {
        try {
            Connection conn = DBConnect.getConnection();
            if (conn != null) {
                String sql = "select id from users where email = ?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, email);

                rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return -1;
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

    public String login(LoginDao ld) {

        String email = ld.getEmail();
        String pass = ld.getPassword();
        String newPass = ld.getNewPass();

        try (Connection conn = DBConnect.getConnection()) {
            String query = "Select * from users where email = ? and\n"
                    + " password = ? and active = '1'";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, newPass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

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
            conn.close();

        } catch (Exception e) {
            System.out.println("khong nhan database");
        }

        return "error";
    }

    // Phương thức để lấy thông tin quyền của người dùng từ cơ sở dữ liệu
    public String getUserAuthority(String email) {
        String authority = null;

        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT authority FROM users WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(query);
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

    public static List<Users> getListUser() {
        List<Users> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String authority = rs.getString("authority");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Users users = new Users(idUser, email, fullname, age, phone, authority, address, gender);
                list.add(users);
            }
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong User repo");
        }

        return list;

    }
    public static void deleteUser(int id) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "Delete from users WHERE id = ?\n";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI Delete User trong UserRepository------------");
        }
    }

    public static List<Users> getDriverById() {
        List<Users> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection()) {

            String query = "SELECT * FROM users where authority = 'ROLE_DRIVER'";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("fullname");
                String author = rs.getString("authority");
                Users user = new Users(id, name, author);
                list.add(user);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI GET ID Driver trong UsersRepository------------");
        }
        return list;
    }

    public void insertStaff(Users u) {
        try (Connection conn = DBConnect.getConnection()) {
            String sql = "INSERT INTO users (fullname, email, password, hashkey, active, age, phone, authority, address, gender) VALUES (?,?,'202cb962ac59075b964b07152d234b70','hashkey1',1,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getFullname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getAge());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getAuthority());
            ps.setString(6, u.getAddress());
            ps.setString(7, u.getGender());

            int i = ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI DANG KY user trong userRepository------------");
        }
    }

    public static void main(String[] args) {
        UserRepository ur = new UserRepository();
        String fullname = new String("Nguyen Anh Tu");
        String email = new String("anhnnde170283@fpt.edu.vn");
        String age = new String("20");
        String phone = new String("0915215288");
        String authority = new String("ROLE_ADMIN");
        String gender = new String("MEMBER");
        String address = new String("90 Nguyen Thuc Tu");
        String pass = new String("123");
        String newPass = DigestUtils.md5Hex(pass);

//        String authority = new String("ROLE_MEMBER");
//        LoginDao ld = new LoginDao(email,pass);        
//        LoginDao ld = new LoginDao();
//        ld.setEmail(email);
//        ld.setNewPass(newPass);
//        System.out.println(newPass);
//        System.out.println(ur.login(ld));
//        RegisterDao rd = new RegisterDao(fullName, email, pass, authority);
//        System.out.println("123" + ur.Register(rd));
        System.out.println(ur.getUserName(email));
//        System.out.println(ur.getListUser());
//        Users u = new Users(fullname, email, age, phone, authority, address, gender);
//        ur.insertStaff(u);
    }
}
