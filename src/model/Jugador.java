package model;

public class Jugador {
	private String nombre;
	private int puntuacion;

	// Constructor que inicializa el nombre del jugador y establece la puntuación
	// inicial a 0
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	// Método para obtener el nombre del jugador
	public String getNombre() {
		return nombre;
	}

	// Método para obtener la puntuación del jugador
	public int getPuntuacion() {
		return puntuacion;
	}

	// Método para incrementar la puntuación del jugador
	public void incrementarPuntuacion() {
		this.puntuacion++;
	}
}
