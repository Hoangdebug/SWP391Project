/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class Carroutes {
//    CREATE TABLE carroutes (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    car_id INT,
//    `from` VARCHAR(255),
//    `to` VARCHAR(255),
//    price DECIMAL(13, 3),
//    start TIME,
//    end TIME,
//    datestart DATE,
//    user_id INT,
//    FOREIGN KEY (car_id) REFERENCES cars(id),
//    FOREIGN KEY (user_id) REFERENCES users(id)
//);

    private int id;
    private int car_id;
    private int users_id;
    private String from;
    private String to;
    private float price;
    private String start;
    private String end;
    private Date datastart;
    private String carname;
    private String driver;

    public Carroutes(int id, int car_id, int users_id, String from, String to, float price, String start, String end, Date datastart) {
        this.id = id;
        this.car_id = car_id;
        this.users_id = users_id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.start = start;
        this.end = end;
        this.datastart = datastart;
    }

    public Carroutes(int car_id, String from, String to, float price, String start, String end, Date datastart) {
        this.car_id = car_id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.start = start;
        this.end = end;
        this.datastart = datastart;
    }

    public Carroutes(int id, int car_id, String from, String to, float price, String start, String end, Date datestart, int user_id) {
        this.id = id;
        this.car_id = car_id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.start = start;
        this.end = end;
        this.datastart = datestart;
        this.users_id = user_id;
    }

    public Carroutes(int id, String from, String to, float price, String start, String end, Date datastart, String carname, String driver) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.start = start;
        this.end = end;
        this.datastart = datastart;
        this.carname = carname;
        this.driver = driver;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getPrice() {
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

    public Date getDatastart() {
        return datastart;
    }

    public void setDatastart(Date datastart) {
        this.datastart = datastart;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

}
