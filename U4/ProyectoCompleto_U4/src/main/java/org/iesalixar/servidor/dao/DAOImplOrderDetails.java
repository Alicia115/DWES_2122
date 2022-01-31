package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.OrderDetails;

public class DAOImplOrderDetails implements DAOOrderDetails{

	@Override
	public OrderDetails getOrderDetail(int orderNumber, String productCode) {
		
		OrderDetails orderDetail = null;

		try {

			String sql = "select * from orderdetails where orderNumber=? and productCode=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, orderNumber);
			statement.setString(2, productCode);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				orderDetail = new OrderDetails();
				
				orderDetail.setOrderNumber(rs.getInt("orderNumber"));
				orderDetail.setProductCode(rs.getString("productCode"));
				orderDetail.setQuantityOrdered(rs.getInt("quantityOrdered"));
				orderDetail.setPriceEach(rs.getDouble("priceEach"));
				orderDetail.setOrderLineNumber(rs.getInt("orderLineNumber"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return orderDetail;
	}

	@Override
	public ArrayList<OrderDetails> getAllOrderDetails() {
		
		ArrayList<OrderDetails> orderDetailList = new ArrayList<>();
		
		try {

			String sql = "select * from orderdetails";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				OrderDetails orderDetail = new OrderDetails();
				
				orderDetail.setOrderNumber(rs.getInt("orderNumber"));
				orderDetail.setProductCode(rs.getString("productCode"));
				orderDetail.setQuantityOrdered(rs.getInt("quantityOrdered"));
				orderDetail.setPriceEach(rs.getDouble("priceEach"));
				orderDetail.setOrderLineNumber(rs.getInt("orderLineNumber"));
				
				orderDetailList.add(orderDetail);
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return orderDetailList;
	}

	@Override
	public boolean updateOrderDetail(OrderDetails office) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeOrderDetail(int orderNumber, String productCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createOrderDetail(OrderDetails office) {
		// TODO Auto-generated method stub
		return false;
	}

}
