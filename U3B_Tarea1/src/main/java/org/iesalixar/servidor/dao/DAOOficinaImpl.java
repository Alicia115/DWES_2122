package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Oficina;
import org.iesalixar.servidor.model.Product;

public class DAOOficinaImpl implements DAOOffice {

	@Override
	public Oficina getOficina(String nombre) {
		
		Oficina oficina = null;

		try {

			String sql = "select * from offices where  officeCode=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, nombre);
			

			ResultSet rs = statement.executeQuery();

		
			while (rs.next()) {

				oficina = new Oficina();
				oficina.setOfficeCode(rs.getNString("officeCode"));
				oficina.setCity(rs.getNString("city"));
				oficina.setPhone(rs.getNString("phone"));
				oficina.setAddressLine1("addressLine1");
				oficina.setAddressLine2("addressLine2");
				oficina.setState(rs.getNString("state"));
				oficina.setCountry(rs.getNString("country"));
				oficina.setPostalCode(rs.getNString("postalCode"));
				oficina.setTerritory(rs.getNString("territory"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return oficina;
		
		
	}

	@Override
	public ArrayList<Oficina> getOficinaSearch(String searchTerm) {
		ArrayList<Oficina> oficinas = new ArrayList<Oficina>();
		Oficina oficina = null;

		try {

			String sql = "select * from offices";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			
			while (rs.next()) {

				oficina = new Oficina();
				
				oficina.setOfficeCode(rs.getNString("officeCode"));
				oficina.setCity(rs.getNString("city"));
				oficina.setPhone(rs.getNString("phone"));
				oficina.setAddressLine1("addressLine1");
				oficina.setAddressLine2("addressLine2");
				oficina.setState(rs.getNString("state"));
				oficina.setCountry(rs.getNString("country"));
				oficina.setPostalCode(rs.getNString("postalCode"));
				oficina.setTerritory(rs.getNString("territory"));
				
				oficinas.add(oficina);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return oficinas;

	}

}
