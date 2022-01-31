package Ejercicio4;

import java.util.List;

public interface PaymentsDAO {
	
	boolean comprobarPayment(int number);
	boolean createPayment(int customerNumber,String checkNumber,String paymentDate, double amount );
	List<Payments> getPayments();

}
