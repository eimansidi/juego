package com.example.juegodados;

/**
 * Clase que representa al enemigo.
 */
public class Enemigo {
    private String nombre;
    private int vida;

    public Enemigo(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void reducirVida(int cantidad) {
        vida -= cantidad;
    }
}
