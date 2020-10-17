package com.carlosnunez.curso3week5a.fragment;

import com.carlosnunez.curso3week5a.adapter.MascotaAdapter;
import com.carlosnunez.curso3week5a.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLayoutVertical();

    public MascotaAdapter crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (MascotaAdapter mascotaAdapter);

}
