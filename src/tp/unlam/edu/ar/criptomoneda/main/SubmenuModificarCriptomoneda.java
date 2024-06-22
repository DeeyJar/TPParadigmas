package tp.unlam.edu.ar.criptomoneda.main;

import tp.unlam.edu.ar.criptomoneda.manager.CriptomonedaManager;
import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class SubmenuModificarCriptomoneda {
	
	public static void mostrar() {
		System.out.println("--------- Modificar Criptomoneda ---------");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda a modificar: ");
		int opcion;
		
		Criptomoneda encontrada = CriptomonedaManager.buscarCriptomonedaPorNombre(nombreCripto);
		
	    do {
	    	mostrarOpciones();
	    	opcion = MenuPrincipal.obtenerOpcion(4); // son 4 opciones
	        manejarOpciones(opcion);
	    } while(opcion != 4);
    }

    private static void mostrarOpciones() {
        System.out.println("¿Que datos de la criptomoneda quiere modificar?");
		System.out.println("-----------------------------------------------");
		System.out.println("1) Modificar nombre");
		System.out.println("2) Modificar símbolo");
		System.out.println("3) Modificar precio dolar base");
		System.out.println("4) Volver al menu anterior");
    }

    private static boolean manejarOpciones(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Has seleccionado Sub-opción 1.1");
                // Lógica específica para Sub-opción 1.1
                return false;
            case 2:
                System.out.println("Has seleccionado Sub-opción 1.2");
                // Lógica específica para Sub-opción 1.2
                return false;
            case 3:
                return true; // Volver al menú principal
            default:
                System.out.println("Opción no válida");
                return false;
        }
    }
}
