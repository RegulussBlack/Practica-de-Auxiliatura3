/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Fabricio
 */
class Caja<T> {
      private T contenido;

    public void guardar(T dato) {
        contenido = dato;
    }

    public T obtener() {
        return contenido;
    }
    
}
