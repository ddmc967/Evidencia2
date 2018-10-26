package com.example.daniel.evidencia2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class usuario implements Parcelable {
    private static final Object SaveInArgsDB = ;
    private static final Object ContentValues = ;
    public String primapellido;
    public String segapellido;
    public String nombre;
    public String sexo;
    public String sexo2;
    public String fecha;
    public String entidad;
    private String path;

    public usuario() {
        this.primapellido = "";
        this.segapellido = "";
        this.nombre = "";
        this.sexo = "";
        this.sexo2 = "";
        this.fecha = "0";
        this.entidad = "";
    }

    public static ArrayList<usuario> getCurps(RecyclerViewActivity recyclerViewActivity) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(primapellido);
        parcel.writeString(segapellido);
        parcel.writeString(nombre);
        parcel.writeString(sexo);
        parcel.writeString(sexo2);
        parcel.writeString(fecha);
        parcel.writeString(entidad);
        parcel.writeString(path);
    }

    public static final Parcelable.Creator<usuario> CREATOR
            = new Parcelable.Creator<usuario>() {
        public usuario createFromParcel(Parcel in) {
            return new usuario(in);
        }

        @Override
        public usuario[] newArray(int i) {
            return new usuario[i];
        }
    };

    private usuario(Parcel in) {
        this.primapellido = in.readString();
        this.segapellido = in.readString();
        this.nombre = in.readString();
        this.sexo = in.readString();
        this.sexo2 = in.readString();
        this.fecha = in.readString();
        this.entidad = in.readString();
    }

    public static ArrayList<usuario> getUsuarios(Context context) {
        return null;
    }

    private static class ArgsDB {
        private Context context;
        private String selection;
        private String[] selectionArgs;
        private String sortOrder;

        public final String ASC = UsuarioContract.usuarioEntry.COLUMNA_NOMBRE + " ASC";
        public final String DESC = UsuarioContract.usuarioEntry.COLUMNA_NOMBRE + " DESC";

        public ArgsDB(Context context) {
            this.context = context;
            this.selection = "";
            String[] a = {};
            this.selectionArgs = a;
            this.sortOrder = this.ASC;

        }

        public Context getContext() {
            return context;
        }

        public String getSelection() {
            return selection;
        }

        public String[] getSelectionArgs() {
            return selectionArgs;
        }

        public String getSortOrder() {
            return sortOrder;
        }
    }


    private class SaveInArgsDB extends AsyncTask<SaveInArgsDB, Void, Void> {

        @Override
        protected Void doInBackground(SaveInArgsDB... saveInArgsDBS) {
            Context context = SaveInArgsDB[0].getContext();
            UsuarioHelper usuarioHelper = new UsuarioHelper(context);
            SQLiteDatabase db = usuarioHelper.getWritableDatabase();

            ContentValues = new ContentValues();
            values.put(UsuarioContract.usuarioEntry.COLUMNA_NOMBRE, nombre);
            values.put(UsuarioContract.usuarioEntry.COLUMNA_APELLIDOPAT,primapellido );
            values.put(UsuarioContract.usuarioEntry.COLUMNA_APELLIDOMAT, segapellido);
            values.put(UsuarioContract.usuarioEntry.COLUMNA_GENERO, sexo);
            values.put(UsuarioContract.usuarioEntry.COLUMNA_ESTADO, entidad);
            values.put(UsuarioContract.usuarioEntry.COLUMNA_YEAR, fecha);
            values.put(UsuarioContract.usuarioEntry.COLUMNA_MES, fecha);
            values.put(UsuarioContract.usuarioEntry.COLUMNA_DIA, fecha);
            values.put(UsuarioContract.usuarioEntry.COLUMNA_PATH, path);

            if (id == 0){
                Long ids = db.insert(usuario.TABLE_NAME, usuario._ID, values);
                id = ids;
            } else {
                String[] selectionArgs = { String.valueOf(id) };
                db.update(usuario.TABLE_NAME, values, usuario._ID + " = ?", selectionArgs);
            }
            return null;
        }
    }

}