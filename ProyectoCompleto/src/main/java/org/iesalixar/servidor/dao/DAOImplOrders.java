package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.OrderDetails;
import org.iesalixar.servidor.model.Orders;

public class DAOImplOrders implements DAOOrders{

	@Override
	public Orders getOrder(int orderNumber) {
		
		Orders order = null;

		try {

			String sql = "select * from orders where orderNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, orderNumber);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				order = new Orders();
				
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getNString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return order;
	}

	@Override
	public ArrayList<Orders> getAllOrders() {
		
		ArrayList<Orders> orderList = new ArrayList<>();
		
		try {

			String sql = "select * from orders";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Orders order = new Orders();
				
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getNString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
				
				orderList.add(order);
			
			}

			ConexionBD.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return orderList;
	}

	@Override
	public boolean updateOrder(Orders order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeOrder(int orderNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createOrder(Orders order) {
		// TODO Auto-generated method stub
		return false;
	}

}
