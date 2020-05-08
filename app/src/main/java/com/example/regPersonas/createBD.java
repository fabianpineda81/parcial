package com.example.regPersonas;

public class createBD {

    public static final String nameDb = "Registro_de_personas";
    public static final String tabla_registro_personas = "personas";
    public static final String columna_cedula = "cedula";
    public static final String columna_nombre = "nombre";
    public static final String columna_estrato = "estrato";
    public static final String columna_salario = "salario";
    public static final String columna_nivel = "nivel";

    public static final String create_tabla_registro_personas = "CREATE TABLE IF NOT EXISTS "
            + createBD.tabla_registro_personas + " (" +
            createBD.columna_cedula + " text," +
            createBD.columna_nombre + " text," +
            createBD.columna_estrato + " text," +
            createBD.columna_salario + " text," +
            createBD.columna_nivel + " text"+
            ");";

}
