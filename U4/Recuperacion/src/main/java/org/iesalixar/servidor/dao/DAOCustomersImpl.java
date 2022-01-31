package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Customers;

public class DAOCustomersImpl implements DAOCustomers{
	
	@Override
	public Customers getCustomer(int customerNumber) {
		
		Customers customer = null;
		Connection con = null;

		try {

			String sql = "select * from customers where customerNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
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
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return customer;
	}

	@Override
	public ArrayList<Customers> getAllCustomers() {
		
		ArrayList<Customers> customerList = new ArrayList<>();
		
		Connection con = null;
		
		try {

			String sql = "select * from customers";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

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

		return customerList;
	}

	@Override
	public boolean updateCustomer(Customers customer) {
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "update customers set customerName= ?, contactFirstName=?, contactLastName=?, phone=?, addressLine1=?, addressLine2=?, city=?, state=?, postalCode=?, country=? , salesRepEmployeeNumber=?, creditLimit=? where customerNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(13,customer.getCustomerNumber());
			statement.setString(1,customer.getCustomerName());
			statement.setString(2,customer.getContactFirstName());
			statement.setString(3,customer.getContactLastName());
			statement.setString(4,customer.getPhone());
			statement.setString(5,customer.getAddressLine1());
			statement.setString(6,customer.getAddressLine2());
			statement.setString(7,customer.getCity());
			statement.setString(8,customer.getState());
			statement.setString(9,customer.getPostalCode());
			statement.setString(10,customer.getCountry());
			statement.setInt(11,customer.getSalesRepEmployeeNumber());
			statement.setDouble(12, customer.getCreditLimit());
		
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

		return (resultado==0?false:true);
	}

	@Override
	public boolean removeCustomer(int customerNumber) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "delete from customers where customerNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerNumber);

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
	public boolean createCustomer(Customers customer) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "insert into customers values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1,customer.getCustomerNumber());
			statement.setString(2,customer.getCustomerName());
			statement.setString(3,customer.getContactFirstName());
			statement.setString(4,customer.getContactLastName());
			statement.setString(5,customer.getPhone());
			statement.setString(6,customer.getAddressLine1());
			statement.setString(7,customer.getAddressLine2());
			statement.setString(8,customer.getCity());
			statement.setString(9,customer.getState());
			statement.setString(10,customer.getPostalCode());
			statement.setString(11,customer.getCountry());
			statement.setInt(12,customer.getSalesRepEmployeeNumber());
			statement.setDouble(13, customer.getCreditLimit());

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
	public boolean updateEmployeeCustomer(int customerNumber, int employee) {
		
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "update customers set salesRepEmployeeNumber=? where customerNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(2,customerNumber);
			statement.setInt(1,employee);
		
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

		return (resultado==0?false:true);
	}
	


}
