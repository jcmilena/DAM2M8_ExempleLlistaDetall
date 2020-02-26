package com.example.dam2m8_exemplellistadetall.ui.llista;

import com.example.dam2m8_exemplellistadetall.Model.Usuari;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlistaViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Usuari>> mLlistat;
    private MutableLiveData<Usuari> mUsuari;

    public LlistaViewModel() {
        mLlistat = new MutableLiveData<>();
        mUsuari = new MutableLiveData<>();
        aconseguirLlistat();
    }

    private void aconseguirLlistat() {

        //Aqui aconseguim el llistat picant la info, pero normalment vindrà de BBDD
        ArrayList<Usuari> llistat_temporal = new ArrayList<>();

        llistat_temporal.add(new Usuari("alvaro@jda.org","Alvaro","Molina","Informatica"));
        llistat_temporal.add(new Usuari("nacho@jda.org","Ignacio","Torres","Informatica"));
        llistat_temporal.add(new Usuari("milena@jda.org","Juan C.","Milena","Informatica"));


        mLlistat.setValue(llistat_temporal);

    }

    public LiveData<ArrayList<Usuari>> getLlistat() {
        return mLlistat;
    }

    public LiveData<Usuari> getUsuari() {
        return mUsuari;
    }

    public void getDetallUsuari(int posicio){

        //Se suposa que jo tinc accés aquí a la llista usuari
        //fent crida a BBDD, inclus a un usuari concret fent SELECT WHERE
        mUsuari.setValue(mLlistat.getValue().get(posicio));
    }
}