/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author tuna
 */
public class Orders {
//    CREATE TABLE [dbo].[orders] (
//    [id]      INT            IDENTITY (1, 1) NOT NULL,
//    [user_id] INT            NULL,
//    [status]  INT            NOT NULL,
//    [price]   DECIMAL (10, 2) NOT NULL,
//    PRIMARY KEY CLUSTERED ([id] ASC),
//    FOREIGN KEY ([user_id]) REFERENCES [dbo].[users] ([id])
//);
    private int id;
    private int user_id;
    private int status;
    private float total_price;

    public Orders() {
    }

    public Orders(int id, int user_id, int status, float total_price) {
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }

    public Orders(int user_id, int status, float total_price) {
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", user_id=" + user_id + ", status=" + status + ", total_price=" + total_price + '}';
    }
    
    
    
}
