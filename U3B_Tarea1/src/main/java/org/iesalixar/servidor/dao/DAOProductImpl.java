package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public Product getProduct(String productName) {
		
		Product product = null;

		try {

			String sql = "select * from products where  productName=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productName);
			

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();
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
	public ArrayList<Product> getAllProducts() {
		
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;

		try {

			String sql = "select * from products";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

		
			while (rs.next()) {

				product = new Product();
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
	public boolean updateProduct(Product product) {
		
		int resultado=0;
		
		try {

			String sql = "update products set productCode= ?, productLine=?, productScale=?, productVendor=?, productDescription=?, quantityInStock=?, buyPrice=?, msrp=? where productName = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1,product.getProductCode());
			statement.setString(2,product.getProductLine());
			statement.setString(3,product.getProductScale());
			statement.setString(4,product.getProductVendor());
			statement.setString(5,product.getProductDescription());
			statement.setInt(6, product.getQuantityInStock());
			statement.setDouble(7, product.getBuyPrice());
			statement.setDouble(8, product.getMsrp());
			
			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
	}

}
