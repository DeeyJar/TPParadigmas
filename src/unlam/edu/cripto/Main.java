package unlam.edu.cripto;

import java.util.List;

public class Main {

	public static void main(String[] args) {		
		Usuario usuario = Archivo.archivoUsuario();
		
		List<Criptomoneda> cripto =  Archivo.criptomonedaArchivo("./files/criptomonedas.csv");
		List<Mercado> merca = Archivo.estadoDelMercado("./files/mercados.csv");
		
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
