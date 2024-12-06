package controller;

import model.BuscaminasModel;
import model.Casilla;
import view.BuscaminasView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscaminasController {
	private BuscaminasModel modelo;
	private BuscaminasView vista;

	// Constructor del controlador que recibe el modelo y la vista
	public BuscaminasController(BuscaminasModel modelo, BuscaminasView vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	// Método para inicializar el controlador y establecer los ActionListeners para
	// los botones
	public void inicializarControlador() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int fila = i;
				int columna = j;

				// Establecer ActionListener para cada botón en la vista
				vista.setButtonActionListener(fila, columna, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						manejarAccion(fila, columna);
					}
				});
			}
		}
	}

	// Método para manejar la acción cuando se hace clic en una casilla
	private void manejarAccion(int fila, int columna) {
		Casilla casilla = modelo.getTablero().getTablero()[fila][columna];

		// Verificar si la casilla ya está descubierta o marcada
		if (casilla.isDescubierto() || casilla.isMarcado()) {
			return;
		}

		// Si la casilla contiene una mina, actualizar la vista y mostrar mensaje de
		// derrota
		if (casilla.isMina()) {
			vista.actualizarBoton(fila, columna, "*", Color.RED);
			vista.mostrarMensaje("¡Has perdido! Descubriste una mina.");
			mostrarTableroCompleto();
		} else {

			// Si la casilla no contiene una mina, descubrir la casilla y verificar victoria
			descubrirCasilla(fila, columna);
			if (modelo.verificarVictoria()) {
				vista.mostrarMensaje("¡Has ganado! Descubriste todas las casillas sin minas.");
			}
		}
	}

	// Método para descubrir una casilla y actualizar la vista
	private void descubrirCasilla(int fila, int columna) {
		Casilla casilla = modelo.getTablero().getTablero()[fila][columna];

		// Verificar límites del tablero y si la casilla ya está descubierta
		if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10 || casilla.isDescubierto()) {
			return;
		}

		// Marcar la casilla como descubierta y actualizar el botón en la vista
		casilla.setDescubierto(true);
		vista.actualizarBoton(fila, columna,
				casilla.getConteoMinas() == 0 ? " " : String.valueOf(casilla.getConteoMinas()), Color.GRAY);

		// Si la casilla no tiene minas adyacentes, descubrir casillas adyacentes
		// recursivamente
		if (casilla.getConteoMinas() == 0) {
			for (int filaAdyacente = -1; filaAdyacente <= 1; filaAdyacente++) {
				for (int colAdyacente = -1; colAdyacente <= 1; colAdyacente++) {
					descubrirCasilla(fila + filaAdyacente, columna + colAdyacente);
				}
			}
		}
	}

	// Método para mostrar todo el tablero al finalizar el juego
	private void mostrarTableroCompleto() {
		Casilla[][] tablero = modelo.getTablero().getTablero();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				// Actualizar la vista para mostrar todas las minas y conteos de minas
				if (tablero[i][j].isMina()) {
					vista.actualizarBoton(i, j, "*", Color.RED);
				} else {
					vista.actualizarBoton(i, j,
							tablero[i][j].getConteoMinas() == 0 ? " " : String.valueOf(tablero[i][j].getConteoMinas()),
							Color.GRAY);
				}
			}
		}
	}
}
