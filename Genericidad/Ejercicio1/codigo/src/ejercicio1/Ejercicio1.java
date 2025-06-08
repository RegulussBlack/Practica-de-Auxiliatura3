/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Fabricio
 * // Enunciado:
// Crea una clase genérica Caja<T> para guardar algún tipo de objeto.
// a) Agrega métodos guardar() y obtener()
// b) Crea dos instancias de la caja y almacena 2 datos de diferente tipo
// c) Muestra el contenido de las cajas
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    


    public static void main(String[] args) {
      Caja<String> cajaString = new Caja<>();
      Caja<Integer> cajaInteger = new Caja<>();


        cajaString.guardar("Hola Mundo");
        cajaInteger.guardar(123);

        System.out.println("Caja de String: " + cajaString.obtener());
        System.out.println("Caja de Integer: " + cajaInteger.obtener());
    }
}