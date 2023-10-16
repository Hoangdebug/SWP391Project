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
import model.entity.Cars;

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
                String from = rs.getString(3);
                String to = rs.getString(4);
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
                return new Carroutes(rs.getInt("id"),rs.getInt("car_id"),rs.getString("from"),rs.getString("to"),rs.getFloat("price"),rs.getString("start"),rs.getString("end"),rs.getDate("datestart"),rs.getInt("user_id"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return c;
    }
    
    public static void main(String[] args) {
        CarRouteRepository crr = new CarRouteRepository();
//        System.out.println(crr.getListCarroutes());
        System.out.println(crr.getCarroute("1"));
    }
}
