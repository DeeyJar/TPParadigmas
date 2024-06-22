package tp.unlam.edu.ar.criptomoneda.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Mercado {

	private String simbolo;
	private BigDecimal capacidad;
	private BigDecimal volumen;
	private BigDecimal variacion;
	
	public Mercado(String simbolo, BigDecimal capacidad, BigDecimal volumen, BigDecimal variacion) {
		super();
		this.simbolo = simbolo.toUpperCase();
		this.capacidad = capacidad.setScale(2,RoundingMode.HALF_UP);
		this.volumen = volumen.setScale(2,RoundingMode.HALF_UP);
		this.variacion = variacion.setScale(2,RoundingMode.HALF_UP);
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

	@Override
	public String toString() {
		return simbolo + ";" + capacidad + ";" + volumen + ";" + variacion;
	}
}
