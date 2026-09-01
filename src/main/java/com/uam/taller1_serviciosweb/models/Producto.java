package com.uam.taller1_serviciosweb.models;

public class Producto {

    private int id;
    private String nombre;
    private String presentacion;
    private String categoria;
    private boolean disponible;

    public Producto() {
    }

    public Producto(int id, String nombre, String presentacion,
                    String categoria, boolean disponible) {

        this.id = id;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presentacion='" + presentacion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}