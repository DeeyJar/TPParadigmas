package unlam.edu.cripto;

import java.math.BigDecimal;
import java.util.Scanner;

public class Usuario {
    private String nombre;
	private String rol;
    private Long numeroCuenta;
    private String banco;
    private BigDecimal saldo;
    
    public Usuario() {
    }
    
    public Usuario(String nombre) {
    	this.nombre = nombre;
    }
    
    public Usuario(String nombre, String rol) {
    	this.nombre = nombre;
    	this.rol = rol;
    }
    
    public Usuario(String nombre, Long numeroCuenta,
    		String banco, BigDecimal saldo) {
    	this.nombre = nombre;
    	this.numeroCuenta = numeroCuenta;
    	this.banco = banco;
    	this.saldo = saldo;
    }
    
    public void completarRegistro() {
    	System.out.println("------------Registro de usuario------------");
    	System.out.println("Ingrese número de cuenta bancaria: ");
    	Scanner sc = new Scanner(System.in);
    	
    	this.setNumeroCuenta(sc.nextLong());
    	
    	sc.nextLine(); // limpio buffer
    	
    	System.out.println("Ingrese nombre del banco: ");
    	this.setBanco(sc.nextLine());
    	
    	System.out.println("Ingrese su saldo actual: ");
    	this.setSaldo(sc.nextBigDecimal());
    	
    	sc.nextLine(); // limpio buffer
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return nombre + ";" + numeroCuenta + ";" + banco + ";" + saldo;
	}
}
