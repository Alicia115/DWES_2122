package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.ProductLine;

public class DAOProductLineImpl implements DAOProductLine {

	@Override
	public List<ProductLine> getAllProductLines() {
		
		ArrayList<ProductLine> productsList = new ArrayList<>();
		
		try {
			
			String sql = "select * from productlines";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				ProductLine productLine = new ProductLine();
				
				productLine.setProductLine(rs.getString("productLine"));
				productLine.setTextDescription(rs.getString("textDescription"));
				productLine.setHtmlDescription(rs.getString("htmlDescription"));
				
				productsList.add(productLine);
			}
			
			ConexionBD.close();
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return productsList;
	}

	@Override
	public ProductLine getProductLine(String productLine) {
		
		ProductLine product = null; 
		
		try {
			
			String sql = "select * from productlines where productLine= ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				product = new ProductLine();
				
				product.setProductLine(rs.getString("productLine"));
				product.setTextDescription(rs.getString("textDescription"));
				product.setHtmlDescription(rs.getString("htmlDescription"));
			}
			
			ConexionBD.close();
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		
		return product;
	}

	@Override
	public boolean removeProductLine(String productLine) {
		
		int resultado = 0;
		
		try {
			
			String sql = "delete from productlines where productLine= ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine);
			
			resultado = statement.executeUpdate();
			
			ConexionBD.close();
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return (resultado==0?false:true) ;
	}

	@Override
	public boolean updateProductLine(ProductLine product) {
		
		int resultado = 0;
		
		try {
			
			String sql = "update productlines set textDescription=? , htmlDescription=? where productLine= ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, product.getTextDescription());
			statement.setString(2, product.getHtmlDescription());
			statement.setString(3, product.getProductLine());
			
			resultado = statement.executeUpdate();
			
			ConexionBD.close();
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (resultado==0?false:true);
	}

	@Override
	public boolean insertProductLine(ProductLine product) {
		
		int resultado = 0;
		
		try {
			
			String sql = "insert into productlines values (?,?,?,null)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(2, product.getTextDescription());
			statement.setString(3, product.getHtmlDescription());
			statement.setString(1, product.getProductLine());
			
			resultado = statement.executeUpdate();
			
			ConexionBD.close();
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (resultado==0?false:true);
	}
	
	

}
