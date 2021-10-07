package DI_TRENES;

public class Maquinista_Primera extends Maquinista {
	
	private int antiguedad;

	public Maquinista_Primera(String nombre, String apellidos, String direccion, int antiguedad) {
		super(nombre, apellidos, direccion);
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "Maquinista_Primera [antiguedad=" + antiguedad + "]";
	}
	
	
	

}
