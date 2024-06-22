package tp.unlam.edu.ar.criptomoneda.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputHelper {
	
	private static Scanner scanner = new Scanner(System.in);

    public static String getString(String descripcion) {
        System.out.print(descripcion);
        return scanner.nextLine();
    }

    public static boolean hasNextInt() {
        return scanner.hasNextInt();
    }
    
    public static int getInt(String descripcion) {
        System.out.print(descripcion);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero.");
            scanner.next(); // Descarta la entrada no válida
            System.out.print(descripcion);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }

    public static boolean hasNextBigDecimal() {
        return scanner.hasNextBigDecimal();
    }
    
    public static BigDecimal getBigDecimal(String descripcion) {
        System.out.print(descripcion);
        while (!scanner.hasNextBigDecimal()) {
            System.out.println("Por favor, ingresa un número.");
            scanner.next(); // Descarta la entrada no válida
            System.out.print(descripcion);
        }
        BigDecimal value = scanner.nextBigDecimal();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }
    
    public static boolean hasNextLong() {
        return scanner.hasNextLong();
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
    
    // Método para cerrar el scanner cuando ya no se necesite
    public static void close() {
        scanner.close();
    }
}
