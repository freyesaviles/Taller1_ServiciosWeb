package com.uam.taller1_serviciosweb.model;

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

}