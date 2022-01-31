package Ejercicio4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PaymentsDAOImpl implements PaymentsDAO{

	@Override
	public boolean comprobarPayment(int number) {
		Connection con2 = ConexionBD.getConnection();
		String sql = "select * from payments WHERE customerNumber = ?";
		
		try {
			PreparedStatement stmt = con2.prepareStatement(sql);
			stmt.setInt(1,number);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				return true;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean createPayment(int customerNumber, String checkNumber, String paymentDate, double amount) {
		Connection con = ConexionBD.getConnection();
		String sql = "insert into payments(customerNumber,checkNumber, paymentDate, amount) values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,customerNumber);
			stmt.setString(2,checkNumber);
			stmt.setString(3,paymentDate);
			stmt.setDouble(4, amount);
			
			if (comprobarPayment(customerNumber)==true) {
				ResultSet result = stmt.executeQuery();
			} else {
				System.out.println("Ya existe, no se ha podido crear");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}

	@Override
	public List<Payments> getPayments() {
		Connection con3 = ConexionBD.getConnection();
		
		return null;
	}
	

	
}
