/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.config.DBContext;
import model.entity.Carroutes;

/**
 *
 * @author tuna
 */
public class CarRouteRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<Carroutes> getListCarroutes() {
        ArrayList<Carroutes> list = new ArrayList<>();
        String sql = "SELECT * FROM carroutes";

        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int car_id = rs.getInt(2);
                int from = rs.getInt(3);
                int to = rs.getInt(4);
                float price = rs.getFloat(5);
                String start = rs.getString(6);
                String end = rs.getString(7);
                Date datestart = rs.getDate(8);
                int user_id = rs.getInt(9);
                
                Carroutes c = new Carroutes(id, car_id, from, to, price, start, end, datestart, user_id);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong car repo");
        }
        return null;
    }
    
    public Carroutes getCarroute(String id) {
        Carroutes c = new Carroutes();
        String sql = "SELECT * FROM carroutes WHERE id = ?";

        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Carroutes(rs.getInt("id"),rs.getInt("car_id"),rs.getInt("from"),rs.getInt("to"),rs.getFloat("price"),rs.getString("start"),rs.getString("end"),rs.getDate("datestart"),rs.getInt("user_id"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return c;
    }
    
    public void createCarroutes(Carroutes c) {
        
        String sql = "INSERT INTO [dbo].[carroutes] ([car_id], [from], [to], [price], [start], [end], [datestart], [user_id])\n" +
"VALUES (?, ?, ?, ?, ?, ?, ?,?);";
        try{
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, c.getCar_id());
            ps.setInt(2, c.getFrom());
            ps.setInt(3, c.getTo());
            ps.setFloat(4, c.getPrice());
            ps.setString(5, c.getStart());
            ps.setString(6, c.getEnd());
            ps.setDate(7, c.getDatestart());
            ps.setInt(8, c.getUser_id());

            ps.executeUpdate();
            con.commit();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI DANG KY Carroutes trong CarroutesRepository------------");
        }
    }
    
    public ArrayList<Carroutes> searchCarroutes(int from, int to, Date datestart) {

        ArrayList<Carroutes> list = new ArrayList<>();
        
        String sql = "Select * from carroutes where [from] = ? and [to] = ? and datestart = ?";

        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
           
            ps.setInt(1, from);
            ps.setInt(2, to);
            ps.setDate(3, datestart);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                int car_id = rs.getInt(2);
                from = rs.getInt(3);
                to = rs.getInt(4);
                float price = rs.getFloat(5);
                String start = rs.getString(6);
                String end = rs.getString(7);
                datestart = rs.getDate(8);
                int user_id = rs.getInt(9);
                
                Carroutes c = new Carroutes(id, car_id, from, to, price, start, end, datestart, user_id);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi get list trong car repo");
        }
        return null;
    }
    
    public static void main(String[] args) {
        CarRouteRepository crr = new CarRouteRepository();
//        System.out.println(crr.getListCarroutes());
//        System.out.println(crr.getCarroute("1"));
        int car_id = 2;
        int from = 3;
        int to = 4;
        float price = (float) 500.000;
        String start = "09:00:00";
        String end = "15:00:00";
        Date datestart = Date.valueOf("2023-12-26");
        int user_id = 4;
        Carroutes cr = new Carroutes(car_id, from, to, price, start, end, datestart, user_id);
        crr.createCarroutes(cr);
    }
}
