package Singleton;

public class Deposito {
	
	private static int cantidad = 0;
	private static Deposito deposito = null;
	
	private Deposito() {
		System.out.println("Deposito creado");
	}
	
	public static Deposito getDeposito() {
		
		if (deposito == null) {
			deposito = new Deposito();
		} 
		
		return deposito;
	}
	
	public static int llenar (int numlitros) {
		
		Deposito.cantidad +=numlitros;
		
		return Deposito.cantidad;
		
	}
	
	public static int vaciar (int numlitros) {
		

		Deposito.cantidad -=numlitros;
		
		return Deposito.cantidad;
		
	}
	
	public static int getCantidad(){
		return Deposito.cantidad;
	}

}
