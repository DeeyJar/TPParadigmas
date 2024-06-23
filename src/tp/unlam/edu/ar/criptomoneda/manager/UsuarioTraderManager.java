package tp.unlam.edu.ar.criptomoneda.manager;

import java.math.BigDecimal;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
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
						String confimarCompra = InputHelper.getString("Confirmar compra\n Si(1) o No(2): ");
						switch(confimarCompra) {
							case "s":
							case "S":
								System.out.println("Procesando compra...");
								usuario.setSaldoCompra(montoTotal);
								mercado.setCapacidadCompra(cantidad);
								mercado.setVolumenCompra();
								mercado.setVariacionCompra();
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
}
