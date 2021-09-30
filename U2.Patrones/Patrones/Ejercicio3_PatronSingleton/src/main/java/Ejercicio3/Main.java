package Ejercicio3;

public class Main {
	
	public static void main(String[] args) {
		
		Presidente presidente1 = Presidente.getPresidente("Pedro", "Gonzalez", "2020");
		System.out.println(presidente1);
		
		Presidente presidente2 = Presidente.getPresidente("Pepi", "Armario", "2021");
		System.out.println(presidente2);
		
	}

}
