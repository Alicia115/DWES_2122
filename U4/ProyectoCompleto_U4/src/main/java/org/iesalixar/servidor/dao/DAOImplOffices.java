package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Offices;
import org.iesalixar.servidor.model.Payments;
import org.iesalixar.servidor.model.ProductLines;

public class DAOImplOffices implements DAOOffices{

	@Override
	public Offices getOffice(String officeCode) {
		
		Offices office = null;

		try {

			String sql = "select * from offices where officeCode= ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
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

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return office;
	}

	@Override
	public ArrayList<Offices> getAllOffices() {
		
		ArrayList<Offices> listaOficinas = new ArrayList<>();
		Offices office;

		try {

			String sql = "select * from offices";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
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

			ConexionBD.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listaOficinas;
	}

	@Override
	public boolean updateOffice(Offices office) {
		
		int resultado = 0;

		try {

			String sql = "update offices set city=?, phone=?, addressLine1=?, addressLine2=?, state=?, country=?, postalCode=?, territory=? where officeCode = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, office.getCity());
			statement.setString(2, office.getPhone());
			statement.setString(3, office.getAddressLine1());
			statement.setString(4, office.getAddressLine2());
			statement.setString(5, office.getState());
			statement.setString(6, office.getCountry());
			statement.setString(7, office.getPostalCode());
			statement.setString(8, office.getTerritory());
			
			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean removeOffice(String officeCode) {
		
		int resultado = 0;

		try {

			String sql = "delete from offices where officeCode=? ";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, officeCode);

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean createOffice(Offices office) {
		
		int resultado = 0;

		try {

			String sql = "insert into offices values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
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

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

}
