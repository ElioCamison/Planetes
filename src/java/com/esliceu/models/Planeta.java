package com.esliceu.models;

import java.io.Serializable;
import java.math.BigInteger;

public class Planeta implements Serializable {
    private int idplaneta;
    private String nom;
    private float massa;
    private Boolean habitable;

    public Planeta() {
    }

    public void setIdplaneta(int idplaneta) {
        this.idplaneta = idplaneta;
    }

    public int getIdplaneta() {
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

    // TODO això ha ser isHabitable
    public Boolean isHabitable() {
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
