package DI_TRENES;

public class Locomotora {
	
	private String modelo;
	private int potencia;
	private int longitud;
	
	public Locomotora(String modelo, int potencia, int longitud) {
		this.modelo = modelo;
		this.potencia = potencia;
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Locomotora [modelo=" + modelo + ", potencia=" + potencia + ", longitud=" + longitud + "]";
	}
	
	
	
	

}
