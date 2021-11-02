package DAO_ProductLine;

import java.util.List;

public interface ProductLineDAO {
	
	ProductLine getProductLine (String nombre);
	List<ProductLine> getProductLine();
	void deleteProductLine(String nombre);
	

}
