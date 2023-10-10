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
import model.entity.Users;

/**
 *
 * @author ADMIN
 */
public class CarsRepository {
    
    public static List<Cars> getAllCar(){
        List<Cars> list = new ArrayList<>();
        try(Connection conn = DBConnect.getConnection()) {
            
            String query = "SELECT * FROM cars WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int countseat = rs.getInt("countseat");
                int isactive = rs.getInt("isactive");
                String licenseplate = rs.getString("licenseplate");
                
                Cars cars = new Cars(id, name, type, countseat, isactive, licenseplate);
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
    
    
    public static void updateCar(Cars cars) {

        try (Connection conn = DBConnect.getConnection()) {

            String query = "UPDATE cars\n"
                    + "SET name = ?,\n"
                    + "    type = ?,\n"
                    + "    countseat = ?,\n"
                    + "    isactive = ? \n"
                    + "    licenseplate = ?\n"
                    + "WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, cars.getName());
            ps.setString(2, cars.getType());
            ps.setInt(3, cars.getCountseat());
            ps.setInt(4, cars.getIsactive());
            ps.setString(5, cars.getLiscenseplate());
            ps.setInt(6, cars.getId());
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update at CarsRepository");
        }
    }
    
}
