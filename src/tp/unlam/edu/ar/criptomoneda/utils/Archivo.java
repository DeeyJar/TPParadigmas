package tp.unlam.edu.ar.criptomoneda.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.model.Usuario;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioAdministrador;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioTrader;

public class Archivo {
	
	public static final int LENGHT_ADMIN = 2;
	public static final String USUARIO_FILE_PATH = "./files/usuarios.csv";
	public static final String CRIPTOMONEDA_FILE_PATH = "./files/criptomonedas.csv";
	public static final String MERCADO_FILE_PATH = "./files/mercados.csv";

	public static Usuario obtenerORegistrarUsuario() {
		String usuarioInput;
		Usuario usuarioEncontrado = null;

		usuarioInput = InputHelper.getString("Ingrese nombre de usuario: "); 
		
        try (RandomAccessFile raf = new RandomAccessFile(USUARIO_FILE_PATH, "rw")) {
            String line;
            while ((line = raf.readLine()) != null) {
                String[] values = line.split(";");
                if(usuarioInput.equals(values[0])) {
                	if (values.length == LENGHT_ADMIN) {
                        // Admin
                		usuarioEncontrado = new UsuarioAdministrador(values[0], values[1]);
                    } else {
                        // Usuario trader
                    	usuarioEncontrado = new UsuarioTrader(values[0], Long.parseLong(values[1]),values[2], new BigDecimal(values[3]));
                    }
                	break;
                }
            }
            
            // si no encuentra el usuario, se realiza un registro de un usuario trader
            if(usuarioEncontrado == null) {
            	System.out.println("\nUsuario no encontrado. ");
            	
            	usuarioEncontrado = new UsuarioTrader(usuarioInput);
            	((UsuarioTrader)usuarioEncontrado).completarRegistro();
            	
            	raf.seek(raf.length()); // Mover el puntero al final del archivo
                raf.writeBytes(usuarioEncontrado.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return usuarioEncontrado;
	}
	
	public static List<Criptomoneda> criptomonedaArchivo() {
		Criptomoneda criptomoneda = null;
		List<Criptomoneda> listCripto = new ArrayList<>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(CRIPTOMONEDA_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                criptomoneda = new Criptomoneda(values[0], values[1], new BigDecimal(values[2]));
                listCripto.add(criptomoneda);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return listCripto;
	}
	
	public static void modificarCriptomonedaArchivo(List<Criptomoneda> cripto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CRIPTOMONEDA_FILE_PATH))) {
            for(Criptomoneda c : cripto) {
            	String line = c.toString();
            	writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void modificarMercadoArchivo(List<Mercado> mercado){
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(MERCADO_FILE_PATH))) {
			for(Mercado m : mercado) {
				String line = m.toString();
	            writer.write(line);
	            writer.newLine();
			}
       } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static List<Mercado> estadoDelMercado() {
		Mercado mercado = null;
		List<Mercado> listMercado = new ArrayList<>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(MERCADO_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                mercado = new Mercado(values[0], new BigDecimal(values[1]), new BigDecimal(values[2]), new BigDecimal(values[3]));
                listMercado.add(mercado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return listMercado;
	}
}
