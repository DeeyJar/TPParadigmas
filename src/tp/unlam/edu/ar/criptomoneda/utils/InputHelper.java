package tp.unlam.edu.ar.criptomoneda.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputHelper {
	
	private static Scanner scanner = new Scanner(System.in);

    public static String getString(String descripcion) {
        System.out.print("\n" + descripcion);
        return scanner.nextLine();
    }

    public static int getInt(String descripcion) {
        System.out.print("\n" + descripcion);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero.");
            scanner.next(); // Descarta la entrada no válida
            System.out.print("\n" + descripcion);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }
    
    public static BigDecimal getBigDecimal(String descripcion) {
        System.out.print("\n" + descripcion);
        while (!scanner.hasNextBigDecimal()) {
            System.out.println("Por favor, ingresa un número.");
            scanner.next(); // Descarta la entrada no válida
            System.out.print("\n" + descripcion);
        }
        BigDecimal value = scanner.nextBigDecimal();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }
    
    public static long getLong(String descripcion) {
        System.out.print(descripcion);
        while (!scanner.hasNextLong()) {
            System.out.println("Por favor, ingresa un número decimal.");
            scanner.next(); // Descarta la entrada no válida
            System.out.print(descripcion);
        }
        long value = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }
    
    public static void pauseSystem() {
    	System.out.print("\n---------------------------------");
    	getString("Presiona Enter para continuar...\n");
    }
    
    // Método para cerrar el scanner cuando ya no se necesite
    public static void close() {
        scanner.close();
    }
}
