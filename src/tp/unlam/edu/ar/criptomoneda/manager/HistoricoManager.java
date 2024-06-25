package tp.unlam.edu.ar.criptomoneda.manager;

import tp.unlam.edu.ar.criptomoneda.model.Historico;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class HistoricoManager {
	private static Archivo archivo = Archivo.getInstancia();
	
	public static Historico buscarSimboloDelHistorico(String nombre) {
		Historico historial = null;
		
		for(Historico c: archivo.getListaHistorico()) {
			if(nombre.equalsIgnoreCase(c.getSimbolo())) {
				historial = c;
				break;
			}
		}
		
		return historial;
	}
	
	public static void actualizarCantidad(String simboloCripto,long cantidad) {
		Historico historial = buscarSimboloDelHistorico(simboloCripto);
		
		if(historial != null) {
			historial.setActualizarCapacidadCompra(cantidad);
		}else {
			Historico nuevaInformacion = new Historico(simboloCripto,cantidad);
			archivo.getListaHistorico().add(nuevaInformacion);
		}
	}
	
	public static void mostrarHistorico() {
		System.out.println("Simbolo Cantidad");
		for(Historico c: archivo.getListaHistorico()) {
			System.out.println(c.getSimbolo() + " ----- " + c.getCapacidad());
		}
	}
}
