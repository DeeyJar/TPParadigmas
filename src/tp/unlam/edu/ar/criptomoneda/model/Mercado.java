package tp.unlam.edu.ar.criptomoneda.model;

public class Mercado {
	public static final float PORCENTAJE = 100;
	public static final float AUMENTO = 5;
	private String simbolo;
	private long capacidad;
	private float volumen;
	private float variacion;
	
	public Mercado(String simbolo, long capacidad, float volumen, float variacion) {
		super();
		this.simbolo = simbolo.toUpperCase();
		this.capacidad = capacidad;
		this.volumen = volumen;
		this.variacion = variacion;
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

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public float getVariacion() {
		return variacion;
	}

	public void setVariacion(float variacion) {
		this.variacion = variacion;
	}

	public void setCapacidadCompra(long compra) {
		this.capacidad -= compra;
	}
	
	public void setVolumenCompra() {
		this.volumen += (this.volumen * AUMENTO)/PORCENTAJE;
	}
	
	public void setVariacionCompra() {
		this.variacion += (this.volumen * AUMENTO)/PORCENTAJE;
	}
	
	@Override
	public String toString() {
		return simbolo + ";" + capacidad + ";" + volumen + ";" + variacion;
	}
}
