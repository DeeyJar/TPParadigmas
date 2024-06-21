package tp.unlam.edu.ar.criptomoneda.usuario;

public class UsuarioAdministrador extends Usuario {
	
	private String rol;

	public UsuarioAdministrador() {
		super();
	}

	public UsuarioAdministrador(String nombre) {
		super(nombre);
	}
	
	public UsuarioAdministrador(String nombre, String rol) {
		super(nombre);
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
