/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;
import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    // Enunciado:
// Crea una clase genérica Catalogo<T> que almacene productos o libros.
// a) Agrega métodos para agregar y buscar elemento
// b) Prueba el catálogo con libros
// c) Prueba el catálogo con productos
    public static void main(String[] args) {
        Catalogo<String> libros = new Catalogo<>();
        libros.agregar("El Principito");
        libros.agregar("1984");
        System.out.println("Catalogo de libros:");
        libros.mostrar();

        Catalogo<String> productos = new Catalogo<>();
        productos.agregar("Laptop");
        productos.agregar("Mouse");
        System.out.println("Catalogo de productos:");
        productos.mostrar();
    }
}

    
    







