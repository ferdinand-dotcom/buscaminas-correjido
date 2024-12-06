package main;

import controller.BuscaminasController;
import model.BuscaminasModel;
import model.Jugador;
import view.BuscaminasView;

//Clase Main para la inicializacion de todas las clases
public class Main {
	public static void main(String[] args) {

		// Creacion de instancias de clases para para comenzar el juego
		Jugador jugador = new Jugador("Jugador 1");
		BuscaminasModel modelo = new BuscaminasModel(jugador);
		BuscaminasView vista = new BuscaminasView();
		BuscaminasController controlador = new BuscaminasController(modelo, vista);

		controlador.inicializarControlador();
	}
}
