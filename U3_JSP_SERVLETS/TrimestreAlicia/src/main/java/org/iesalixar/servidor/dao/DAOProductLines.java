package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.ProductLines;

public interface DAOProductLines {
	
	public ProductLines getProductLine(String productLine);
	public ArrayList<ProductLines> getAll();
	public boolean updateProductLine(ProductLines productLine);
	public boolean removeProductLine(String productLine);
	public boolean createProductLine(ProductLines productLine);

}
