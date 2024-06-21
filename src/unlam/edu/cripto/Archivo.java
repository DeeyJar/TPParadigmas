package unlam.edu.cripto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	public static Usuario archivoUsuario() {
		String usuarioPath = "./files/usuarios.csv";
		Scanner sc = new Scanner(System.in);
		String usuarioInput;
		Usuario usuarioEncontrado = null;
		System.out.print("Ingrese usuario: ");
		usuarioInput = sc.nextLine(); 
		
        try (RandomAccessFile raf = new RandomAccessFile(usuarioPath, "rw")) {
            String line;
            while ((line = raf.readLine()) != null) {
                String[] values = line.split(";");
                if(usuarioInput.equals(values[0])) {
                	if (values.length == 2) {
                        //Admin
                		usuarioEncontrado = new Usuario(values[0], values[1]);
                    } else if (values.length == 4) {
                        //Usuario
                    	usuarioEncontrado = new Usuario(values[0], Long.parseLong(values[1]),values[2], new BigDecimal(values[3]));
                    }
                }
                else {
                	System.out.println("\nUsuario no encontrado. ");
                	
                	usuarioEncontrado = new Usuario(usuarioInput);
                	usuarioEncontrado.completarRegistro();
                	
                	raf.seek(raf.length()); // Mover el puntero al final del archivo
                    raf.writeBytes(usuarioEncontrado.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return usuarioEncontrado;
	}
	
	public static List<Criptomoneda> criptomonedaArchivo(String criptomonedasPath) {
		Criptomoneda criptomoneda = null;
		List<Criptomoneda> listCripto = new ArrayList<Criptomoneda>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(criptomonedasPath))) {
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./criptomonedas.csv"))) {
            for(Criptomoneda c : cripto) {
            	String line = c.toString();
            	writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static List<Mercado> estadoDelMercado(String mercadoPath) {
		Mercado mercado = null;
		List<Mercado> listMercado = new ArrayList<Mercado>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(mercadoPath))) {
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
