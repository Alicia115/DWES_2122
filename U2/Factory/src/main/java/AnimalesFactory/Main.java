package AnimalesFactory;

public class Main {
	
	public static void main(String[] args) {
		
		Animal a = FactoriaAnimales.getAnimal("perro");
		a.setNombre("pedro");
		System.out.println(a.getSaludo());
	}

}
