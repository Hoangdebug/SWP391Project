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
public class Seats {
//      id INT AUTO_INCREMENT PRIMARY KEY,
//    car_id INT,
//    seat_number INT,
//    is_booked BOOLEAN,
//    FOREIGN KEY (car_id) REFERENCES cars(id)\

    private int id;
    private int isbooked;
    private int seat_number;
    private int idcar;

    public Seats() {
    }
    
    

    public Seats(int id, int isbooked, int seat_number, int idcar) {
        this.id = id;
        this.isbooked = isbooked;
        this.seat_number = seat_number;
        this.idcar = idcar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbooked() {
        return isbooked;
    }

    public void setIsbooked(int isbooked) {
        this.isbooked = isbooked;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getIdcar() {
        return idcar;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    @Override
    public String toString() {
        return "Seats{seat_number=" + seat_number+'}';
    }
    
    

}
