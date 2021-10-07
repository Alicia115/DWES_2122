package Ejercicio1;

public class Casa {
	
	private double area;
	private Tejado tejado;
	private Pared pared1;
	private Pared pared2;
	private Pared pared3;
	private Pared pared4;
	
	
	public Casa(double area, Tejado tejado, Pared pared1, Pared pared2, Pared pared3, Pared pared4) {
		super();
		this.area = area;
		this.tejado = tejado;
		this.pared1 = pared1;
		this.pared2 = pared2;
		this.pared3 = pared3;
		this.pared4 = pared4;
	}
	
	
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public Tejado getTejado() {
		return tejado;
	}
	public void setTejado(Tejado tejado) {
		this.tejado = tejado;
	}
	public Pared getPared1() {
		return pared1;
	}
	public void setPared1(Pared pared1) {
		this.pared1 = pared1;
	}
	public Pared getPared2() {
		return pared2;
	}
	public void setPared2(Pared pared2) {
		this.pared2 = pared2;
	}
	public Pared getPared3() {
		return pared3;
	}
	public void setPared3(Pared pared3) {
		this.pared3 = pared3;
	}
	public Pared getPared4() {
		return pared4;
	}
	public void setPared4(Pared pared4) {
		this.pared4 = pared4;
	}


	@Override
	public String toString() {
		return "Casa [area=" + area + ", tejado=" + tejado + ", pared1=" + pared1 + ", pared2=" + pared2 + ", pared3="
				+ pared3 + ", pared4=" + pared4 + "]";
	}
	
	
	
	

}
