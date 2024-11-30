package com.java.entidades;
import java.util.*;

public class CuentaAhorro extends Cuenta implements ImptoTransaccionesFinancieras, InteresMensual {
    private static float tasaInteresAnual = 0.04f;
    private ClienteNatural titular;
    private ArrayList<Movimiento> operaciones;

    // Constructor con parametros
    public CuentaAhorro(String dni, String nombreCliente, String apellidoCliente, int tipoCliente,
        String clave, int tipoCuenta) {
    super(clave, tipoCuenta);
    titular = new ClienteNatural(dni, nombreCliente, apellidoCliente, tipoCliente);
    operaciones = new ArrayList<>();
    }

    // Constructor con parametros
    public CuentaAhorro(String dni, String nombreCliente, String apellidoCliente, int tipoCliente, 
        String clave, float saldoCuenta, int tipoCuenta) { 
    super(saldoCuenta, clave, tipoCuenta);
    titular = new ClienteNatural(dni, nombreCliente, apellidoCliente, tipoCliente);  
    operaciones = new ArrayList<>();
    }

    // Constructor con parametros
    public CuentaAhorro(ClienteNatural titular, String clave, int tipoCuenta) {
    super(clave, tipoCuenta);
    this.titular = titular;
    operaciones = new ArrayList<>();
    }

    // Constructor con parametros
    public CuentaAhorro(ClienteNatural titular, String clave, float saldoCuenta, int tipoCuenta) { 
    super(saldoCuenta, clave, tipoCuenta);
    this.titular = titular;        
    operaciones = new ArrayList<>();
    }

    public ClienteNatural getTitular() {
    return titular;                
    }

    public String getApellidoCliente() {
    return titular.getApellido();
    }

    public static void modificarTasaInteresAnual(float tasaInteresA) {
    tasaInteresAnual = tasaInteresA;
    }

    public static float obtenerTasaInteresAnual() {
    return tasaInteresAnual;
    }

    @Override
    public String toString() {
    return super.toString() + getTitular().toString() + "\n\tSaldo de ahorros: " + getSaldoCuenta();
    }

    public boolean realizarDeposito(float montoD) {
    Movimiento movimiento;
    setSaldoCuenta(getSaldoCuenta() + montoD);
    movimiento = new Movimiento(1, montoD);
    operaciones.add(movimiento);
    if(montoD >= 1000) {
        setSaldoCuenta(getSaldoCuenta() - calcularITF(montoD));
        movimiento = new Movimiento(4, calcularITF(montoD));
        operaciones.add(movimiento);
    }
    return true;
    }

    public boolean realizarRetiro(float montoR) {
    Movimiento movimiento;
    float montoITF = calcularITF(montoR);
    if(montoR >= 1000) {
        if(montoR + montoITF <= getSaldoCuenta()) {
            setSaldoCuenta(getSaldoCuenta() - montoR);
            movimiento = new Movimiento(2, montoR);
            operaciones.add(movimiento);
            setSaldoCuenta(getSaldoCuenta() - montoITF);
            movimiento = new Movimiento(4, montoITF);
            operaciones.add(movimiento);
            return true;
        }
        return false;
    } else {
        if(montoR <= getSaldoCuenta()) {
            setSaldoCuenta(getSaldoCuenta() - montoR);
            movimiento = new Movimiento(2, montoR);
            operaciones.add(movimiento);
            return true;
        }
    }
    return false;
    }

    @Override
    public void calcularInteresMensual() {
    Movimiento movimiento;
    float interesMensual = getSaldoCuenta() * obtenerTasaInteresAnual()/12;
    setSaldoCuenta(getSaldoCuenta() + interesMensual);
    movimiento = new Movimiento(5, interesMensual);
    operaciones.add(movimiento);
    }    

    @Override
    public float calcularITF(float cantidad) {
    return cantidad * ITF;
    }

    public ArrayList<Movimiento> getOperaciones() {
    return operaciones;
    }

    // Componente (clase interna)
    public class Movimiento {
    private String numeroOperacion;
    private GregorianCalendar fechaOperacion;
    private int tipoOperacion;
    private float montoOperacion;

    public Movimiento(int tipoOperacion, float montoOperacion) {
        numeroOperacion = generarNumeroOperacion();
        fechaOperacion = new GregorianCalendar();
        this.tipoOperacion = tipoOperacion;
        this.montoOperacion = montoOperacion;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public GregorianCalendar getFechaOperacion() {
        return fechaOperacion;
    }

    public void setTipoOperacion(int tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public void setMontoOperacion(float montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public float getMontoOperacion() {
        return montoOperacion;
    }

    @Override
    public String toString() {
        String tipo = "";
        switch(tipoOperacion) {
            case 1: tipo = "Deposito"; break;
            case 2: tipo = "Retiro"; break;
            case 3: tipo = "Transferencia"; break;
            case 4: tipo = "ITF"; break;
            case 5: tipo = "Interes mensual"; break;
        }
        return "\n\tNumero de operacion: " + getNumeroOperacion() +
            "\n\tFecha: " + getFechaOperacionCorta() + 
            "\n\tTipo: " + tipo + "\n\tMonto: " + getMontoOperacion();
    }

    public String getFechaOperacionCorta() {
        int dia, mes, anio;
        dia = getFechaOperacion().get(Calendar.DAY_OF_MONTH);
        mes = getFechaOperacion().get(Calendar.MONTH)+1;
        anio = getFechaOperacion().get(Calendar.YEAR);
        return (dia<=9?"0"+dia:dia) + "/" + (mes<=9?"0"+mes:mes) + "/" + anio;
    }

    private String generarNumeroOperacion() {
        int numDig=0, num=0, dato=0;
        String numCuenta = "";
        num = dato = getOperaciones().size();
        while (num > 9) {
            numDig++;
            num /= 10;
        }
        numDig++;
        for(int i=0;i<10-numDig; i++)
            numCuenta += "0";
        numCuenta += dato;        
        return numCuenta;
    }        
    } // fin de la clase Movimiento
}  // fin de la clase CuentaAhorro
