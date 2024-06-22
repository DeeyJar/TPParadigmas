package tp.unlam.edu.ar.criptomoneda.model;

public class Usuario {
	
    private String nombre;
    
    protected Usuario() {
    }
    
    protected Usuario(String nombre) {
    	this.nombre = nombre;
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
