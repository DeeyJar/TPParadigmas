package tp.unlam.edu.ar.criptomoneda.manager;

import java.math.BigDecimal;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.main.SubmenuModificarCriptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class CriptomonedaManager {

	private static Archivo archivo = Archivo.getInstancia();
	public static final String FORMAT = "\n%-20s%-20s%s\n";
	public static final String FORMAT_COMPRA = "\n%-20s%-20s%-20s%s\n";
	
	public static void crearCriptomoneda() {
		System.out.println("----------- Crear Criptomoneda -----------");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
		String mensaje;
		
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
				mensaje = "Simbolo ya existente, ¿desea modificar la criptomoneda?\nSi (1) o No (2):";
				SubmenuModificarCriptomoneda.mostrarSubMenuCriptoExistente(mensaje,encontrada);
			}
		} else {
			mensaje = "Nombre ya existente, ¿desea modificar la criptomoneda?\nSi (1) o No (2):";
			SubmenuModificarCriptomoneda.mostrarSubMenuCriptoExistente(mensaje,encontrada);
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
	
	public static void mostrarDatosCompra(Criptomoneda cripto, Long cantidad) {
		System.out.printf(FORMAT_COMPRA, "Nombre:" + cripto.getNombre()
		, "Alias:" + cripto.getSimbolo()
		, "Precio:" + cripto.getPrecio()
		, "Cantidad:" + cantidad);
	}
	
	public static void modificarCriptomoneda() {
		SubmenuModificarCriptomoneda.mostrar();
	}
	
	public static void modificarNombreCriptomoneda(Criptomoneda criptomoneda) {
		String nombreModificado = InputHelper.getString("Ingrese el nuevo nombre: ");
		Criptomoneda nombreExistente = buscarCriptomonedaPorNombre(nombreModificado);
		
		if( nombreExistente == null) {
			criptomoneda.setNombre(nombreModificado);
			System.out.println("Nombre criptomoneda modificado exitosamente.");
		} else {
			System.out.println("El nombre criptomoneda ya existe.");
		}
	}
	
	public static void modificarSimboloCriptomoneda(Criptomoneda criptomoneda) {
		String simboloModificado = InputHelper.getString("Ingrese el nuevo símbolo: ");
		Criptomoneda simboloExistente = buscarCriptomonedaPorSimbolo(simboloModificado);
		
		if(simboloExistente== null) {
			Mercado mercado = MercadoManager.buscarMercadoPorSimbolo(criptomoneda.getSimbolo());
			criptomoneda.setSimbolo(simboloModificado);
			mercado.setSimbolo(simboloModificado);
			System.out.println("Simbolo criptomoneda modificado exitosamente.");
		}else {
			System.out.println("Simbolo ya existente.");
		}
	}
	
	public static void modificarPrecioCriptomoneda(Criptomoneda criptomoneda) {
		BigDecimal nuevoPrecio = InputHelper.getBigDecimal("Ingrese el nuevo precio de dolar base: ");
		criptomoneda.setPrecio(nuevoPrecio);
		System.out.println("Precio criptomoneda modificado exitosamente.");
	}
	
	public static void eliminarCriptomoneda() {
		System.out.println("--------- Eliminar Criptomoneda ---------");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda a eliminar: ");
		
		Criptomoneda encontrada =  buscarCriptomonedaPorNombre(nombreCripto);
		
		if(encontrada != null) {
			archivo.getListaCriptomonedas().remove(encontrada);
			Mercado mercadoEliminar = MercadoManager.buscarMercadoPorSimbolo(encontrada.getSimbolo());
			archivo.getListaMercados().remove(mercadoEliminar);
			System.out.println("--------- Criptomoneda eliminada exitosamente ---------");
		}else {
			System.out.println("--------- No se encontro esa cripto ---------");
		}
		InputHelper.pauseSystem();
	}
}
