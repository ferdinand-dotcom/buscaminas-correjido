package model;

import java.util.Random;

public class Tablero {
	private static final int FILAS = 10;
	private static final int COLUMNAS = 10;
	private static final int MINAS = 10;
	private Casilla[][] tablero;

	// Constructor que inicializa el tablero y coloca las minas
	public Tablero() {
		tablero = new Casilla[FILAS][COLUMNAS];
		inicializarTablero();
		colocarMinas();
		calcularConteoMinas();
	}

	// Método para inicializar el tablero con casillas vacías
	private void inicializarTablero() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				tablero[i][j] = new Casilla();
			}
		}
	}

	// Método para colocar minas aleatoriamente en el tablero
	private void colocarMinas() {
		Random rand = new Random();
		int minasColocadas = 0;

		while (minasColocadas < MINAS) {
			int fila = rand.nextInt(FILAS);
			int columna = rand.nextInt(COLUMNAS);

			if (!tablero[fila][columna].isMina()) {
				tablero[fila][columna].setMina(true);
				minasColocadas++;
			}
		}
	}

	// Método para calcular el número de minas adyacentes a cada casilla
	private void calcularConteoMinas() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (tablero[i][j].isMina()) {
					for (int filaAdyacente = -1; filaAdyacente <= 1; filaAdyacente++) {
						for (int colAdyacente = -1; colAdyacente <= 1; colAdyacente++) {
							if (i + filaAdyacente >= 0 && i + filaAdyacente < FILAS && j + colAdyacente >= 0
									&& j + colAdyacente < COLUMNAS) {
								tablero[i + filaAdyacente][j + colAdyacente].incrementarConteoMinas();
							}
						}
					}
				}
			}
		}
	}

	// Método para obtener el tablero de casillas
	public Casilla[][] getTablero() {
		return tablero;
	}

	// Método para verificar si el jugador ha ganado el juego
	public boolean verificarVictoria() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (!tablero[i][j].isMina() && !tablero[i][j].isDescubierto()) {
					return false;
				}
			}
		}
		return true;
	}
}
