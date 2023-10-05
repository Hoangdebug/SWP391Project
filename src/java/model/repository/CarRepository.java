/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.config.DBConnect;
import model.entity.Cars;

/**
 *
 * @author ACER
 */
public class CarRepository {

    public static List<Cars> findCarById() {
        List<Cars> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection()) {

            String query = "SELECT id, name, type FROM cars WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                Cars cars = new Cars(id, name, type);
                list.add(cars);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI GET ID Car trong CarsRepository------------");
        }
        return list;
    }

}
