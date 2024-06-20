package unlam.edu.cripto;

import java.util.List;

public class Main {

	public static void main(String[] args) {		
		Archivo archivo = new Archivo();
		Usuario usuario = archivo.archivoUsuario();
		
		List<Criptomoneda> cripto =  archivo.criptomonedaArchivo("./criptomonedas.csv");
		List<Mercado> merca = archivo.estadoDelMercado("./mercados.csv");
		
		if(usuario != null) {
			System.out.println("Bienvenido " + usuario.getNombre());
			if(usuario.getRol() != null) {
				Menu.MenuAdministrador(cripto,merca);
			}else {
				Menu.MenuUsuario(cripto,merca);
			}
		}else {
			System.out.println("Usuario no encontrado. Adios.");
		}
		
		System.out.println("\n--------- Fin del programa ----------");
	}

}
