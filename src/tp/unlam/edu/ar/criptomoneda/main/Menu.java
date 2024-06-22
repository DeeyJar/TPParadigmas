package tp.unlam.edu.ar.criptomoneda.main;

import java.math.BigDecimal;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class Menu {
	
	private Menu() {}
	
	public static void menuAdministrador(List<Criptomoneda> cripto, List<Mercado> mercado) {

		int menuAdmin;
		
		do {
			System.out.println("Menu de opciones Administrador");
			System.out.println("----------------");
			System.out.println("1) Crear Criptomonedas");
			System.out.println("2) Modificar Criptomonedas");
			System.out.println("3) Eliminar Criptomoneda");
			System.out.println("4) Consultar Criptomoneda");
			System.out.println("5) Consultar estado actual del mercado");
			System.out.println("6) Salir");
			menuAdmin = InputHelper.getInt("Ingrese su opcion (1 - 6): ");
			
			switch(menuAdmin) {
				case 1:
					crearCriptomoneda(cripto,mercado);
					// TODO crear mercado junto a la criptomoneda
					break;
				case 2:
					modificarCriptomoneda(cripto,mercado);
					// TODO modificar simbolo de mercado si modifica el simbolo
					break;
				case 3:
					eliminarCriptomoneda(cripto);
					break;
				case 4:
					consultarCriptomoneda(cripto);
					break;
				case 5:
					consultarEstadoDelMercado(cripto,mercado);
					break;
				case 6: break;
				default: 
					System.out.print("\nOpción incorrecta.");
					break;
			}
		}while(menuAdmin != 6);
	}
	
	public static void menuUsuario(List<Criptomoneda> cripto, List<Mercado> mercado) {

		int menuUsuario;
		
		do {
			System.out.println("Menu de opciones Usuario");
			System.out.println("----------------");
			System.out.println("1) Comprar Criptomonedas");
			System.out.println("2) Vender Criptomonedas");
			System.out.println("3) Consultar Criptomoneda");
			System.out.println("4) Recomendar Criptomoneda");
			System.out.println("5) Consultar estado actual del mercado");
			System.out.println("6) Visualizar archivo de transacciones (histórico)");
			System.out.println("7) Salir");
			menuUsuario = InputHelper.getInt("Ingrese su opcion (1 - 7): ");
			
			switch(menuUsuario) {
			case 1:
				System.out.println("Hola");
				break;
			case 3:
				consultarCriptomoneda(cripto);
				break;
			case 5:
				consultarEstadoDelMercado(cripto,mercado);
				break;
			case 7: break;
			default: 
				System.out.print("\nOpción incorrecta. Ingrese su opcion (1 - 6): ");
				break;
		}
			
		}while(menuUsuario != 7);
	}
	
	private static void crearCriptomoneda(List<Criptomoneda> listCripto, List<Mercado> mercado) {
//		System.out.println("---- Crear Criptomoneda ----");
//		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
//		
//		Criptomoneda encontrada =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
//		if(encontrada == null) {
//			String simboloCripto = InputHelper.getString("Ingrese el simbolo del criptomoneda: ");
//			
//			Criptomoneda simboloLista =  Criptomoneda.simboloExiste(listCripto,nombreCripto);
//			
//			if(simboloLista == null) {
//				BigDecimal precio = InputHelper.getBigDecimal("Ingrese el precio inicial: ");
//				Criptomoneda nuevaCripto = new Criptomoneda(nombreCripto,simboloCripto,precio);
//				listCripto.add(nuevaCripto);
//				Mercado.agregarCriptoEnMercado(nuevaCripto, mercado);
//				InputHelper.pauseSystem();
//			}else {
//				System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ simboloLista.getNombre() + "?");
//				System.out.print("Si (S) o No (N): ");
//				//llamar submenuModificarCripto (encontrada)
//			}
//		}else {
//			System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ encontrada.getNombre() + "?");
//			System.out.print("Si (S) o No (N): ");
//			// TODO retomar cuando creemos metodo de modificar cripto
//			//llamar submenuModificarCripto (encontrada)
//		}
	}
	
	private static void modificarCriptomoneda(List<Criptomoneda> listCripto,List<Mercado> listMercado) {
		
	}
	
	private static void eliminarCriptomoneda(List<Criptomoneda> listCripto) {
	}
	
	private static void consultarCriptomoneda(List<Criptomoneda> listCripto) {
		
//		System.out.println("---- Consultar Criptomoneda ----");
//		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
//		
//		Criptomoneda encontrada =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
//		
//		if(encontrada != null) {
//			encontrada.mostrarDatos();
//			InputHelper.pauseSystem();
//		}
//		else {
//			System.out.println("No se encontró la criptomoneda.");
//		}
		
	}
	
	private static void consultarEstadoDelMercado(List<Criptomoneda> listCripto,List<Mercado> listMercado) {
		
//		System.out.println("---- Consultar estado actual del mercado ----");
//		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
//		
//		Criptomoneda cripto =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
//		
//		assert cripto != null : "No existe esa cripto rey";
//		
//		Mercado mercado = Mercado.getMercado(listMercado,cripto.getSimbolo());
//		
//		if(mercado != null) {
//			mercado.mostrarDatos();
//			InputHelper.pauseSystem();
//		}
//		else {
//			System.out.println("No se encontró la criptomoneda.");
//		}
	}
}
