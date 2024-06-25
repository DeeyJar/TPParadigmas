package tp.unlam.edu.ar.criptomoneda.model;

public class Historico {
	private String simbolo;
	private long capacidad;
	
	public Historico(String simbolo,long capacidad) {
		this.simbolo = simbolo;
		this.capacidad = capacidad;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public long getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}
	
	public void setActualizarCapacidadCompra(long capacidad) {
		this.capacidad+=capacidad;
	}
	
	@Override
	public String toString() {
		return this.simbolo + ";" + this.capacidad;
	}
}
