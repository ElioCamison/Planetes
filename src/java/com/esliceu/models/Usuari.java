package com.esliceu.models;

public class Usuari {

    int idusuari;
    String nom;
    String passwoord;

    public Usuari(){

    }

    public int getIdusuari() {
        return idusuari;
    }

    public void setIdusuari(int idusuari) {
        this.idusuari = idusuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }

    @Override
    public String toString() {
        return "Usuari{" + "idusuari=" + idusuari + ", nom='" + nom + '\'' + ", passwoord='" + passwoord + '\'' + '}';
    }
}
