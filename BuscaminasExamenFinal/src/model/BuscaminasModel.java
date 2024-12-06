package model;

//Clase que representa el modelo del juego Buscaminas
public class BuscaminasModel {
	private Tablero tablero;
	private Jugador jugador;

	// Constructor que inicializa el modelo con un jugador y un nuevo tablero
	public BuscaminasModel(Jugador jugador) {
		this.tablero = new Tablero();
		this.jugador = jugador;
	}

	// Métodos para obtener Tablero y Jugador
	public Tablero getTablero() {
		return tablero;
	}

	public Jugador getJugador() {
		return jugador;
	}

	// Método para verificar si el jugador ha ganado el juego
	public boolean verificarVictoria() {
		return tablero.verificarVictoria();
	}
}
