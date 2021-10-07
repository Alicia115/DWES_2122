package daoproductlines;

import java.util.List;

public interface ProductLineDao {
	
	ProductLines getProductLine(String name);
	List<ProductLines> getProductLines();
	void deleteProductLines (String name);
	

}
