package DAO_ProductLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductLineImplement implements ProductLineDAO {

	public ProductLine getProductLine(String nombre) {
		Connection con = Conector.getConnection();
		String sql = "select * from productslines WHERE productLine= ?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			System.out.println("Ha entrado");
			stmt.setString(1,nombre);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				System.out.println("Hay una linea de producto");
				String productLine = result.getString("productLine");
				return new ProductLine(productLine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<ProductLine> getProductLine() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProductLine(String nombre) {
		// TODO Auto-generated method stub
		
	}

}
