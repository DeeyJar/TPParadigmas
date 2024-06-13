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
					System.out.println("---- Consultar Criptomoneda ----");
					System.out.print("Ingrese el nombre de la criptomoneda: ");
					
					myObj.nextLine();
					nombreCripto = myObj.nextLine();
					
					Criptomoneda cripto =  Archivo.criptomonedaArchivo(nombreCripto.toLowerCase());
					if(cripto != null) {
						System.out.println("Nombre:" + cripto.getNombre());
						System.out.println("Alias:" + cripto.getAlias());
						System.out.println("Precio:" + cripto.getPrecio());
						System.out.println("-----------------");
						System.out.println("Presiona Enter para continuar...");
						myObj.nextLine();
					}
					else {
						System.out.println("No se encontro la criptomoneda.");
					}
					break;
			}
		}while(menuAdmin != 6);
	}
	
	public static void MenuUsuario() {
		Scanner myObj = new Scanner(System.in);
		int menuAdmin;
		
		do {
			System.out.println("Menu de opciones Usuario");
			System.out.println("----------------");
			System.out.println("1) Comprar Criptomonedas");
			System.out.println("2) Vender Criptomonedas");
			System.out.println("3) Consultar Criptomoneda");
			System.out.println("4) Recomendar Criptomoneda");
			System.out.println("5) Consultar estado actual del mercado");
			System.out.println("6) Visualizar archivo de transacciones (histórico).");
			System.out.println("7) Salir");
			
			System.out.print("Ingrese su opcion (1 - 7): ");
			menuAdmin = myObj.nextInt();
			
			
			
		}while(menuAdmin != 7);
	}
}
