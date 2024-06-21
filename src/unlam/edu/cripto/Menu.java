package unlam.edu.cripto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Menu {
	public static void MenuAdministrador(List<Criptomoneda> cripto, List<Mercado> mercado) {
		Scanner myObj = new Scanner(System.in);
		int menuAdmin;
		String nombreCripto;
		
		do {
			System.out.println("Menu de opciones Administrador");
			System.out.println("----------------");
			System.out.println("1) Crear Criptomonedas");
			System.out.println("2) Modificar Criptomonedas");
			System.out.println("3) Eliminar Criptomoneda");
			System.out.println("4) Consultar Criptomoneda");
			System.out.println("5) Consultar estado actual del mercado");
			System.out.println("6) Salir");
			
			System.out.print("Ingrese su opcion (1 - 6): ");
			menuAdmin = myObj.nextInt();
			
			switch(menuAdmin) {
				case 1:
					cripto = crearCriptomoneda(cripto);
					break;
				case 4:
					consultarCriptomoneda(cripto);
					break;
				case 5:
					consultarEstadoDelMercado(cripto,mercado);
					break;
			}
		}while(menuAdmin != 6);
		
		Archivo.modificarCriptomonedaArchivo(cripto);
	}
	
	public static void MenuUsuario(List<Criptomoneda> cripto, List<Mercado> mercado) {
		Scanner myObj = new Scanner(System.in);
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
			
			System.out.print("Ingrese su opcion (1 - 7): ");
			menuUsuario = myObj.nextInt();
			
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
		}
			
		}while(menuUsuario != 7);
	}
	
	private static List<Criptomoneda> crearCriptomoneda(List<Criptomoneda> listCripto) {
		System.out.println("---- Crear Criptomoneda ----");
		System.out.print("Ingrese el nombre de la criptomoneda: ");

		Scanner sc = new Scanner(System.in);
		String nombreCripto = sc.nextLine();
		
		Criptomoneda encontrada =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
		if(encontrada == null) {
			System.out.print("Ingrese el simbolo del criptomoneda: ");
			String simboloCripto = sc.nextLine();
			
			Criptomoneda simboloLista =  Criptomoneda.simboloExiste(listCripto,nombreCripto);
			
			if(simboloLista == null) {
				System.out.print("Ingrese el precio inicial: ");
				BigDecimal precio = sc.nextBigDecimal();
				Criptomoneda nuevaCripto = new Criptomoneda(nombreCripto,simboloCripto,precio);
				listCripto.add(nuevaCripto);
			}else {
				System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ simboloLista.getNombre() + "?");
				System.out.print("Si (S) o No (N): ");
				String modificarCripto = sc.nextLine(); 
			}
		}else {
			System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ encontrada.getNombre() + "?");
			System.out.print("Si (S) o No (N): ");
			String modificarCripto = sc.nextLine(); 
		}
		
		return listCripto;
	}
	
	private static void consultarCriptomoneda(List<Criptomoneda> listCripto) {
		
		System.out.println("---- Consultar Criptomoneda ----");
		System.out.print("Ingrese el nombre de la criptomoneda: ");

		Scanner sc = new Scanner(System.in);
		String nombreCripto = sc.nextLine();
		String format = "%-20s%-20s%s";
		
		Criptomoneda encontrada =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
		
		if(encontrada != null) {
			System.out.printf(format, "Nombre:" + encontrada.getNombre()
									, "Alias:" + encontrada.getSimbolo()
									, "Precio:" + encontrada.getPrecio());
			System.out.println("\n-----------------\n");
			System.out.println("Presiona Enter para continuar...\n");
			sc.nextLine();
		}
		else {
			System.out.println("No se encontró la criptomoneda.");
		}
		
	}
	
	private static void consultarEstadoDelMercado(List<Criptomoneda> listCripto,List<Mercado> listMercado) {
		
		System.out.println("---- Consultar estado actual del mercado ----");
		System.out.print("Ingrese el nombre de la criptomoneda: ");

		Scanner sc = new Scanner(System.in);
		String nombreCripto = sc.nextLine();
		
		Criptomoneda cripto =  Criptomoneda.getCriptomoneda(listCripto,nombreCripto);
		
		assert cripto != null : "No existe esa cripto rey";
		
		Mercado mercado = Mercado.getMercado(listMercado,cripto.getSimbolo());
		
		if(mercado != null) {
			mercado.mostrarDatos();
			System.out.println("\n-----------------\n");
			System.out.println("Presiona Enter para continuar...\n");
			sc.nextLine();
		}
		else {
			System.out.println("No se encontró la criptomoneda.");
		}
		
	}
}
