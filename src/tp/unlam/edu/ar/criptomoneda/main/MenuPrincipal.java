package tp.unlam.edu.ar.criptomoneda.main;

import tp.unlam.edu.ar.criptomoneda.manager.CriptomonedaManager;
import tp.unlam.edu.ar.criptomoneda.manager.MercadoManager;
import tp.unlam.edu.ar.criptomoneda.manager.UsuarioTraderManager;
import tp.unlam.edu.ar.criptomoneda.model.Usuario;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioAdministrador;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioTrader;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class MenuPrincipal {

	public static void mostrarMenuPrincipal(Usuario usuario) {
		if(usuario instanceof UsuarioAdministrador) {
			mostrarMenuAdministrador();	
		}else {
			mostrarMenuTrader();
		}
	}
	
	private static void mostrarMenuAdministrador() {
		int choice = 0;
	    do {
	    	mostrarOpcionesAdministrador();
	        choice = obtenerOpcion(6); // son 6 opciones
	        manejarOpcionesAdministrador(choice);
	    } while(choice != 6);
    }
	
	private static void mostrarMenuTrader() {
		int choice = 0;
	    do {
	    	mostrarOpcionesTrader();
	        choice = obtenerOpcion(7); // son 7 opciones
	        manejarOpcionesTrader(choice);
	    } while(choice != 7);
    }
	
	protected static int obtenerOpcion(int max) {
        int choice = -1;
        while (choice < 0 || choice > max) {
            choice = InputHelper.getInt("Ingrese su opcion (1 - " + max + "): ");
        }
        return choice;
    }
    
    private static void mostrarOpcionesAdministrador() {
    	System.out.println("Menu de opciones Administrador");
		System.out.println("------------------------------");
		System.out.println("1) Crear Criptomonedas");
		System.out.println("2) Modificar Criptomonedas");
		System.out.println("3) Eliminar Criptomoneda");
		System.out.println("4) Consultar Criptomoneda");
		System.out.println("5) Consultar estado actual del mercado");
		System.out.println("6) Salir");
    }
    
    private static void mostrarOpcionesTrader() {
    	System.out.println("Menu de opciones Usuario");
		System.out.println("------------------------");
		System.out.println("1) Comprar Criptomonedas");
		System.out.println("2) Vender Criptomonedas");
		System.out.println("3) Consultar Criptomoneda");
		System.out.println("4) Recomendar Criptomoneda");
		System.out.println("5) Consultar estado actual del mercado");
		System.out.println("6) Visualizar archivo de transacciones (histórico)");
		System.out.println("7) Salir");
    }

    private static void manejarOpcionesAdministrador(int opcion) {
        switch (opcion) {
	        case 1:
				CriptomonedaManager.crearCriptomoneda();
				break;
			case 2:
				CriptomonedaManager.modificarCriptomoneda();
				break;
			case 3:
				CriptomonedaManager.eliminarCriptomoneda();
				break;
			case 4:
				CriptomonedaManager.consultarCriptomoneda();
				break;
			case 5:
				MercadoManager.consultarEstadoDelMercado();
				break;
            case 6: break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void manejarOpcionesTrader(int opcion) {
        switch (opcion) {
	        case 1:
				UsuarioTraderManager.comprarCriptomoneda();
				break;
	        case 2:
	        	UsuarioTraderManager.ventaCriptomoneda();
				break;
			case 3:
				CriptomonedaManager.consultarCriptomoneda();
				break;
			case 5:
				MercadoManager.consultarEstadoDelMercado();
				break;
            case 7: break;
            default:
                System.out.println("Opción no válida\n");
        }
    }
}
