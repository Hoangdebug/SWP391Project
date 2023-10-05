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
public class Cars {

    private int id;
    private String name;
    private String type;
    private int countseat;
    private int isactive;
    private String liscenseplate;

    public Cars(int id, String name, String type, int countseat, int isactive, String liscenseplate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.countseat = countseat;
        this.isactive = isactive;
        this.liscenseplate = liscenseplate;
    }

    public Cars(String name, String type, int countseat, String liscenseplate) {

        this.name = name;
        this.type = type;
        this.countseat = countseat;
        this.liscenseplate = liscenseplate;
    }

    public Cars() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cars(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCountseat() {
        return countseat;
    }

    public void setCountseat(int countseat) {
        this.countseat = countseat;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

    public String getLiscenseplate() {
        return liscenseplate;
    }

    public void setLiscenseplate(String liscenseplate) {
        this.liscenseplate = liscenseplate;
    }

}
