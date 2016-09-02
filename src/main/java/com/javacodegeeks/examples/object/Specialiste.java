package com.javacodegeeks.examples.object;

/**
 * Created by YongYanOspiea on 01/09/2016.
 */
public class Specialiste {

    private int id;
    private String specialiste;

    public Specialiste() {
    }

    public Specialiste(int id, String specialiste) {
        this.id = id;
        this.specialiste = specialiste;
    }

    public int getId() {
        return id;
    }

    public String getSpecialiste() {
        return specialiste;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }
}
