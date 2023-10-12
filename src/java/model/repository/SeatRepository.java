package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.config.DBConnect;
import model.entity.Seats;

/**
 *
 * @author ACER
 */
public class SeatRepository {

    public List<Seats> findSeatByDateTrip(int car_id, Date datestart) {

        List<Seats> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {

            String query = "SELECT seats.id, seats.seat_number, seats.is_booked\n"
                    + "FROM seats\n"
                    + "INNER JOIN carroutes ON seats.car_id = carroutes.car_id\n"
                    + "LEFT JOIN tickets ON seats.id = tickets.seat_id AND tickets.route_id = carroutes.id\n"
                    + "WHERE carroutes.datestart = ? and seats.is_booked = 0; ";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDate(1, datestart);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Seats seat = new Seats();
                seat.setId(rs.getInt("id"));
                seat.setSeat_number(rs.getInt("seat_number"));
                seat.setIsbooked(rs.getInt("is_booked"));
                list.add(seat);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("Loi o seat repository");
        }
        return list;
    }

    public ArrayList<Seats> getListSeats(String id_car) {
        ArrayList<Seats> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM seats where car_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_car);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int is_booked = rs.getInt("is_booked");
                int idcar = rs.getInt("car_id");
                int seat_number = rs.getInt("seat_number");

                Seats s = new Seats(id, is_booked, seat_number, idcar);
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong seat repo");
        }
        return null;
    }

    public static void main(String[] args) {
        SeatRepository sr = new SeatRepository();

//        System.out.println(sr.getListSeats(1));
    }

}
