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
import java.util.List;
import model.config.DBConnect;
import model.entity.Carroutes;
import model.entity.Cars;
import model.entity.Users;

/**
 *
 * @author ACER
 */
public class StaffRepository {

    public static void createCar(Cars cars) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "INSERT INTO cars (name, type, countseat, licenseplate)\n"
                    + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cars.getName());
            ps.setString(2, cars.getType());
            ps.setInt(3, cars.getCountseat());
            ps.setString(4, cars.getLiscenseplate());

            ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Loox Staff Repo");
        }
    }

    public static void createRoute(Carroutes carroutes) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "INSERT INTO carroutes (car_id,  `from`, `to`, price, start, end, datestart,user_id)\n"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, carroutes.getCar_id());
            ps.setString(2, carroutes.getFrom());
            ps.setString(3, carroutes.getTo());
            ps.setFloat(4, (float) carroutes.getPrice());
            ps.setString(5, carroutes.getStart());
            ps.setString(6, carroutes.getEnd());
            ps.setDate(7, carroutes.getDatastart());
            ps.setInt(8, carroutes.getUsers_id());
            ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Loox Staff Repo");
        }
    }

    public static List<Carroutes> getAllCarroutes() {
        List<Carroutes> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {

            String query = "select * from carroutes";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int car_id = rs.getInt("car_id");
                int users_id = rs.getInt("user_id");
                String from = rs.getString("from");
                String to = rs.getString("to");
                Float price = rs.getFloat("price");
                String start = rs.getString("start");
                String end = rs.getString("end");
                Date date = rs.getDate("datestart");

                Carroutes car = new Carroutes(id, car_id, users_id, from, to, price, start, end, date);
                list.add(car);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI GET ID Carroutes trong CarroutesRepository------------");
        }
        return list;
    }
    
    
}
