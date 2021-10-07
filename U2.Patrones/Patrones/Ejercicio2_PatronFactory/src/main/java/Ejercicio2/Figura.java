package Ejercicio2;

public abstract class Figura {
	
	protected String color;
	
	

	public Figura(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Figura [color=" + color + "]";
	}
	
	public abstract String getdibujarFigura();
	

}
