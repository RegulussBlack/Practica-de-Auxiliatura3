/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author Fabricio
 * 
 * Enunciado:
 * a) Implementa el método guardarEmpleado(Empleado e) para almacenar empleados.
 * b) Implementa buscaEmpleado(String n) a través del nombre, para ver los datos del Empleado n.
 * c) Implementa mayorSalario(float sueldo), que devuelva al primer empleado con sueldo mayor al ingresado.
 */

import java.io.*;
import java.util.ArrayList;

public class Ejercicio1 {

    public static void main(String[] args) {
        try {
            // Crear y guardar empleados
            Empleado e1 = new Empleado("Juan", 3000);
            Empleado e2 = new Empleado("Ana", 4500);
            Empleado e3 = new Empleado("Luis", 5000);

            Persistencia.guardarEmpleado(e1);
            Persistencia.guardarEmpleado(e2);
            Persistencia.guardarEmpleado(e3);

            // Buscar empleado por nombre
            Empleado buscado = Persistencia.buscaEmpleado("Ana");
            if (buscado != null) {
                System.out.println("Empleado encontrado: " + buscado);
            } else {
                System.out.println("Empleado no encontrado.");
            }

            // Buscar empleado con salario mayor
            Empleado mayor = Persistencia.mayorSalario(4000);
            if (mayor != null) {
                System.out.println("Empleado con salario mayor a 4000: " + mayor);
            } else {
                System.out.println("Ningún empleado con salario mayor.");
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}


class Empleado implements Serializable {
    String nombre;
    float sueldo;

    public Empleado(String nombre, float sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return nombre + " - " + sueldo;
    }
}


class Persistencia {
    private static final String ARCHIVO = "empleados.dat";

    public static void guardarEmpleado(Empleado e) throws IOException {
        ArrayList<Empleado> lista = leerTodos();
        lista.add(e);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
        out.writeObject(lista);
        out.close();
    }

    public static Empleado buscaEmpleado(String n) throws IOException, ClassNotFoundException {
        for (Empleado e : leerTodos()) {
            if (e.nombre.equalsIgnoreCase(n)) return e;
        }
        return null;
    }

    public static Empleado mayorSalario(float sueldo) throws IOException, ClassNotFoundException {
        for (Empleado e : leerTodos()) {
            if (e.sueldo > sueldo) return e;
        }
        return null;
    }

    private static ArrayList<Empleado> leerTodos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<Empleado>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
