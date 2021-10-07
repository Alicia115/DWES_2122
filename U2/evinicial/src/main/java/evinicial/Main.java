package evinicial;

import BDSingleton.ConexionBD;
import DAO.ClassicModelsDAO;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("-----------------------------");
		System.out.println("LISTA DE EMPLEADOS");
		System.out.println(ClassicModelsDAO.getEmpleados());
		System.out.println("-----------------------------");

		System.out.println("-----------------------------");
		System.out.println("LISTA DE OFICINAS");
		System.out.println(ClassicModelsDAO.getOffices());
		System.out.println("-----------------------------");

		// Cierro cualquier conexión que se haya abierto en otro lado
		ConexionBD.close(); 
		
		
	}
	

}
