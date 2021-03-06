package com.esliceu.models;

public class Satelit {
    int idsatelit;
    String nom;
    Double massa;
    int velocitat;
    int idplaneta;

    public Satelit(){

    }


    // TODO se tiene que quitarntodos lo parámetros del constructor, y crearlo todo desde setters
    public Satelit(int idsatelit,String nom, Double massa, int velocitat, int idplaneta) {
        this.idsatelit = idsatelit;
        this.nom = nom;
        this.massa = massa;
        this.velocitat = velocitat;
        this.idplaneta = idplaneta;
    }


    public int getIdsatelit() {
        return idsatelit;
    }

    public void setIdsatelit(int idsatelit) {
        this.idsatelit = idsatelit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getMassa() {
        return massa;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public int getIdplaneta() {
        return idplaneta;
    }

    public void setIdplaneta(int idplaneta) {
        this.idplaneta = idplaneta;
    }

    @Override
    public String toString() {
        return "Satelit{" + "idsatelit=" + idsatelit + ", nom='" + nom + '\'' + ", massa=" + massa + ", velocitat=" + velocitat + ", idplaneta=" + idplaneta + '}';
    }
}
