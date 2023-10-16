/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.config.DBContext;
import model.entity.Orders;

/**
 *
 * @author tuna
 */
public class OrderRepository {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public String InserOrder(Orders o) {
        String sql = "INSERT INTO orders (user_id, status, total_price) VALUES (?, 0, ?);";

        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
  
            ps.setInt(1, o.getUser_id());
            ps.setFloat(2, o.getTotal_price());
            
            int i = ps.executeUpdate();
            if(i!=0){
                return "SUCCESS";
            }
            ps.close();

        } catch (Exception e) {
            System.err.println("RegisterRepository File:: " + e);
        }
        return "ERROR";
    }
    public Orders getNearOrder(){
        Orders o = new Orders();
        String sql = "SELECT TOP 1 * FROM orders ORDER BY id DESC";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(4));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return o;
    }
    
    
    
    public static void main(String[] args) {
        OrderRepository or = new OrderRepository();
        int userId = 1;
        float totalPrice = (float) 1200.009;
        Orders o = new Orders(userId,1, totalPrice);
        
//        System.out.println(or.InserOrder(o));
        System.out.println(or.getNearOrder());
    }
}
