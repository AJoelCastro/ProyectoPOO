package com.java.datos;

import com.java.entidades.*;
import java.util.*;

public class ListaCuentas {
private ArrayList<Cliente> cliente = new ArrayList<>();
   
   public ClienteNatural ingresoDatosClienteNatural(){
     Scanner scanner = new Scanner(System.in);
     
    System.out.print("Ingrese el nombre: ");
    String nombre = scanner.nextLine();
    
    System.out.print("Ingrese el apellido: ");
    String apellido = scanner.nextLine();
    
    System.out.print("Ingrese la identificación (DNI o  pasaporte): ");
    String identificacion = scanner.nextLine();
    
    System.out.print("Ingrese la fecha de nacimiento (dd/mm/aaaa): ");
    String fechaNacimiento = scanner.nextLine();
    
    System.out.print("Ingrese la dirección:");
    String direccion = scanner.nextLine();
    
    System.out.print("Ingrese el teléfono: ");
    String telefono = scanner.nextLine();
    
    System.out.print("Ingrese el email:");
    String email = scanner.nextLine();
    
    System.out.print("Ingrese el estado civil:");
    String estadoCivil = scanner.nextLine(); 
    
    ClienteNatural clienteNatural = new ClienteNatural(identificacion, fechaNacimiento, estadoCivil, telefono, email, direccion, nombre, apellido,1);
   
    cliente.add(clienteNatural);
    
    return clienteNatural;
   }
   
   public ClienteJuridico ingresarDatosClienteJuridico(){
     Scanner scanner = new Scanner(System.in);
    
   System.out.print("Ingrese el nombre del representante legal:");
    String nombre= scanner.nextLine();
     
    System.out.print("Ingrese el apellido: ");
    String apellido = scanner.nextLine();
    
    System.out.print("Ingrese el teléfono:");
    String telefono = scanner.nextLine();
    
    System.out.print("Ingrese el email: ");
    String email = scanner.nextLine();
    
    System.out.print("Ingrese el nombre de la empresa (razón social): ");
    String razonSocial = scanner.nextLine();

    System.out.print("Ingrese el RUC:");
    String ruc = scanner.nextLine();
    
    System.out.print("Ingrese la dirección fiscal y/o operaciones: ");
    String direccion = scanner.nextLine();
    
    System.out.print("Ingrese el documento de constitucion de la empresa: ");
    String documento = scanner.nextLine();
        
    ClienteJuridico clienteJuridico = new ClienteJuridico(razonSocial, ruc, documento, telefono, email, direccion, nombre, apellido,2);
   
    cliente.add(clienteJuridico);
    
    return clienteJuridico; 
   }
    public void mostrarClientesNaturales() {
            for (Cliente clientes : cliente) {
                if (clientes instanceof ClienteNatural) {  
                    System.out.println(clientes);  
                }
            }
        }
    public void mostrarClientesJuridicos() {
        for (Cliente clientes : cliente) {
            if (clientes instanceof ClienteJuridico) {  
                System.out.println(clientes);  
            }
        }
    }
}
