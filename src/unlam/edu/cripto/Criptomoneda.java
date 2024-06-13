package unlam.edu.cripto;

public class Criptomoneda {
	private String nombre;
	private String alias;
	private int precio;
	
	private int capacidad;
	private int volumen;
	private int variacion;
	
	public Criptomoneda(String nombre,String alias, int precio){
		this.nombre = nombre;
		this.alias = alias;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getVolumen() {
		return volumen;
	}
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	public int getVariacion() {
		return variacion;
	}
	public void setVariacion(int variacion) {
		this.variacion = variacion;
	}
}
