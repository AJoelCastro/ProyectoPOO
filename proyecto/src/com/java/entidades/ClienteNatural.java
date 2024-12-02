package com.java.entidades;

public class ClienteNatural extends Cliente{
    private String identificacion;
    private String fechaNacimiento;
    private String estadoCivil;

    public ClienteNatural(String identificacion, String fechaNacimiento, String estadoCivil, String telefono, String correoElectronico, String direccion, String nombre, String apellido, int tipoCliente) {
        super(telefono, correoElectronico, direccion, nombre, apellido, tipoCliente);
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
    } 

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
   

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                //"Apellidos: " + getApellido() + "\n" +
                "Identificacion: " + getIdentificacion() + "\n" +
                "Fecha de nacimiento: " + getFechaNacimiento() + "\n" +
                "Estado civil: " +  getEstadoCivil() + "\n" +
                "Telefono: " + getTelefono() + "\n" +
                "Correo electronico: " + getCorreoElectronico() + "\n" +
                "Direccion de residencia: " +  getDireccion() + "\n";
    }  
}
