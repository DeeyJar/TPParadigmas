package tp.unlam.edu.ar.criptomoneda.main;

import tp.unlam.edu.ar.criptomoneda.manager.CriptomonedaManager;
import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class SubmenuModificarCriptomoneda {
	public static final int OPCIONES_MENU = 4;
	
	public static void mostrar() {
		System.out.println("--------- Modificar Criptomoneda ---------");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda a modificar: ");
		
		Criptomoneda encontrada = CriptomonedaManager.buscarCriptomonedaPorNombre(nombreCripto);
		if(encontrada != null) {
			subMenuModificar(encontrada);
		}else {
			 System.out.println("No existe la nombre de la criptomoneda.");
		}
    }
	
	public static void subMenuModificar(Criptomoneda encontrada) {
		int opcion;
		do {
	    	mostrarOpciones();
	    	opcion = MenuPrincipal.obtenerOpcion(OPCIONES_MENU);
	        manejarOpciones(opcion,encontrada);
	        InputHelper.pauseSystem();
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

    private static boolean manejarOpciones(int choice,Criptomoneda criptomoneda) {
        switch (choice) {
            case 1:
                CriptomonedaManager.modificarNombreCriptomoneda(criptomoneda);
                return false;
            case 2:
                CriptomonedaManager.modificarSimboloCriptomoneda(criptomoneda);
                return false;
            case 3:
            	 CriptomonedaManager.modificarPrecioCriptomoneda(criptomoneda);
                return false;
            case 4:
                return true; // Volver al menú principal
            default:
                System.out.println("Opción no válida");
                return false;
        }
    }
    
    public static void mostrarSubMenuCriptoExistente(String mensaje,Criptomoneda criptomoneda) {
    	int modificarNombre = InputHelper.getInt(mensaje);
    	
    	switch(modificarNombre) {
    	case 1:
    		subMenuModificar(criptomoneda);
    		break;
    	case 2:
    		break;
    	default:
            System.out.println("Opción no válida");
    	}
    }
}
