package tp.unlam.edu.ar.criptomoneda.model;

import java.math.BigDecimal;

import tp.unlam.edu.ar.criptomoneda.utils.InputHelper;

public class UsuarioTrader extends Usuario {
	
	private Long numeroCuenta;
    private String nombreBanco;
    private BigDecimal saldoActual;
    
    
	public UsuarioTrader() {
		super();
	}

	public UsuarioTrader(String nombre) {
		super(nombre);
	}

	public UsuarioTrader(String nombre, Long numeroCuenta, String nombreBanco, BigDecimal saldoActual) {
		super(nombre);
		this.numeroCuenta = numeroCuenta;
		this.nombreBanco = nombreBanco;
		this.saldoActual = saldoActual;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public BigDecimal getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(BigDecimal saldoActual) {
		this.saldoActual = saldoActual;
	}

	public void completarRegistro() {
    	System.out.println("------------Registro de usuario------------");

    	this.numeroCuenta = InputHelper.getLong("Ingrese número de cuenta bancaria: ");
    	this.nombreBanco = InputHelper.getString("Ingrese nombre del banco: ");
    	this.saldoActual = InputHelper.getBigDecimal("Ingrese su saldo actual: ");
    }

	@Override
	public String toString() {
		return super.getNombre() + ";" + numeroCuenta + ";" + nombreBanco + ";" + saldoActual;
	}
}
