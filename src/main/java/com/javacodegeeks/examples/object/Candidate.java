package com.javacodegeeks.examples.object;

/**
 * Created by YongYanOspiea on 31/08/2016.
 */


public class Candidate {
    private int id;
    private String nom;
    private String prenom;
    private String phone;
    private String specialiste;
    private String rdv;


    public Candidate() {
    }


    public Candidate(int id, String nom, String prenom, String phone, String specialiste, String rdv) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.specialiste = specialiste;
        this.rdv = rdv;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }



    public String getSpecialiste() {
        return specialiste;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }

    public String getRdv() {
        return rdv;
    }

    public void setRdv(String rdv) {
        this.rdv = rdv;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", phone=" + phone +
                ", specialiste='" + specialiste + '\'' +
                ", rdv=" + rdv +
                '}';
    }
}
