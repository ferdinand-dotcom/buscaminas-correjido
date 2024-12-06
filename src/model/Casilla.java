package model;

public class Casilla {
	private boolean mina;
	private int conteoMinas;
	private boolean descubierto;
	private boolean marcado;

	// Constructor que inicializa una casilla sin mina, sin minas adyacentes, no
	// descubierta y no marcada
	public Casilla() {
		this.mina = false;
		this.conteoMinas = 0;
		this.descubierto = false;
		this.marcado = false;
	}

	// Método para verificar si la casilla contiene una mina
	public boolean isMina() {
		return mina;
	}

	// Método para establecer si la casilla contiene una mina
	public void setMina(boolean mina) {
		this.mina = mina;
	}

	// Método para obtener el número de minas adyacentes a la casilla
	public int getConteoMinas() {
		return conteoMinas;
	}

	// Método para incrementar el conteo de minas adyacentes
	public void incrementarConteoMinas() {
		this.conteoMinas++;
	}

	// Método para verificar si la casilla ha sido descubierta
	public boolean isDescubierto() {
		return descubierto;
	}

	// Método para establecer si la casilla ha sido descubierta
	public void setDescubierto(boolean descubierto) {
		this.descubierto = descubierto;
	}

	// Método para verificar si la casilla ha sido marcada
	public boolean isMarcado() {
		return marcado;
	}

	// Método para establecer si la casilla ha sido marcada
	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}
}