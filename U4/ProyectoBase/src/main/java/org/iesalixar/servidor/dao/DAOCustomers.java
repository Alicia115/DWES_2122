package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Customers;

public interface DAOCustomers {
	
	public Customers getCustomer(int customerNumber);
	public ArrayList<Customers> getAllCustomers();
	public boolean updateCustomer(Customers customer);
	public boolean removeCustomer(int customerNumber);
	public boolean createCustomer(Customers customer);

}
