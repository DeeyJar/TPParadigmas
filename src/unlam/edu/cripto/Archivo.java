package unlam.edu.cripto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Archivo {
	public Usuario archivoUsuario() {
		String usuarioPath = "./usuarios.csv";
		Scanner myObj = new Scanner(System.in);
		String usuarioInput;
		Usuario usuarioEncontrado = null;
		System.out.print("Ingrese usuario: ");
		usuarioInput = myObj.nextLine(); 
		
        try (BufferedReader br = new BufferedReader(new FileReader(usuarioPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if(usuarioInput.equals(values[0])) {
                	if (values.length == 2) {
                        //Admin
                		usuarioEncontrado = new Usuario(values[0], values[1]);
                    } else if (values.length == 4) {
                        //Usuario
                    	usuarioEncontrado = new Usuario(values[0], Integer.parseInt(values[1]),values[2], Integer.parseInt(values[3]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return usuarioEncontrado;
	}
	
	public static Criptomoneda criptomonedaArchivo(String nombreCripto) {
		String criptomonedasPath = "./criptomonedas.csv";
		Criptomoneda criptomoneda = null;
		
        try (BufferedReader br = new BufferedReader(new FileReader(criptomonedasPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if(nombreCripto.equals(values[0].toLowerCase())) {
                	criptomoneda = new Criptomoneda(values[0], values[1], new BigDecimal(values[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return criptomoneda;
	}
	
	public static Mercado buscarEstadoDelMercado(String simbolo) {
		String criptomonedasPath = "./mercados.csv";
		Mercado mercado = null;
		
        try (BufferedReader br = new BufferedReader(new FileReader(criptomonedasPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if(simbolo.equals(values[0])) {
                	mercado = new Mercado(values[0], new BigDecimal(values[1]), new BigDecimal(values[2]), new BigDecimal(values[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return mercado;
	}
}
