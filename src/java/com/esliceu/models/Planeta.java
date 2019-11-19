package com.esliceu.models;

import java.math.BigInteger;

public class Planeta {
    private int id;
    private String nom;
    private float massa;
    private Boolean habitable;

    public Planeta(String nom, float massa, Boolean habitable) {
        this.id = id;
        this.nom = nom;
        this.massa = massa;
        this.habitable = habitable;
    }

    public int getId() {
        return id;
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
        return "Planeta{" + "id=" + id + ", nom='" + nom + '\'' + ", massa=" + massa + ", habitable=" + habitable + '}';
    }
}
