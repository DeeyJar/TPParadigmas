package unlam.edu.cripto;

import java.util.Scanner;

public class Menu {
	public static void MenuAdministrador() {
		Scanner myObj = new Scanner(System.in);
		int menuAdmin;
		System.out.flush(); 
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
				case 4:
					System.out.println("Hola");
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
