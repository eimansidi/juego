package com.example.juegodados;

/**
 * Clase que representa al jugador.
 */
public class Jugador {
    private String nombre;
    private int vida;

    public Jugador(String nombre, int vida) {
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
