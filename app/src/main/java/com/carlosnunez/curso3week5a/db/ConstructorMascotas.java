package com.carlosnunez.curso3week5a.db;

import android.content.ContentValues;
import android.content.Context;

import com.carlosnunez.curso3week5a.R;
import com.carlosnunez.curso3week5a.pojo.Mascota;

import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    private String file = "RegistrosInsertados";
    private String[] archivos;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos baseDatos = new BaseDatos(context);
        archivos = context.fileList();

        if (existe(archivos, file)){

        } else {

            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_PRIVATE));
                outputStreamWriter.write("RegistrosOK");
                outputStreamWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            insertarMascotas(baseDatos);
        }

        return baseDatos.obtenerTodasLasMascotas();

    }

    public boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
            return false;
    }

    public void insertarMascotas (BaseDatos baseDatos){

        ContentValues contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.primerperro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "León");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Golden");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.segundoperro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Marcus");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Weimaraner");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.tercerperro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Felita");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Labrador");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.cuartoperro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tiger");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 9);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Beagle");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.quintoperro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Luna");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 12);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Labrador marron");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.sextoperro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lassie");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Setter Irlandes");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.septimoperro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Titán");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 15);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Labrador negro");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

    }

    public void darLikeMascota (Mascota mascota){

        int idMascota = 0;

        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, obtenerLikesMascota(mascota) + 1);
        idMascota = mascota.getId();
        baseDatos.insertarLikeMascota(contentValues , idMascota);

    }

    public int obtenerLikesMascota(Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesMascota(mascota);

    }

    public void ponerPosicion (Mascota mascota){

        int idMascota = 0;

        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, obtenerUltimaPosicion(mascota) + 1);
        idMascota = mascota.getId();
        baseDatos.ponerPosicion(contentValues, idMascota);

    }

    public int obtenerUltimaPosicion (Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerUltimaPosicion();
    }

    public int obtenerIdUltimaPosicion (Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerIdUltimaPosicion();

    }

    public ArrayList<Mascota> obtenerCincoMascotas(){
        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerCincoMascotas();
    }
}
