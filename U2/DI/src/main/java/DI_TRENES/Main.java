package DI_TRENES;

public class Main {
	
	public static void main(String[] args) {
	
		Maquinista_Primera maquinista = new Maquinista_Primera("Pepe", "Gonzalez", "Mi casa",4);
		Locomotora locomotora = new Locomotora("modelo1", 11, 55);
		
		Tren tren = new Tren("bueno", maquinista,locomotora);
		
		
		
	}
}
