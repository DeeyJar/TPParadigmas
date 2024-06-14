package unlam.edu.cripto;

import java.util.Scanner;

public class Menu {
	public static void MenuAdministrador() {
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
					System.out.println("Hola");
					break;
				case 4:
					consultarCriptomoneda();
					break;
				case 5:
					consultarEstadoDelMercado();
					break;
			}
		}while(menuAdmin != 6);
	}
	
	public static void MenuUsuario() {
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
				consultarCriptomoneda();
				break;
			case 5:
				consultarEstadoDelMercado();
				break;
		}
			
		}while(menuUsuario != 7);
	}
	
	private static void consultarCriptomoneda() {
		
		System.out.println("---- Consultar Criptomoneda ----");
		System.out.print("Ingrese el nombre de la criptomoneda: ");

		Scanner sc = new Scanner(System.in);
		String nombreCripto = sc.nextLine();
		String format = "%-20s%-20s%s";
		
		Criptomoneda cripto =  Archivo.criptomonedaArchivo(nombreCripto.toLowerCase());
		
		if(cripto != null) {
			System.out.printf(format, "Nombre:" + cripto.getNombre()
									, "Alias:" + cripto.getSimbolo()
									, "Precio:" + cripto.getPrecio());
			System.out.println("\n-----------------\n");
			System.out.println("Presiona Enter para continuar...\n");
			sc.nextLine();
		}
		else {
			System.out.println("No se encontró la criptomoneda.");
		}
		
	}
	
	private static void consultarEstadoDelMercado() {
		
		System.out.println("---- Consultar estado actual del mercado ----");
		System.out.print("Ingrese el nombre de la criptomoneda: ");

		Scanner sc = new Scanner(System.in);
		String nombreCripto = sc.nextLine();
		String format = "%-15s%-40s%s\n";
		
		Criptomoneda cripto =  Archivo.criptomonedaArchivo(nombreCripto.toLowerCase());
		
		assert cripto != null : "No existe esa cripto rey";
		
		Mercado mercado = Archivo.buscarEstadoDelMercado(cripto.getSimbolo());
		
		if(mercado != null) {
			System.out.println("\nDatos del mercado:");
			System.out.printf(format, "Capacidad", "Volumen en las últimas 24 horas", "Variación en los últimos 7 días");
			System.out.printf(format, mercado.getCapacidad(), mercado.getVolumen(), mercado.getVariacion());
			System.out.println("\n-----------------\n");
			System.out.println("Presiona Enter para continuar...\n");
			sc.nextLine();
		}
		else {
			System.out.println("No se encontró la criptomoneda.");
		}
		
	}
}
