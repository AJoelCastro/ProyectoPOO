package com.java.entidades;

public class ClienteNatural extends Cliente{
    private String dni;

    public ClienteNatural(String dni, String nombre, String apellido, int tipoCliente) {
        super(nombre, apellido, tipoCliente);
        this.dni = dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "\n\tNumero de DNI: " + getDni() + super.toString();
    }  
}
