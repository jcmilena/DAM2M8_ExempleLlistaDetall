package com.example.dam2m8_exemplellistadetall.Model;

import android.os.Parcelable;

import java.io.Serializable;

public class Usuari implements Serializable {

    String email;
    String nom;
    String cognom;
    String departament;

    public Usuari() {
    }

    public Usuari(String email, String nom, String cognom, String departament) {
        this.email = email;
        this.nom = nom;
        this.cognom = cognom;
        this.departament = departament;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
}
