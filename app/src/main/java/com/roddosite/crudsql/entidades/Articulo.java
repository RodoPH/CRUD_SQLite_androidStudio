package com.roddosite.crudsql.entidades;

public class Articulo {

    private Integer id;
    private String descripcion;
    private Float precio;

    public Articulo(Integer id, String descripcion, Float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public Articulo(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
