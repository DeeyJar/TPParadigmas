package tp.unlam.edu.ar.criptomoneda.manager;

import java.math.BigDecimal;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class CriptomonedaManager {

	private static Archivo archivo = Archivo.getInstancia();
	public static final String FORMAT = "%-20s%-20s%s";
	
	public static void crearCriptomoneda() {
		System.out.println("----------- Crear Criptomoneda -----------");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
		
		Criptomoneda encontrada = buscarCriptomonedaPorNombre(nombreCripto);
		
		if(encontrada == null) {
			String simboloCripto = InputHelper.getString("Ingrese el simbolo del criptomoneda: ");
			
			encontrada =  buscarCriptomonedaPorSimbolo(simboloCripto);
			
			if(encontrada == null) {
				BigDecimal precio = InputHelper.getBigDecimal("Ingrese el precio inicial: ");
				Criptomoneda nuevaCripto = new Criptomoneda(nombreCripto,simboloCripto,precio);
				archivo.getListaCriptomonedas().add(nuevaCripto);
				
				MercadoManager.agregarCriptomonedaEnMercado(nuevaCripto);
				InputHelper.pauseSystem();
			} else {
				System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ encontrada.getNombre() + "?");
				System.out.print("Si (S) o No (N): ");
				//llamar submenuModificarCripto (encontrada)
			}
		} else {
			System.out.print("Simbolo ya existente, ¿desea modificar la criptomoneda"+ encontrada.getNombre() + "?");
			System.out.print("Si (S) o No (N): ");
			// TODO retomar cuando creemos metodo de modificar cripto
			//llamar submenuModificarCripto (encontrada)
		}
		
	}
	
	public static void consultarCriptomoneda() {
		
		System.out.println("---- Consultar Criptomoneda ----");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
		
		Criptomoneda encontrada =  CriptomonedaManager.buscarCriptomonedaPorNombre(nombreCripto);
		
		if(encontrada != null) {
			mostrarDatosDeCriptomoneda(encontrada);
			InputHelper.pauseSystem();
		}
		else {
			System.out.println("\nNo se encontró la criptomoneda.");
			InputHelper.pauseSystem();
		}
		
	}
	
	public static Criptomoneda buscarCriptomonedaPorNombre(String nombre) {
		Criptomoneda criptoEncontrada = null;
		
		for(Criptomoneda c: archivo.getListaCriptomonedas()) {
			if(nombre.equalsIgnoreCase(c.getNombre())) {
				criptoEncontrada = c;
				break;
			}
		}
		
		return criptoEncontrada;
	}
	
	public static Criptomoneda buscarCriptomonedaPorSimbolo(String simbolo) {
		Criptomoneda criptoEncontrada = null;
		
		for(Criptomoneda c: archivo.getListaCriptomonedas()) {
			if(simbolo.equalsIgnoreCase(c.getSimbolo())) {
				criptoEncontrada = c;
				break;
			}
		}
		
		/* ver posible uso de stream con una excepcion propia tipo NoEncontradaException()
		 * 
		 * */
		return criptoEncontrada;
	}
	
	public static void mostrarDatosDeCriptomoneda(Criptomoneda c) {
		System.out.printf(FORMAT, "Nombre:" + c.getNombre()
								, "Alias:" + c.getSimbolo()
								, "Precio:" + c.getPrecio());
	}
}
