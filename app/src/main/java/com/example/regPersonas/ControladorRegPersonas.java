package com.example.regPersonas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ControladorRegPersonas {

    private BaseDeBato db;

    public ControladorRegPersonas(Context context) {
        this.db = new BaseDeBato(context);
    }

    public long agregarPersona(varPersonas e){
        try{

            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(createBD.columna_cedula, e.cedula);
            valores.put(createBD.columna_nombre, e.nombre);
            valores.put(createBD.columna_estrato, e.estrato);
            valores.put(createBD.columna_salario, e.salario);
            valores.put(createBD.columna_nivel, e.nivel);
            long id = database.insert(createBD.tabla_registro_personas,null, valores);
            return id;
        }
        catch (Exception ex){
            System.out.println("Error");
            return 0;
        }
    }

    public boolean buscarPersona(String cedula){
        String[] args = new String[] {cedula};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query(createBD.tabla_registro_personas, null, "cedula=?", args,
                null, null, null);
        if (c.getCount()>0) {
            database.close();
            return true;
        }
        else{
            database.close();
            return false;}
    }

    public void eliminarPersona(String ced){
            SQLiteDatabase database = db.getReadableDatabase();
            database.execSQL("DELETE FROM personas where cedula=?", new String[]{ced});
    }

    public long actualizarPersona(varPersonas e){
        try{
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            String[] args = new String[] {e.cedula};
            valores.put(createBD.columna_nombre, e.nombre);
            valores.put(createBD.columna_estrato, e.estrato);
            valores.put(createBD.columna_salario, e.salario);
            valores.put(createBD.columna_nivel, e.nivel);
            long id = database.update(createBD.tabla_registro_personas, valores,"cedula=?",args);
            database.close();
            return id;
        }
        catch (Exception ex){
            System.out.println("Error");
            return 0;
        }

    }


    public Cursor mostrar() {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select cedula as _id, nombre, estrato, salario, nivel " +
                    "from personas", null);
            return cur;
        } catch (Exception ex) {
            System.out.println("Error");
            return null;
        }
    }

    public Cursor personSearch(String cedula) {
        String[] ced = new String[] {cedula};
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select cedula as _id, nombre, estrato, salario, nivel from personas " +
                    "where cedula=?",ced , null);
            return cur;
        } catch (Exception ex) {
            System.out.println("Error");
            return null;
        }
    }

}