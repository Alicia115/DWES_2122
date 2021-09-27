package AnimalesFactory;

public class FactoriaAnimales {
	
	public static Animal getAnimal(String tipo) {
		
		if(tipo.equals("gato")) {
			return new Gato();
		} else if (tipo.equals("perro")){
			return new Perro();
		} else {
			return new Vaca();
		}
		
		
	}

}
