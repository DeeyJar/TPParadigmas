package unlam.edu.cripto;

public class Usuario {
    private String nombre;
	private String rol;
    private int numeroCuenta;
    private String banco;
    private int saldo;
    
    public Usuario() {
    }
    
    public Usuario(String nombre, String rol) {
    	this.nombre = nombre;
    	this.rol = rol;
    }
    
    public Usuario(String nombre, int numeroCuenta,
    		String banco, int saldo) {
    	this.nombre = nombre;
    	this.numeroCuenta = numeroCuenta;
    	this.banco = banco;
    	this.saldo = saldo;
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

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}
