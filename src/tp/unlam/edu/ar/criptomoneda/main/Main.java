package tp.unlam.edu.ar.criptomoneda.main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.model.Usuario;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioAdministrador;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class Main {

	public static void main(String[] args) {
		
		setEncodingUTF8();
		Usuario usuario = Archivo.obtenerORegistrarUsuario();
		
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

	public static void setEncodingUTF8() {
		try {
            // Configurar la salida estándar de la consola para UTF-8
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("No se puede configurar la codificación UTF-8");
        }
	}
}
