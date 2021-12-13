package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employees;

public class DAOEmployeesImpl implements DAOEmployees{
	
	@Override
	public Employees getEmployee(int employeeNumber) {
		
		Employees employee = null;
		Connection con = null;
		
		try {

			String sql = "select * from employees where  employeeNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, employeeNumber);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				employee = new Employees();
				
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setExtension(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));

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

		return employee;
	}

	@Override
	public ArrayList<Employees> getAllEmployee() {
		
		ArrayList<Employees> employeesList = new ArrayList<>();
		Connection con = null;
		
		try {

			String sql = "select * from employees";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employees employee = new Employees();
				
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employeesList.add(employee);
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

		return employeesList;
	}

	@Override
	public boolean updateEmployee(Employees employee) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "update employees set lastName=?, firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=? where employeeNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, employee.getLastName());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getExtension());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getOfficeCode());
			statement.setInt(6, employee.getReportsTo());
			statement.setString(7, employee.getJobTitle());
			statement.setInt(8, employee.getEmployeeNumber());
			
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
	public boolean removeEmployee(int employeeNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return false;
	}


}
