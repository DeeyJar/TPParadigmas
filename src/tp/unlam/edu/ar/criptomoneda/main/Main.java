package tp.unlam.edu.ar.criptomoneda.main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.Mercado;
import tp.unlam.edu.ar.criptomoneda.usuario.Usuario;
import tp.unlam.edu.ar.criptomoneda.usuario.UsuarioAdministrador;
import tp.unlam.edu.ar.criptomoneda.utilidades.Archivo;
import tp.unlam.edu.ar.criptomoneda.utilidades.InputHelper;
import tp.unlam.edu.ar.criptomoneda.utilidades.Menu;

public class Main {

	public static void main(String[] args) {
		
		setUTF8();
		Usuario usuario = Archivo.archivoUsuario();
		
		List<Criptomoneda> cripto =  Archivo.criptomonedaArchivo("./files/criptomonedas.csv");
		List<Mercado> merca = Archivo.estadoDelMercado("./files/mercados.csv");
		
		System.out.println("Bienvenido " + usuario.getNombre());
		if(usuario instanceof UsuarioAdministrador) {
			Menu.menuAdministrador(cripto,merca);
		}else {
			Menu.menuUsuario(cripto,merca);
		}
		
		InputHelper.close();
		System.out.println("\n--------- Fin del programa ----------");
	}

	public static void setUTF8() {
		try {
            // Configurar la salida estándar de la consola para UTF-8
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("No se puede configurar la codificación UTF-8");
        }
	}
}
