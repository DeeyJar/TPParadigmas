package tp.unlam.edu.ar.criptomoneda.manager;

import java.math.BigDecimal;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Historico;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioTrader;
import tp.unlam.edu.ar.criptomoneda.utils.Archivo;
import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class UsuarioTraderManager {
	
	private static Archivo archivo = Archivo.getInstancia();
	
	public static void comprarCriptomoneda() {
		System.out.println("----------- Comprar Criptomoneda -----------");
		String simbolo = InputHelper.getString("Ingrese el nuevo símbolo: ");
		UsuarioTrader usuario = (UsuarioTrader)archivo.getUsuario();
		Criptomoneda cripto = CriptomonedaManager.buscarCriptomonedaPorSimbolo(simbolo);
		
		if(cripto != null) {
			Mercado mercado = MercadoManager.buscarMercadoPorSimbolo(simbolo);
			CriptomonedaManager.mostrarDatosCompra(cripto,mercado.getCapacidad());
			Long cantidad = InputHelper.getLong("Ingrese la cantidad que desea comprar: ");
			if(cantidad > 0) {
				if(cantidad <= mercado.getCapacidad()) {
					BigDecimal montoTotal = cripto.getPrecio().multiply(new BigDecimal(cantidad));
					if(usuario.getSaldoActual().compareTo(montoTotal) >= 0) {
						System.out.println("Monto total:" + montoTotal);
						String confimarCompra = InputHelper.getString("Confirmar compra\n Si(s) o No(n): ");
						switch(confimarCompra) {
							case "s":
							case "S":
								System.out.println("Procesando compra...");
								usuario.setSaldoCompra(montoTotal);
								mercado.setCapacidadCompra(cantidad);
								mercado.setVolumenCompra();
								mercado.setVariacionCompra();
								HistoricoManager.actualizarCantidad(mercado.getSimbolo(),cantidad);
								System.out.println("Compra exitosa.");
								break;
							case "n":
							case "N":
								System.out.println("Adios pobre.");
								break;
						}		
					}else {
						System.out.println("Fondos insuficientes.");
					}
				}else {
					System.out.println("Error, cantida de maxima de compra es " + mercado.getCapacidad());
				}
			}else {
				System.out.println("La cantidad tiene que ser mayor de cero.");
			}
		}else {
			System.out.println("----------- No se encontro la criptomoneda -----------");
		}
		InputHelper.pauseSystem();
	}
	
	public static void ventaCriptomoneda() {
		System.out.println("----------- Venta Criptomoneda -----------");
		HistoricoManager.mostrarHistorico();
		String simboloCripto = InputHelper.getString("Ingrese el simbolo de la criptomoneda: ");
		UsuarioTrader usuario = (UsuarioTrader)archivo.getUsuario();
		
		Historico historial = HistoricoManager.buscarSimboloDelHistorico(simboloCripto);
		Criptomoneda cripto = CriptomonedaManager.buscarCriptomonedaPorSimbolo(simboloCripto);
		Mercado mercado = MercadoManager.buscarMercadoPorSimbolo(simboloCripto);
		
		if(historial != null && cripto != null) {
			if(historial.getCapacidad() > 0) {
				long ventaCripto = InputHelper.getLong("Ingrese la cantidad de venta: ");
				if(ventaCripto <= historial.getCapacidad()) {
					System.out.println("Procesando venta...");
					mercado.setCapacidadVenta(ventaCripto);
					mercado.setVariacionVenta();
					mercado.setVolumenVenta();
					
					historial.setActualizarCapacidadVenta(ventaCripto);
					
					usuario.setSaldoVenta(cripto.getPrecio().multiply(new BigDecimal(ventaCripto)));
					System.out.println("Venta completa");
				}else {
					System.out.println("Supera la capacidad disponible.");
				}
			}
			else {
				System.out.println("No es posible realizar la venta.");
			}
		}
		else{
			System.out.println("No se encontro la criptomoneda.");
		}
		InputHelper.pauseSystem();
	}
}
