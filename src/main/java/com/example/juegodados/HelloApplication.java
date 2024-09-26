package com.example.juegodados;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

/**
 * Clase principal del juego de dados.
 */
public class HelloApplication extends Application {

    private Jugador jugador;
    private Enemigo enemigo;
    private Label etiquetaVidaJugador;
    private Label etiquetaVidaEnemigo;

    @Override
    public void start(Stage escenarioPrincipal) {
        jugador = new Jugador("Jugador", 5);
        enemigo = new Enemigo("Enemigo", 5);

        Button botonTirarDado = new Button("Tirar Dado");
        botonTirarDado.setOnAction(e -> tirarDado());

        etiquetaVidaJugador = new Label("Vida del Jugador: " + jugador.getVida());
        etiquetaVidaEnemigo = new Label("Vida del Enemigo: " + enemigo.getVida());

        VBox disposicion = new VBox(10, etiquetaVidaJugador, etiquetaVidaEnemigo, botonTirarDado);
        Scene escena = new Scene(disposicion, 300, 200);
        escenarioPrincipal.setTitle("Juego de Dados");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    /**
     * Lógica para tirar el dado.
     */
    private void tirarDado() {
        Random aleatorio = new Random();
        int tiradaJugador = aleatorio.nextInt(6) + 1;
        int tiradaEnemigo = aleatorio.nextInt(6) + 1;

        if (tiradaJugador > tiradaEnemigo) {
            enemigo.reducirVida(1);
        } else if (tiradaEnemigo > tiradaJugador) {
            jugador.reducirVida(1);
        }

        etiquetaVidaJugador.setText("Vida del Jugador: " + jugador.getVida());
        etiquetaVidaEnemigo.setText("Vida del Enemigo: " + enemigo.getVida());

        verificarFinDelJuego();
    }

    /**
     * Verifica si el juego ha terminado.
     */
    private void verificarFinDelJuego() {
        if (jugador.getVida() <= 0 || enemigo.getVida() <= 0) {
            String ganador = jugador.getVida() <= 0 ? "El Enemigo ha ganado!" : "El Jugador ha ganado!";
            etiquetaVidaJugador.setText(ganador);
            etiquetaVidaEnemigo.setText("");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
