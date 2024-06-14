package unlam.edu.cripto;

import java.math.BigDecimal;

public class Criptomoneda {
	private String nombre;
	private String simbolo;
	private BigDecimal precio;
	
	public Criptomoneda(String nombre,String simbolo, BigDecimal precio){
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precio = precio;
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
}
