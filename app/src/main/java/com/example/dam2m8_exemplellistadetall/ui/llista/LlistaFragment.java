package com.example.dam2m8_exemplellistadetall.ui.llista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dam2m8_exemplellistadetall.Model.Usuari;
import com.example.dam2m8_exemplellistadetall.R;

import java.util.ArrayList;

public class LlistaFragment extends Fragment {

    private LlistaViewModel llistaViewModel;

    private RecyclerView miRecycler;
    private ArrayList<Usuari> llistaUsuaris;
    private UsuarisAdapter miAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        llistaViewModel =
                ViewModelProviders.of(this).get(LlistaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_llista, container, false);

        miRecycler = root.findViewById(R.id.llistatRecycler);
        miRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        miRecycler.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        miAdapter = new UsuarisAdapter();
        miRecycler.setAdapter(miAdapter);

        llistaViewModel.getLlistat().observe(getViewLifecycleOwner(), new Observer<ArrayList<Usuari>>() {
            @Override
            public void onChanged(ArrayList<Usuari> usuaris) {
                llistaUsuaris = usuaris;
                miAdapter.notifyDataSetChanged();

            }
        });


        return root;
    }

    private class UsuariViewHolder extends RecyclerView.ViewHolder{

        TextView email;

        public UsuariViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.emailDetallTextView);

            //Aqui definim que fem en clickar un element
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Genero un bundle on afegiré l'usuari on han fet click
                    Bundle bundle = new Bundle();
                    bundle.putInt("POSICIO", getAdapterPosition());
                    //Utilitzo getAdapterPosition per coneixer quin element haig de mostrar
                    bundle.putSerializable("DETALL", llistaUsuaris.get(getAdapterPosition()));
                    //Utilitzo Navigation per canviar pantalla, encara que també serveir FragmentManager
                    Navigation.findNavController(view).navigate(R.id.nav_detall, bundle);
                }
            });


        }
    }

    private class UsuarisAdapter extends RecyclerView.Adapter<UsuariViewHolder> {

        public UsuarisAdapter(){};

        @NonNull
        @Override
        public UsuariViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UsuariViewHolder(getLayoutInflater().inflate(R.layout.viewholder_usuari, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull UsuariViewHolder holder, int position) {

            holder.email.setText(llistaUsuaris.get(position).getEmail());
        }

        @Override
        public int getItemCount() {
            return llistaUsuaris.size();
        }
    }
}