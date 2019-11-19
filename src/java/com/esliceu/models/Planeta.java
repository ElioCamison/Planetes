package com.esliceu.models;

import java.math.BigInteger;

public class Planeta {
    private int idplaneta;
    private String nom;
    private float massa;
    private Boolean habitable;

    public Planeta(String nom, float massa, Boolean habitable) {
        this.idplaneta = idplaneta;
        this.nom = nom;
        this.massa = massa;
        this.habitable = habitable;
    }

    public void setIdplaneta(int idplaneta) {
        this.idplaneta = idplaneta;
    }

    public int getId() {
        return idplaneta;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getMassa() {
        return massa;
    }

    public void setMassa(float massa) {
        this.massa = massa;
    }

    public Boolean getHabitable() {
        return habitable;
    }

    public void setHabitable(Boolean habitable) {
        this.habitable = habitable;
    }

    @Override
    public String toString() {
        return "Planeta{" + "id=" + idplaneta + ", nom='" + nom + '\'' + ", massa=" + massa + ", habitable=" + habitable + '}';
    }
}
