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

    public static List<Cars> getAllCar() {
        List<Cars> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection()) {

            String query = "SELECT * FROM cars";

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

    public static void deleteCar(int id) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "Delete from cars WHERE id = ?\n";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI Delete Car trong CarsRepository------------");
        }
    }

    public ArrayList<Cars> getListCars() {
        ArrayList<Cars> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM cars";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idcar = rs.getInt(1);
                String namecar = rs.getString(2);
                String type = rs.getString(3);
                int countseat = rs.getInt(4);
                int isactive = rs.getInt(5);
                String licenseplate = rs.getString(6);
                Cars car = new Cars(idcar, namecar, type, countseat, isactive, licenseplate);
                list.add(car);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong car repo");
        }
        return null;
    }
    
    public static Cars getIdCar(int id){
        Cars car = null;
        try(Connection conn = DBConnect.getConnection()) {
            
            String query = "Select * from cars where id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int idcar = rs.getInt(1);
                String namecar = rs.getString(2);
                String type = rs.getString(3);
                int countseat = rs.getInt(4);
                int isactive = rs.getInt(5);
                String licenseplate = rs.getString(6);
                car = new Cars(id, namecar, type, countseat, isactive, licenseplate);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("Loi getId theo CarRepository");
        }
        return car;
    }     
}
