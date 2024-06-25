package tp.unlam.edu.ar.criptomoneda.main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.model.Usuario;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioAdministrador;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioTrader;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class Main {

	public static void main(String[] args) {
		
		Archivo archivo = Archivo.getInstancia();
		Usuario usuario = null;
		setEncodingUTF8();
		
		archivo.obtenerORegistrarUsuario();
		archivo.obtenerListaCriptomonedasDeArchivo();
		archivo.obtenerListaMercadosDeArchivo();
		
		usuario = archivo.getUsuario();
		
		if(usuario instanceof UsuarioTrader) {
			archivo.obtenerListaHistoricoDeArchivo();
		}
		
		System.out.println("Bienvenido " + usuario.getNombre());
		MenuPrincipal.mostrarMenuPrincipal(usuario);
		
		archivo.guardarCambiosMercado();
		
		if(usuario instanceof UsuarioAdministrador) {
			archivo.guardarCambiosCriptomoneda();	
		}else {
			archivo.guardarCambiosArchivoUsuario();
			archivo.guardarCambiosHistoricoArchivo();
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
