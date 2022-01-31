package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Offices;

public interface DAOOffices {

	public Offices getOffice(String officeCode);
	public ArrayList<Offices> getAllOffices();
	public boolean updateOffice(Offices office);
	public boolean removeOffice(String officeCode);
	public boolean createOffice(Offices office);
}
