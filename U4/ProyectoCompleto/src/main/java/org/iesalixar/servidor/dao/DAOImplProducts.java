package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Products;

public class DAOImplProducts implements DAOProducts {

	@Override
	public Products getProduct(String productName) {
		
		Products product = null;

		try {

			String sql = "select * from products where  productName=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productName);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Products();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return product;

	}

	@Override
	public ArrayList<Products> getProductSearch(String searchTerm) {
		
		ArrayList<Products> products = new ArrayList<Products>();
		Products product = null;

		try {

			String sql = "select * from products where  productName LIKE ? OR productLine LIKE ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, "%"+searchTerm+"%");
			statement.setString(2, "%"+searchTerm+"%");
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Products();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));
				
				products.add(product);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return products;
	}

	@Override
	public boolean removeProduct(String productName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Products product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertProduct(Products product) {
		// TODO Auto-generated method stub
		return false;
	}

}
