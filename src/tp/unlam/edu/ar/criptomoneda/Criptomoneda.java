package tp.unlam.edu.ar.criptomoneda;

import java.math.BigDecimal;
import java.util.List;

public class Criptomoneda {
	private String nombre;
	private String simbolo;
	private BigDecimal precio;
	
	public static final String FORMAT = "%-20s%-20s%s";
	
	public Criptomoneda(String nombre,String simbolo, BigDecimal precio){
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precio = precio;
	}
	
	public static Criptomoneda getCriptomoneda(List<Criptomoneda> cripto, String nombreCripto) {
		Criptomoneda encontrada = null;
		for(Criptomoneda c : cripto) {
			if(nombreCripto.equalsIgnoreCase(c.nombre)) {
				encontrada = c;
				break;
			}
		}
		
		return encontrada;
	}
	
	public static Criptomoneda simboloExiste(List<Criptomoneda> cripto, String simbolo) {
		Criptomoneda encontrada = null;
		for(Criptomoneda c : cripto) {
			if(simbolo.equalsIgnoreCase(c.simbolo)) {
				encontrada = c;
				break;
			}
		}
		
		return encontrada;
	}
	
	public void mostrarDatos() {
		System.out.printf(FORMAT, "Nombre:" + this.getNombre()
								, "Alias:" + this.getSimbolo()
								, "Precio:" + this.getPrecio());
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
