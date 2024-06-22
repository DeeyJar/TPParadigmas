package tp.unlam.edu.ar.criptomoneda.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Criptomoneda {
	private String nombre;
	private String simbolo;
	private BigDecimal precio;
	
	public Criptomoneda(String nombre,String simbolo, BigDecimal precio){
		this.nombre = nombre;
		this.simbolo = simbolo.toUpperCase();
		this.precio = precio.setScale(2,RoundingMode.HALF_UP);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return nombre + ";" + simbolo + ";" + precio;
	}
	
}
