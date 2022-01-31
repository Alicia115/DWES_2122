package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Employees;

public interface DAOEmployees {

	public Employees getEmployee(int employeeNumber);
	public ArrayList<Employees> getAllEmployee();
	public boolean updateEmployee(Employees employee);
	public boolean removeEmployee(int employeeNumber);
	public boolean createEmployee(Employees employee);
}
