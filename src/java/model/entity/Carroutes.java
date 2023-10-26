/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.sql.Date;

/**
 *
 * @author tuna
 */
public class Carroutes {

    private int id;
    private int car_id;
    private int from;
    private int to;
    private float price;
    private String start;
    private String end;
    private Date datestart;
    private int user_id;

    public Carroutes() {
    }

    public Carroutes(int id, int car_id, int from, int to, float price, String start, String end, Date datestart, int user_id) {
        this.id = id;
        this.car_id = car_id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.start = start;
        this.end = end;
        this.datestart = datestart;
        this.user_id = user_id;
    }

    public Carroutes(int car_id, int from, int to, float price, String start, String end, Date datestart, int user_id) {
        this.car_id = car_id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.start = start;
        this.end = end;
        this.datestart = datestart;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
    
}
