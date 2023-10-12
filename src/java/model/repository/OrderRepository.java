/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.config.DBConnect;
import model.entity.Tickets;

/**
 *
 * @author ADMIN
 */
public class OrderRepository {

    public static boolean booking(String passenger_name, String passenger_phone, int seatid) {

        String query = "Insert into tickets(passenger_name, passenger_phone) values (? ,?)";

        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, passenger_name);
            ps.setString(2, passenger_phone);
            ps.executeUpdate();

            String query1 = "UPDATE seats SET is_booked = 1 WHERE id = ?";

            PreparedStatement ps1 = conn.prepareStatement(query1);

            ps1.setInt(1, seatid);
            ps1.executeUpdate();

            ps.close();
            ps1.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
            System.err.println("Lỗi booking");
        }
        return false;
    }

}
