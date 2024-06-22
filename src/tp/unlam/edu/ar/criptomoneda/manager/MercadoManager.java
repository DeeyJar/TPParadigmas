package tp.unlam.edu.ar.criptomoneda.manager;

import java.math.BigDecimal;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class MercadoManager {
	
	private static Archivo archivo = Archivo.getInstancia();
	
	public static final String FORMAT = "%-15s%-40s%s\n";
	
	public static void consultarEstadoDelMercado() {
		
		System.out.println("---- Consultar estado actual del mercado ----");
		String nombreCripto = InputHelper.getString("Ingrese el nombre de la criptomoneda: ");
		
		Criptomoneda cripto =  CriptomonedaManager.buscarCriptomonedaPorNombre(nombreCripto);
		if(cripto != null) {
			Mercado mercado = buscarMercadoPorSimbolo(cripto.getSimbolo());
			
			if(mercado != null) {
				mostrarDatosMercado(mercado);
				InputHelper.pauseSystem();
			}
			else {
				System.out.println("No se encontró la criptomoneda.");
			}
		}else {
			System.out.println("No se encontró la criptomoneda.");
		}
	}	
	
	public static Mercado buscarMercadoPorSimbolo(String simboloCripto) {
		Mercado encontrada = null;
		for(Mercado m : archivo.getListaMercados()) {
			if(simboloCripto.equalsIgnoreCase(m.getSimbolo())) {
				encontrada = m;
				break;
			}
		}
		
		return encontrada;
	}
	
	public static void agregarCriptomonedaEnMercado(Criptomoneda criptomoneda) {
		Mercado agregar = new Mercado(criptomoneda.getSimbolo(),
									  new BigDecimal(500),
									  new BigDecimal(1), 
									  new BigDecimal(1));
		archivo.getListaMercados().add(agregar);
	}
	
	public static void mostrarDatosMercado(Mercado m) {
		System.out.println("\nDatos del mercado:");
		System.out.printf(FORMAT, "Capacidad", "Volumen en las últimas 24 horas", "Variación en los últimos 7 días");
		System.out.printf(FORMAT, m.getCapacidad(), m.getVolumen(), m.getVariacion());
	}

}
