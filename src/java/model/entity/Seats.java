/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author tuna
 */
public class Seats {
//      id INT AUTO_INCREMENT PRIMARY KEY,
//    car_id INT,
//    seat_number INT,
//    is_booked BOOLEAN,
//    FOREIGN KEY (car_id) REFERENCES cars(id)\

    private int id;
    private int is_booked;
    private int seat_number;
    private int id_car;

    public Seats() {
    }

    public Seats(int id, int is_booked, int seat_number, int id_car) {
        this.id = id;
        this.is_booked = is_booked;
        this.seat_number = seat_number;
        this.id_car = id_car;
    }

    public Seats(int is_booked, int seat_number, int id_car) {
        this.is_booked = is_booked;
        this.seat_number = seat_number;
        this.id_car = id_car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIs_booked() {
        return is_booked;
    }

    public void setIs_booked(int is_booked) {
        this.is_booked = is_booked;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    @Override
    public String toString() {
        return "Seats{" + "id=" + id + ", is_booked=" + is_booked + ", seat_number=" + seat_number + ", id_car=" + id_car + '}';
    }

    
    
}