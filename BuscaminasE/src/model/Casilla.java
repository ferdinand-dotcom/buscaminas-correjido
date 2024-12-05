package model; 

public class Casilla { 
	private boolean mina; 
	private int conteoMinas; 
	private boolean descubierto; 
	private boolean marcado; 
	
	public Casilla() { 
		this.mina = false; 
		this.conteoMinas = 0; 
		this.descubierto = false; 
		this.marcado = false; 
	} 
	
	public boolean isMina() { 
		return mina; 
	}
	
	public void setMina(boolean mina) { 
		this.mina = mina; 
	} 
	
	public int getConteoMinas() { 
		return conteoMinas; 
	}
	
	public void incrementarConteoMinas() { 
		this.conteoMinas++; 
	} 
	
	public boolean isDescubierto() { 
		return descubierto; 
	} 
	
	public void setDescubierto(boolean descubierto) { 
		this.descubierto = descubierto; 
	} 
	
	public boolean isMarcado() { 
		return marcado; 
	} 
	
	public void setMarcado(boolean marcado) { 
		this.marcado = marcado; 
	} 
}