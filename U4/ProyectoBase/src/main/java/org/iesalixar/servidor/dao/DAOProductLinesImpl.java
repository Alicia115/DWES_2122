package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.ProductLines;

public class DAOProductLinesImpl implements DAOProductLines{
	
	@Override
	public ProductLines getProductLine(String productLine) {

		ProductLines categoria = null;
		Connection con = null;
		
		try {

			String sql = "select * from productlines where productLine = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productLine);
			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de productLine
			while (rs.next()) {

				categoria = new ProductLines();

				categoria.setProductLine(rs.getString("productLine"));
				categoria.setTextDescription(rs.getString("textDescription"));
				categoria.setHtmlDescription(rs.getString("htmlDescription"));

			}

			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return categoria;
	}

	@Override
	public ArrayList<ProductLines> getAll() {
		
		ArrayList<ProductLines> categoriasList = new ArrayList<>();
		ProductLines categoria;
		Connection con = null;

		try {

			String sql = "select * from productlines";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				categoria = new ProductLines();
				categoria.setProductLine(rs.getString("productLine"));
				categoria.setTextDescription(rs.getString("textDescription"));
				categoria.setHtmlDescription(rs.getString("htmlDescription"));

				categoriasList.add(categoria);

			}

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return categoriasList;
	}

	@Override
	public boolean updateProductLine(ProductLines productLine) {
		
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "update productlines set productLine=?, textDescription=?, htmlDescription=? where productLine = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productLine.getProductLine());
			statement.setString(2, productLine.getTextDescription());
			statement.setString(3, productLine.getHtmlDescription());
			statement.setString(4, productLine.getProductLine());

			resultado = statement.executeUpdate(sql);


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean removeProductLine(String productLine) {
		
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "delete from productlines where productLine = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productLine);

			resultado = statement.executeUpdate(sql);

			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean createProductLine(ProductLines productLine) {
		
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "insert into productlines values(?,?,?,null)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productLine.getProductLine());
			statement.setString(2, productLine.getTextDescription());
			statement.setString(3, productLine.getHtmlDescription());

			resultado = statement.executeUpdate();

			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}


}
