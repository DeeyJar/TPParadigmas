package unlam.edu.cripto;

public class Main {

	public static void main(String[] args) {		
		Archivo usuarioArchivo = new Archivo();
		Usuario usuario = usuarioArchivo.archivoUsuario();

		if(usuario != null) {
			System.out.println("Bienvenido " + usuario.getNombre());
			if(usuario.getRol() != null) {
				Menu.MenuAdministrador();
			}else {
				Menu.MenuUsuario();
			}
		}else {
			System.out.println("Usuario no encontrado. Adios.");
		}
	}

}
