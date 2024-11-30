package com.java.entidades;

public class Cliente extends Persona{
    private int tipoCliente;

    public Cliente() {
        super();
        tipoCliente = 1;
    }

    public Cliente(String nombre, String apellido, int tipoCliente) {
        super(nombre, apellido);
        this.tipoCliente = tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
        
    public int getTipoCliente() {
        return tipoCliente;
    }
    
    @Override
    public String toString() {
        String tipo = "";
        switch(tipoCliente) {
            case 1: tipo = "Titular: "; break;
            case 2: tipo = "Representante: "; break; 
        }
        return "\n\t" + tipo + super.toString();
    }
}
