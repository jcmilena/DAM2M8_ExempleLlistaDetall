package com.example.dam2m8_exemplellistadetall.ui.detall;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.dam2m8_exemplellistadetall.Model.Usuari;
import com.example.dam2m8_exemplellistadetall.R;
import com.example.dam2m8_exemplellistadetall.ui.llista.LlistaViewModel;

public class DetallFragment extends Fragment {

    private DetallViewModel detallViewModel;

    private TextView email, nom, cognom, departament;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        detallViewModel =
                ViewModelProviders.of(this).get(DetallViewModel.class);
        View root = inflater.inflate(R.layout.fragment_detall, container, false);

        email = root.findViewById(R.id.emailDetallTextView);
        nom = root.findViewById(R.id.nomTextView);
        cognom = root.findViewById(R.id.cognomTextView);
        departament = root.findViewById(R.id.departamentTextView);

        //Aqui recullo la info d'usuari que m'ha passat el fragment anterior i la pinto en pantalla
        Usuari usuari = (Usuari) getArguments().getSerializable("DETALL");
        actualitzar_pantalla(usuari);

        //Una versió alternativa seria agafar nomes la posició i fer una crida al ViewModel
        //per a que em passes el detall d'aquesta posició.
        detallViewModel.getDetallUsuari(getArguments().getInt("POSICIO"));
        detallViewModel.getUsuari().observe(this, new Observer<Usuari>() {
            @Override
            public void onChanged(Usuari usuari) {
                //Aqui actualitzaria la pantalla
                Log.i("DETALLVIEWMODEL ", usuari.getNom());
            }
        });

        //Una altra versió alternativa és que aquest dos fragments comparteixin el mateix ViewModel
        LlistaViewModel llistaViewModel = ViewModelProviders.of(this).get(LlistaViewModel.class);
        llistaViewModel.getDetallUsuari(getArguments().getInt("POSICIO"));
        llistaViewModel.getUsuari().observe(this, new Observer<Usuari>() {
            @Override
            public void onChanged(Usuari usuari) {
                //Aqui actualitzaria la pantalla
                Log.i("SHAREDVIEWMODEL ", usuari.getCognom());
            }
        });



        return root;
    }

    private void actualitzar_pantalla(Usuari usuari) {

        email.setText("EMAIL: "+ usuari.getEmail());
        nom.setText("NOM: "+ usuari.getNom());
        cognom.setText("COGNOM: "+ usuari.getCognom());
        departament.setText("DEPARTAMENT: "+ usuari.getDepartament());
    }
}