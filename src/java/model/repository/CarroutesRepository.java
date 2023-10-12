/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.config.DBConnect;
import model.entity.Carroutes;

/**
 *
 * @author ACER
 */
public class CarroutesRepository {

    public static void createCarroutes(Carroutes c) {
        try (Connection conn = DBConnect.getConnection()) {

            String query = "Insert into carroutes (car_id, from, to, price, start, end, datestart, user_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, c.getCar_id());
            ps.setString(2, c.getFrom());
            ps.setString(3, c.getTo());
            ps.setDouble(4, c.getPrice());
            ps.setString(5, c.getStart());
            ps.setString(6, c.getEnd());
            ps.setDate(7, c.getDatastart());
            ps.setInt(8, c.getUsers_id());

            ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI DANG KY Carroutes trong CarroutesRepository------------");
        }

    }

    public ArrayList<Carroutes> getListCarroutes() {
        ArrayList<Carroutes> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT carroutes.id, cars.name AS car_name, carroutes.`from`, carroutes.`to`, carroutes.price, carroutes.start, carroutes.end, carroutes.datestart, users.fullname\n"
                    + "FROM carroutes\n"
                    + "INNER JOIN cars ON carroutes.car_id = cars.id\n"
                    + "INNER JOIN users ON carroutes.user_id = users.id;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String car = rs.getString(2);
                String from = rs.getString(3);
                String to = rs.getString(4);
                float price = rs.getFloat(5);
                String start = rs.getString(6);
                String end = rs.getString(7);
                Date datestart = rs.getDate(8);
                String user = rs.getString(9);

                Carroutes c = new Carroutes(id, from, to, price, start, end, datestart, car, user);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong car repo");
        }
        return null;
    }

    public static Carroutes getIdCarroutes(int id) {
        Carroutes carroutes = null;
        try (Connection conn = DBConnect.getConnection()) {

            String query = "Select * from carroutes where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idCarroute = rs.getInt(1);
                Float price = rs.getFloat("price");
                carroutes = new Carroutes(id, price);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("Loi getId theo CarrouteRepository");
        }
        return carroutes;
    }
}
