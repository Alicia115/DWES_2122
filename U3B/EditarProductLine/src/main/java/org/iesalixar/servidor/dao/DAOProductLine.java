package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.ProductLine;


public interface DAOProductLine {
	
	public List<ProductLine> getAllProductLines();
	public ProductLine getProductLine(String productLine);
	public boolean removeProductLine(String productLine);
	public boolean updateProductLine(ProductLine product);
	public boolean insertProductLine(ProductLine product);

}
