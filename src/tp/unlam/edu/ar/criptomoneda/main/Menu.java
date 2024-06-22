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
					crearCriptomoneda(cripto);
					// TODO crear mercado junto a la criptomoneda
					break;
				case 2:
					modificarCriptomoneda(cripto);
					// TODO modificar simbolo de mercado si modifica el simbolo
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
		
		Archivo.modificarCriptomonedaArchivo(cripto);
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
	
	private static void crearCriptomoneda(List<Criptomoneda> listCripto) {
		System.out.println("---- Crear Criptomoneda ----");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
		
		Criptomoneda encontrada =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
		if(encontrada == null) {
			String simboloCripto = InputHelper.getString("Ingrese el simbolo del criptomoneda: ");
			
			Criptomoneda simboloLista =  Criptomoneda.simboloExiste(listCripto,nombreCripto);
			
			if(simboloLista == null) {
				BigDecimal precio = InputHelper.getBigDecimal("Ingrese el precio inicial: ");
				Criptomoneda nuevaCripto = new Criptomoneda(nombreCripto,simboloCripto,precio);
				listCripto.add(nuevaCripto);
			}else {
				System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ simboloLista.getNombre() + "?");
				System.out.print("Si (S) o No (N): ");
//				String modificarCripto = InputHelper.getString(); 
			}
		}else {
			System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ encontrada.getNombre() + "?");
			System.out.print("Si (S) o No (N): ");
//			String modificarCripto = InputHelper.getString(); 
			// TODO retomar cuando creemos metodo de modificar cripto
		}
	}
	
	private static void modificarCriptomoneda(List<Criptomoneda> listCripto) {
		System.out.println("--------- Crear Criptomoneda ---------");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda a modificar: ");
		int opcion;
		
		Criptomoneda encontrada =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
		
		if(encontrada != null) {
			
			do {
				System.out.println("Que datos de la criptomoneda quiere modificar?");
				System.out.println("-----------------------------------------------");
				System.out.println("1) Modificar nombre");
				System.out.println("2) Modificar símbolo");
				System.out.println("3) Modificar precio dolar base");
				System.out.println("4) Volver al menu anterior");
				opcion = InputHelper.getInt("Ingrese su opcion (1 - 4): ");
				
				switch(opcion) {
					case 1: 
						String nombreModificado = InputHelper.getString("Ingrese el nuevo nombre: ");
						
						encontrada.setNombre(nombreModificado);
						break;
					case 2:
						String simboloModificado = InputHelper.getString("Ingrese el nuevo símbolo: ");
						
						// TODO agregar logica de merca
						encontrada.setSimbolo(simboloModificado);
						break;
					case 3:
						BigDecimal nuevoPrecio = InputHelper.getBigDecimal("Ingrese el nuevo precio de dolar base: ");
						
						encontrada.setPrecio(nuevoPrecio);
						break;
					case 4: break;
					default: 
						System.out.print("\nOpción incorrecta.");
						break;
				}
				
			} while (opcion != 4);

		} else {
			System.out.print("La criptomoneda "+ nombreCripto + " no existe.");
		}
	}
	
	private static void consultarCriptomoneda(List<Criptomoneda> listCripto) {
		
		System.out.println("---- Consultar Criptomoneda ----");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
		
		Criptomoneda encontrada =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
		
		if(encontrada != null) {
			encontrada.mostrarDatos();
			System.out.println("\n-----------------\n");
			InputHelper.getString("Presiona Enter para continuar...\n");
		}
		else {
			System.out.println("No se encontró la criptomoneda.");
		}
		
	}
	
	private static void consultarEstadoDelMercado(List<Criptomoneda> listCripto,List<Mercado> listMercado) {
		
		System.out.println("---- Consultar estado actual del mercado ----");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
		
		Criptomoneda cripto =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
		
		assert cripto != null : "No existe esa cripto rey";
		
		Mercado mercado = Mercado.getMercado(listMercado,cripto.getSimbolo());
		
		if(mercado != null) {
			mercado.mostrarDatos();
			System.out.println("\n------------------------------\n");
			InputHelper.getString("Presiona Enter para continuar...\n");
		}
		else {
			System.out.println("No se encontró la criptomoneda.");
		}
	}
}
