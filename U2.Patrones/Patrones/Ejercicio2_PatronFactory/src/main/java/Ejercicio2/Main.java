package Ejercicio2;


public class Main {
	
	 public static void main(String[] args) {
			
			Figura f1 = FactoriaFigura.getFigura("circulo", "rojo");
			System.out.println(f1.getdibujarFigura());
			
			Figura f2 = FactoriaFigura.getFigura("triangulo", "verde");
			System.out.println(f2.getdibujarFigura());
			
			Figura f3 = FactoriaFigura.getFigura("cuadrado", "azul");
			System.out.println(f3.getdibujarFigura());
			
			Figura f4 = FactoriaFigura.getFigura("rectangulo", "amarillo");
			System.out.println(f4.getdibujarFigura());
			
			
	}
	 
}
