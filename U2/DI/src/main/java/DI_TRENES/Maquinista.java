package DI_TRENES;

public class Maquinista  {
	
	private String nombre;
	private String apellidos;
	private String direccion;
	
	public Maquinista(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Maquinista [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + "]";
	}
	
	
	
	 
}
