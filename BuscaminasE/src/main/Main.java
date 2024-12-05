package main;

import controller.BuscaminasController;
import model.BuscaminasModel;
import model.Jugador;
import view.BuscaminasView;

public class Main {
    public static void main(String[] args) {
        
        Jugador jugador = new Jugador("Jugador 1");
        BuscaminasModel modelo = new BuscaminasModel(jugador);
        BuscaminasView vista = new BuscaminasView();
        BuscaminasController controlador = new BuscaminasController(modelo, vista);

        controlador.inicializarControlador();
    }
}
