package tp.unlam.edu.ar.criptomoneda.main;

import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class MenuPrincipal {

	public static void mostrarMenuAdministrador() {
		int choice = 0;
	    do {
	    	mostrarOpcionesAdministrador();
	        choice = obtenerOpcion(6); // son 6 opciones
	        manejarEntradaDeUsuarioAdministrador(choice);
	    } while(choice != 6);
    }
	
	public static void mostrarMenuTrader() {
		int choice = 0;
	    do {
	    	mostrarOpcionesTrader();
	        choice = obtenerOpcion(7); // son 7 opciones
	        manejarEntradaDeUsuarioTrader(choice);
	    } while(choice != 7);
    }
	
	private static int obtenerOpcion(int max) {
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

    private static void manejarEntradaDeUsuarioAdministrador(int opcion) {
        switch (opcion) {
            case 1:
//                SubMenu1 menu1 = new SubMenu1();
//                menu1.display();
                break;
            case 2:
//                SubMenu2 menu2 = new SubMenu2();
//                menu2.display();
                break;
            case 7: break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void manejarEntradaDeUsuarioTrader(int opcion) {
        switch (opcion) {
            case 1:
//                SubMenu1 menu1 = new SubMenu1();
//                menu1.display();
                break;
            case 2:
//                SubMenu2 menu2 = new SubMenu2();
//                menu2.display();
                break;
            case 7: break;
            default:
                System.out.println("Opción no válida\n");
        }
    }
}
