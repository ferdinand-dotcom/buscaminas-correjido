package model;

import java.util.Random;

public class Tablero {
    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;
    private static final int MINAS = 10;
    private Casilla[][] tablero;

    public Tablero() {
        tablero = new Casilla[FILAS][COLUMNAS];
        inicializarTablero();
        colocarMinas();
        calcularConteoMinas();
    }

    private void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }

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

    private void calcularConteoMinas() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j].isMina()) {
                    for (int filaAdyacente = -1; filaAdyacente <= 1; filaAdyacente++) {
                        for (int colAdyacente = -1; colAdyacente <= 1; colAdyacente++) {
                            if (i + filaAdyacente >= 0 && i + filaAdyacente < FILAS &&
                                    j + colAdyacente >= 0 && j + colAdyacente < COLUMNAS) {
                                tablero[i + filaAdyacente][j + colAdyacente].incrementarConteoMinas();
                            }
                        }
                    }
                }
            }
        }
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

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
