package model;

public class BuscaminasModel {
    private Tablero tablero;
    private Jugador jugador;

    public BuscaminasModel(Jugador jugador) {
        this.tablero = new Tablero();
        this.jugador = jugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public boolean verificarVictoria() {
        return tablero.verificarVictoria();
    }
}
