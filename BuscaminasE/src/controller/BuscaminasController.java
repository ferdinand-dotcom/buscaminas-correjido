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

    public BuscaminasController(BuscaminasModel modelo, BuscaminasView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void inicializarControlador() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int fila = i;
                int columna = j;
                vista.setButtonActionListener(fila, columna, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manejarAccion(fila, columna);
                    }
                });
            }
        }
    }

    private void manejarAccion(int fila, int columna) {
        Casilla casilla = modelo.getTablero().getTablero()[fila][columna];
        if (casilla.isDescubierto() || casilla.isMarcado()) {
            return;
        }

        if (casilla.isMina()) {
            vista.actualizarBoton(fila, columna, "*", Color.RED);
            vista.mostrarMensaje("¡Has perdido! Descubriste una mina.");
            mostrarTableroCompleto();
        } else {
            descubrirCasilla(fila, columna);
            if (modelo.verificarVictoria()) {
                vista.mostrarMensaje("¡Has ganado! Descubriste todas las casillas sin minas.");
            }
        }
    }

    private void descubrirCasilla(int fila, int columna) {
        Casilla casilla = modelo.getTablero().getTablero()[fila][columna];
        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10 || casilla.isDescubierto()) {
            return;
        }

        casilla.setDescubierto(true);
        vista.actualizarBoton(fila, columna, casilla.getConteoMinas() == 0 ? " " : String.valueOf(casilla.getConteoMinas()), Color.GRAY);

        if (casilla.getConteoMinas() == 0) {
            for (int filaAdyacente = -1; filaAdyacente <= 1; filaAdyacente++) {
                for (int colAdyacente = -1; colAdyacente <= 1; colAdyacente++) {
                    descubrirCasilla(fila + filaAdyacente, columna + colAdyacente);
                }
            }
        }
    }

    private void mostrarTableroCompleto() {
        Casilla[][] tablero = modelo.getTablero().getTablero();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j].isMina()) {
                    vista.actualizarBoton(i, j, "*", Color.RED);
                } else {
                    vista.actualizarBoton(i, j, tablero[i][j].getConteoMinas() == 0 ? " " : String.valueOf(tablero[i][j].getConteoMinas()), Color.GRAY);
                }
            }
        }
    }
}
