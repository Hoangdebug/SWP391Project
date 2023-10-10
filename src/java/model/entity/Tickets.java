/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author ACER
 */
public class Tickets {
    private int id;
    private int route_id;
    private int seat_id;
    private int order_id;
    private String passenger_name;
    private String phone;
    private double price;

    public Tickets(int id, int route_id, int seat_id, int order_id, String passenger_name, String phone, double price) {
        this.id = id;
        this.route_id = route_id;
        this.seat_id = seat_id;
        this.order_id = order_id;
        this.passenger_name = passenger_name;
        this.phone = phone;
        this.price = price;
    }

    public Tickets(int route_id, int seat_id, int order_id, String passenger_name, String phone, double price) {
        this.route_id = route_id;
        this.seat_id = seat_id;
        this.order_id = order_id;
        this.passenger_name = passenger_name;
        this.phone = phone;
        this.price = price;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

}
