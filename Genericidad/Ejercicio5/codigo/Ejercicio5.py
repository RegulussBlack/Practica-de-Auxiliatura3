# -*- coding: utf-8 -*-
"""
Created on Sun Jun  8 04:30:59 2025

@author: Fabricio
"""

# Enunciado:
# Crea una clase genérica Pila<T>
# a) Implementa un método para apilar
# b) Implementa un método para desapilar
# c) Prueba la pila con diferentes tipos de datos
# d) Muestra los datos de la pila

class Pila:
    def __init__(self):
        self.datos = []

    def apilar(self, elemento):
        self.datos.append(elemento)

    def desapilar(self):
        if self.datos:
            return self.datos.pop()
        return None

    def mostrar(self):
        for elem in reversed(self.datos):
            print(elem)

#enteros
pila_entero = Pila()
pila_entero.apilar(10)
pila_entero.apilar(20)
print("Pila de enteros:")
pila_entero.mostrar()

#strings
pila_string = Pila()
pila_string.apilar("Hola")
pila_string.apilar("Mundo")
print("Pila de strings:")
pila_string.mostrar()
