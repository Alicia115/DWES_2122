package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.Products;

public class DAOImplCustomers implements DAOCustomers{

	@Override
	public Customers getCustomer(int customerNumber) {
		
		Customers customer = null;

		try {

			String sql = "select * from customers where customerNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, customerNumber);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				customer = new Customers();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return customer;
	}

	@Override
	public ArrayList<Customers> getAllCustomers() {
		
		ArrayList<Customers> customerList = new ArrayList<>();
		
		try {

			String sql = "select * from customers";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Customers customer = new Customers();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));
				
				customerList.add(customer);
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return customerList;
	}

	@Override
	public boolean updateCustomer(Customers customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCustomer(int customerNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createCustomer(Customers customer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
