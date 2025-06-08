# -*- coding: utf-8 -*-
"""
Created on Sun Jun  8 04:40:21 2025

@author: Fabricio
"""
# Enunciado:
# a) Crear, leer y mostrar un archivo de farmacias
# b) Mostrar medicamentos para la tos de la sucursal número X
# c) Mostrar la dirección de las sucursales con el medicamento “Golpex”

import pickle

class Farmacia:
    def __init__(self, sucursal, direccion, medicamentos):
        self.sucursal = sucursal
        self.direccion = direccion
        self.medicamentos = medicamentos  

    def __str__(self):
        return f"Sucursal {self.sucursal}, Dirección: {self.direccion}, Medicamentos: {self.medicamentos}"

def guardar_farmacias(lista, archivo='farmacias.dat'):
    with open(archivo, 'wb') as f:
        pickle.dump(lista, f)

def leer_farmacias(archivo='farmacias.dat'):
    try:
        with open(archivo, 'rb') as f:
            return pickle.load(f)
    except (FileNotFoundError, EOFError):
        return []

def mostrar_medicamentos_tos(sucursal):
    farmacias = leer_farmacias()
    for f in farmacias:
        if f.sucursal == sucursal:
            print(f"Medicamentos para la tos en sucursal {sucursal}:")
            encontrados = False
            for med in f.medicamentos:
                if 'tos' in med.lower():
                    print(med)
                    encontrados = True
            if not encontrados:
                print("No se encontraron medicamentos para la tos en esta sucursal.")
            return
    print(f"No se encontró la sucursal número {sucursal}.")

def mostrar_sucursales_con_golpex():
    farmacias = leer_farmacias()
    encontrados = False
    for f in farmacias:
        if any(med.lower() == 'golpex' for med in f.medicamentos):
            print(f"Sucursal: {f.sucursal}, Dirección: {f.direccion}")
            encontrados = True
    if not encontrados:
        print("No se encontraron sucursales con el medicamento 'Golpex'.")

# Ejemplo de uso:

if __name__ == "__main__":
   
    farmacias = [
        Farmacia(1, "Av. Siempre Viva 123", ["Jarabe para la tos", "Paracetamol", "Golpex"]),
        Farmacia(2, "Calle Falsa 456", ["Ibuprofeno", "Golpex"]),
        Farmacia(3, "Av. Central 789", ["Aspirina", "Jarabe para la tos fuerte"]),
    ]

    guardar_farmacias(farmacias)

   
    print("Farmacias guardadas:")
    for f in leer_farmacias():
        print(f)

    print("\nMedicamentos para la tos en sucursal 1:")
    mostrar_medicamentos_tos(1)

    print("\nSucursales con medicamento Golpex:")
    mostrar_sucursales_con_golpex()
