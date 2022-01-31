package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
	
	public Product getProduct(String productName);
	public ArrayList<Product> getAllProducts();
	public boolean updateProduct(Product product);

}
