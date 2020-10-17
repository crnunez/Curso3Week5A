package com.carlosnunez.curso3week5a.fragment;


import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.carlosnunez.curso3week5a.R;
import com.carlosnunez.curso3week5a.adapter.MascotaAdapterPics;
import com.carlosnunez.curso3week5a.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> picMascota;
    private RecyclerView listaPicsMascota;
    private CircularImageView circularImageView;

    public PerfilFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaPicsMascota = (RecyclerView) view.findViewById(R.id.rvPicsMascota);
        GridLayoutManager llm = new GridLayoutManager(getContext(), 3);
        listaPicsMascota.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        CircularImageView circularImageView = view.findViewById(R.id.circularImageView);
        circularImageView.setCircleColor(Color.WHITE);
        circularImageView.setBorderColor(Color.DKGRAY);
        circularImageView.setBorderWidth(10);
        circularImageView.setShadowEnable(true);
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.DKGRAY);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);
        return view;
    }

    public MascotaAdapterPics adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdapterPics(picMascota, getActivity());
        listaPicsMascota.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        picMascota = new ArrayList<Mascota>();
        picMascota.add(new Mascota(R.drawable.primerperrosiberiano,190));
        picMascota.add(new Mascota(R.drawable.segundoperrosiberiano,124));
        picMascota.add(new Mascota(R.drawable.tercerperrosiberiano,33));
        picMascota.add(new Mascota(R.drawable.cuartoperrosiberiano,59));
        picMascota.add(new Mascota(R.drawable.quintoperrosiberiano,41));
        picMascota.add(new Mascota(R.drawable.sextoperrosiberiano,130));
    }
}