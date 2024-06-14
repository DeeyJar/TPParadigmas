package unlam.edu.cripto;

import java.math.BigDecimal;

public class Mercado {

	private String simbolo;
	private BigDecimal capacidad;
	private BigDecimal volumen;
	private BigDecimal variacion;
	
	public Mercado(String simbolo, BigDecimal capacidad, BigDecimal volumen, BigDecimal variacion) {
		super();
		this.simbolo = simbolo;
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

	public BigDecimal getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(BigDecimal capacidad) {
		this.capacidad = capacidad;
	}

	public BigDecimal getVolumen() {
		return volumen;
	}

	public void setVolumen(BigDecimal volumen) {
		this.volumen = volumen;
	}

	public BigDecimal getVariacion() {
		return variacion;
	}

	public void setVariacion(BigDecimal variacion) {
		this.variacion = variacion;
	}
}
