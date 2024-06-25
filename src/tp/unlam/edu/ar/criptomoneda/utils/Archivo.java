package tp.unlam.edu.ar.criptomoneda.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import tp.unlam.edu.ar.criptomoneda.model.Criptomoneda;
import tp.unlam.edu.ar.criptomoneda.model.Historico;
import tp.unlam.edu.ar.criptomoneda.model.Mercado;
import tp.unlam.edu.ar.criptomoneda.model.Usuario;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioAdministrador;
import tp.unlam.edu.ar.criptomoneda.model.UsuarioTrader;

public class Archivo {
	
	private static final int LENGHT_ADMIN = 2;
	private static final String USUARIO_FILE_PATH = "./files/usuarios.csv";
	private static final String CRIPTOMONEDA_FILE_PATH = "./files/criptomonedas.csv";
	private static final String MERCADO_FILE_PATH = "./files/mercados.csv";

	private static Archivo instancia = null;
	private List<Criptomoneda> listaCriptomonedas;
	private List<Mercado> listaMercados;
	private List<Historico> listaHistorico;
	private Usuario usuario;
	
	private Archivo() {}
	
	public static Archivo getInstancia() {
		if(instancia == null) {
			instancia = new Archivo(); 
		}
		return instancia;
	}
	
	public List<Criptomoneda> getListaCriptomonedas() {
		return listaCriptomonedas;
	}

	public List<Mercado> getListaMercados() {
		return listaMercados;
	}
	
	public List<Historico> getListaHistorico() {
		return listaHistorico;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void obtenerORegistrarUsuario() {
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
                    	usuarioEncontrado = new UsuarioTrader(values[0],Long.parseLong(values[1]),values[2], new BigDecimal(values[3]));
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
            	raf.writeBytes("\n");
                raf.writeBytes(usuarioEncontrado.toString());
                
                crearArchivoHistoricoUsuario(usuarioEncontrado.getNombre());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.usuario = usuarioEncontrado;
	}
	
	public void guardarCambiosCriptomoneda() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CRIPTOMONEDA_FILE_PATH))) {
            for(Criptomoneda c: this.listaCriptomonedas) {
            	String line = c.toString();
            	writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void guardarCambiosMercado(){
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(MERCADO_FILE_PATH))) {
			for(Mercado m: this.listaMercados) {
				String line = m.toString();
	            writer.write(line);
	            writer.newLine();
			}
       } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void obtenerListaCriptomonedasDeArchivo() {
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
        
        this.listaCriptomonedas = listCripto;
	}
	
	public void obtenerListaMercadosDeArchivo() {
		Mercado mercado = null;
		List<Mercado> listMercado = new ArrayList<>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(MERCADO_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                mercado = new Mercado(values[0], 
                		Long.parseLong(values[1]), 
                		Float.parseFloat(values[2].replace("%", "")),
                		Float.parseFloat(values[3].replace("%", "")));
                listMercado.add(mercado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.listaMercados = listMercado;
	}
	
	public void guardarCambiosArchivoUsuario() {
		UsuarioTrader usuario = (UsuarioTrader)getUsuario();
		try (RandomAccessFile raf = new RandomAccessFile(USUARIO_FILE_PATH, "rw")) {
            String line;
            while ((line = raf.readLine()) != null) {
            	int pos = line.length();
            	long posicionActual = raf.getFilePointer();
            	long aux = posicionActual - pos;
                String[] values = line.split(";");
                if(usuario.getNombre().equals(values[0])) {
                	raf.seek(aux);
                	raf.writeBytes(usuario.toString());
                	break;
                }
			}
       } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void crearArchivoHistoricoUsuario(String nombreUsuario) {
		String rutaArchivo = "./files/" + nombreUsuario + "_historico.csv";
		File nuevoArchivo = new File(rutaArchivo);
		
		try {
			if(!nuevoArchivo.exists()) {
				boolean creado = nuevoArchivo.createNewFile();
				if(creado) {
					System.out.println("El archivo ha sido creado exitosamente.");
				}else {
					System.out.println("El archivo no pudo ser creado.");
				}
			}
		}catch (IOException e) {
            System.out.println("Ocurrió un error al intentar crear el archivo.");
            e.printStackTrace();
        }
	}
	
	public void obtenerListaHistoricoDeArchivo() {
		Historico historial = null;
		List<Historico> listHistorico = new ArrayList<>();
		String path = "./files/" + this.usuario.getNombre() + "_historico.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                historial = new Historico(values[0], Long.parseLong(values[1]));
                listHistorico.add(historial);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.listaHistorico = listHistorico;
	}
	
	public void guardarCambiosHistoricoArchivo() {
		String path = "./files/" + this.usuario.getNombre() + "_historico.csv";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			for(Historico m: this.listaHistorico) {
				String line = m.toString();
	            writer.write(line);
	            writer.newLine();
			}
       } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
