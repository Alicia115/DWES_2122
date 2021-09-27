package BDSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	
	private static Connection con = null;
	
	private static final String conUrl = "jdbc:mariadb://localhost:3336/classicmodels?user=root&password=1234"
			+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection getConnection () {
		
		try {

			if (con == null) {
				con = DriverManager.getConnection(ConexionBD.conUrl);

				System.out.println("Conexión realizada correctamente");
			}

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
		return con;
		
	}
	
	public static void close() {
		
		if (con!=null) {
			try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	

}
