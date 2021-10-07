package Singleton;

public class Cubos {
	
	private int cantidad;
	
	public Cubos(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void vaciar() {
		Deposito.getDeposito();
		Deposito.llenar(this.cantidad);
		this.cantidad = 0;
	}
	
	public void llenar() {
		Deposito.getDeposito();
		Deposito.vaciar(this.cantidad);
	}

}