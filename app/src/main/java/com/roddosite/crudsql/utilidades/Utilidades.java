package com.roddosite.crudsql.utilidades;

public class Utilidades {


    public static final String TABLA_ARTICULO="articulos";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_DESCRIPCION="descripcion";
    public static final String CAMPO_PRECIO="precio";

    public static final String CREAR_TABLA_articulos="CREATE TABLE "+TABLA_ARTICULO+" ("+CAMPO_ID+" INTEGER, "+CAMPO_DESCRIPCION+" TEXT, "+CAMPO_PRECIO+" FLOAT)";

}
