package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Offices;

public class DAOOfficesImpl implements DAOOffices{
	
	@Override
	public Offices getOffice(String officeCode) {
		
		Offices office = null;
		Connection con = null;

		try {

			String sql = "select * from offices where officeCode= ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, officeCode);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				office = new Offices();
				
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getNString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return office;
	}

	@Override
	public ArrayList<Offices> getAllOffices() {
		
		ArrayList<Offices> listaOficinas = new ArrayList<>();
		Offices office;
		Connection con = null;
		
		try {

			String sql = "select * from offices";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				office = new Offices();
				
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getNString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));

				listaOficinas.add(office);

			}

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listaOficinas;
	}

	@Override
	public boolean updateOffice(Offices office) {
		
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "update offices set city=?, phone=?, addressLine1=?, addressLine2=?, state=?, country=?, postalCode=?, territory=? where officeCode = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, office.getCity());
			statement.setString(2, office.getPhone());
			statement.setString(3, office.getAddressLine1());
			statement.setString(4, office.getAddressLine2());
			statement.setString(5, office.getState());
			statement.setString(6, office.getCountry());
			statement.setString(7, office.getPostalCode());
			statement.setString(8, office.getTerritory());
			statement.setString(9, office.getOfficeCode());
			
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

	@Override
	public boolean removeOffice(String officeCode) {
		
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "delete from offices where officeCode=? ";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, officeCode);

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

	@Override
	public boolean createOffice(Offices office) {
		
		int resultado = 0;
		Connection con = null;
		
		try {

			String sql = "insert into offices values(?,?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, office.getOfficeCode());
			statement.setString(2, office.getCity());
			statement.setString(3, office.getPhone());
			statement.setString(4, office.getAddressLine1());
			statement.setString(5, office.getAddressLine2());
			statement.setString(6, office.getState());
			statement.setString(7, office.getCountry());
			statement.setString(8, office.getPostalCode());
			statement.setString(9, office.getTerritory());

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
