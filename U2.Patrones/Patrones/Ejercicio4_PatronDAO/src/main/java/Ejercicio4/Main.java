package Ejercicio4;

public class Main {
	
	public static void main(String[] args) {
		
		PaymentsDAOImpl dao = new PaymentsDAOImpl ();
		dao.createPayment(459, "258", "2012-07-09",47.5 ); 
		ConexionBD.close();
	}

}
