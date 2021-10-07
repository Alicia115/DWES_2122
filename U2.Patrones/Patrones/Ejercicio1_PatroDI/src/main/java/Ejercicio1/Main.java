package Ejercicio1;

public class Main {
	
	public static void main(String[] args) {
		
		Pared frontal = new Pared (7);
		Pared trasera = new Pared (6.5);
		Pared derecha = new Pared (4);
		Pared izquierda = new Pared (7);
		Pared frontal1 = new Pared(9.6);
		Pared trasera1 = new Pared (8);
		Pared derecha1 = new Pared (7.5);
		Pared izquierda1 = new Pared (6.6);
		Tejado tejado = new Tejado();
		TejadoTejas tejas = new TejadoTejas();
		
		Casa casa1 = new Casa (45, tejado, frontal, trasera, derecha, izquierda);
		Casa casa2 = new Casa (60, tejas, frontal1, trasera1, derecha1, izquierda1);
		
		System.out.println(casa1);
		System.out.println(casa2);
	}

}
