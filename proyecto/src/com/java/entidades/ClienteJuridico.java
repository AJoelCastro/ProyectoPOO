package com.java.entidades;

public class ClienteJuridico extends Cliente {
    private String razonSocial;
    private String ruc;
    private String documentoDeConstitucion;

    public ClienteJuridico(String razonSocial, String ruc, String documentoDeConstitucion, String telefono, String correoElectronico, String direccion, String nombre, String apellido, int tipoCliente) {
        super(telefono, correoElectronico, direccion, nombre, apellido, tipoCliente);
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.documentoDeConstitucion = documentoDeConstitucion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDocumentoDeConstitucion() {
        return documentoDeConstitucion;
    }

    public void setDocumentoDeConstitucion(String documentoDeConstitucion) {
        this.documentoDeConstitucion = documentoDeConstitucion;
    }


    @Override
    public String toString() {
        return super.toString()+ "\n" +
                "Telefono: " +  getTelefono() + "\n" +
                "Correo electronico: " + getCorreoElectronico() + "\n" +
                "Razon social de la empresa: " + getRazonSocial() + "\n" +
                "RUC: " + getRuc() + "\n" +
                "Documento de contitucion de la empresa: " + getDocumentoDeConstitucion() + "\n" +
                "Direccion fiscal y/o de operaciones: " +  getDireccion() + "\n";
    }
}
