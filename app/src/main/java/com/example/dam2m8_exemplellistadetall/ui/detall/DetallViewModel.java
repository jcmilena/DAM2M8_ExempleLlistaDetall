package com.example.dam2m8_exemplellistadetall.ui.detall;

import com.example.dam2m8_exemplellistadetall.Model.Usuari;
import com.example.dam2m8_exemplellistadetall.ui.llista.LlistaViewModel;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class DetallViewModel extends ViewModel {

    private MutableLiveData<Usuari> mUsuari;
    private ArrayList<Usuari> llistat_temporal;
    private LlistaViewModel llistaViewModel;

    public DetallViewModel() {
        mUsuari = new MutableLiveData<>();
        llistat_temporal = new ArrayList<>();

        llistat_temporal.add(new Usuari("alvaro@jda.org","Alvaro","Molina","Informatica"));
        llistat_temporal.add(new Usuari("nacho@jda.org","Ignacio","Torres","Informatica"));
        llistat_temporal.add(new Usuari("milena@jda.org","Juan C.","Milena","Informatica"));

    }

    public LiveData<Usuari> getUsuari() {
        return mUsuari;
    }

    public void getDetallUsuari(int posicio){

        //Se suposa que jo tinc accés aquí a la llista usuari
        //fent crida a BBDD, inclus a un usuari concret fent SELECT WHERE
        mUsuari.setValue(llistat_temporal.get(posicio));
    }
}