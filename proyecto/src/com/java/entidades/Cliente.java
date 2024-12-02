package com.java.entidades;

public class Cliente extends Persona{
    private String telefono;
    private String correoElectronico;
    private String direccion;
    private int tipoCliente;

    public Cliente(String nombre, String apellido) {
        super(nombre, apellido);
        tipoCliente = 1;
    }

    
    public Cliente(String telefono, String correoElectronico, String direccion, String nombre, String apellido, int tipoCliente) {
        super(nombre, apellido);
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        String tipo = "";
        switch(tipoCliente) {
            case 1: tipo = "Titular: "; break;
            case 2: tipo = "Representante: "; break; 
        }
        return "\n" + tipo + super.toString();
    }
}
