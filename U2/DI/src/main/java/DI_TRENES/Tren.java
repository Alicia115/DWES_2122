package DI_TRENES;

public class Tren {
	
	private String modelo;
	private Maquinista maquinista;
	private Locomotora locomotora;
	
	
	public Tren(String modelo, Maquinista maquinista, Locomotora locomotora) {
		
		this.modelo = modelo;
		this.maquinista = maquinista;
		this.locomotora = locomotora;
	}


	@Override
	public String toString() {
		return "Tren [modelo=" + modelo + ", maquinista=" + maquinista + ", locomotora=" + locomotora + "]";
	}
	
	
	
}
