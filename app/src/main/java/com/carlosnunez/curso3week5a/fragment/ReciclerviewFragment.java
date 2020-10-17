package com.carlosnunez.curso3week5a.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.carlosnunez.curso3week5a.R;
import com.carlosnunez.curso3week5a.adapter.MascotaAdapter;
import com.carlosnunez.curso3week5a.pojo.Mascota;
import com.carlosnunez.curso3week5a.presentador.RecyclerViewFragmentPresenter;
import java.util.ArrayList;

public class ReciclerviewFragment extends Fragment implements IRecyclerViewFragmentView {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return view;
    }

    @Override
    public void generarLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, getActivity());
        return mascotaAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter mascotaAdapter) {
        listaMascotas.setAdapter(mascotaAdapter);
    }
}