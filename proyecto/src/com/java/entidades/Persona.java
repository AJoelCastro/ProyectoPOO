package com.java.entidades;

public abstract class Persona {
    private String nombre;
    private String apellido;

    public Persona() {
        this("NN", "NA");
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    } s a
}
