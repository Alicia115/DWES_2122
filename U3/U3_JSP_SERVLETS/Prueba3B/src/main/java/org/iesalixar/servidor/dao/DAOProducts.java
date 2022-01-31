package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Products;

public interface DAOProducts {
	
	public Products getProduct(String productName);
	public ArrayList<Products> getAllProducts();
	public ArrayList<Products> getProductSearch(String searchTerm);
	public ArrayList<Products> getProductLi(String productLine);
	public boolean removeProduct(String productName);
	public boolean updateProduct(Products product);
	public boolean insertProduct(Products product);

}
