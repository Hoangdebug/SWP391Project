/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.config.DBContext;
import model.entity.Tickets;

/**
 *
 * @author tuna
 */
public class TicketRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String InserTicket(Tickets t) {
        String sql = "INSERT INTO tickets (route_id, seat_id, order_id, passenger_name, passenger_phone)\n"
                + "VALUES (?, ?, ?, ?, ?);";

        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, t.getRoute_id());
            ps.setInt(2, t.getSeat_id());
            ps.setInt(3, t.getOrder_id());
            ps.setNString(4, t.getPassenger_name());
            ps.setString(5, t.getPassenger_phone());

            int i = ps.executeUpdate();
            if (i != 0) {
                return "SUCCESS";
            }
            ps.close();

        } catch (Exception e) {
            System.err.println("RegisterRepository File:: " + e);
        }
        return "ERROR";
    }
    
    public static void main(String[] args) {
        TicketRepository tr = new TicketRepository();
        int id = 1;
        String name = new String("Nguyễn Anh Tú");
        String phone = new String("0912644974");
        Tickets t = new Tickets(id, id, id, name, phone);
        System.out.println(tr.InserTicket(t));
    }
}
