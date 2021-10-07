package Singleton;

public class Main {
	
	public static void main(String[] args) {
		
		Cubos c1 = new Cubos(5);	
		Cubos c2 = new Cubos(6);
		Cubos c3 = new Cubos(9);
		
		c1.vaciar();
		c2.llenar();
		c3.vaciar();
		
		System.out.println(Deposito.getCantidad());
		
	}

}
