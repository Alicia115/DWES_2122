package Ejercicio3;

public class Presidente {
	
	private String nombre;
	private String apellido;
	private String anio_eleccion;
	
	private static Presidente presidente = null;
	
	private Presidente(String nombre, String apellido, String anio_eleccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.anio_eleccion = anio_eleccion;
	}
	
	
	public static Presidente getPresidente(String nombre, String apellido, String anio_eleccion) {
		
		if(presidente == null) {
			presidente = new Presidente(nombre,apellido,anio_eleccion);
		}
			return presidente;
		
		

	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAnio_eleccion() {
		return anio_eleccion;
	}

	public void setAnio_eleccion(String anio_eleccion) {
		this.anio_eleccion = anio_eleccion;
	}


	@Override
	public String toString() {
		return "Presidente [nombre=" + nombre + ", apellido=" + apellido + ", anio_eleccion=" + anio_eleccion + "]";
	}
	
	
	
	
	

}
