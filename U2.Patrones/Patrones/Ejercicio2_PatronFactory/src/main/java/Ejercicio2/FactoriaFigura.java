package Ejercicio2;

public class FactoriaFigura {
	
	public static Figura getFigura(String tipo, String color){
		
		if (tipo.equals("circulo")) {
			
			return new Circulo(color);
			
		}else if(tipo.equals("rectangulo")) {
			
			return new Rectangulo (color);
			
		} else if(tipo.equals("cuadrado")){
			return new Cuadrado (color);
		} else {
			return new Triangulo (color);
		}
		
	}

}
