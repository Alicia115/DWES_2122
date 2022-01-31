package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.Employees;

public class DAOImplEmployees implements DAOEmployees {

	@Override
	public Employees getEmployee(int employeeNumber) {
		
		Employees employee = null;

		try {

			String sql = "select * from employees where  employeeNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
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
			ConexionBD.close();
		}

		return employee;
	}

	@Override
	public ArrayList<Employees> getAllEmployee() {
		
		ArrayList<Employees> employeesList = new ArrayList<>();
		
		try {

			String sql = "select * from employees";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employees employee = new Employees();
				
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setExtension(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employeesList.add(employee);
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return employeesList;
	}

	@Override
	public boolean updateEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return false;
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
