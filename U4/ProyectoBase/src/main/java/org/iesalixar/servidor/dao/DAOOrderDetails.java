package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.OrderDetails;

public interface DAOOrderDetails {
	public OrderDetails getOrderDetail(int orderNumber, String productCode);
	public ArrayList<OrderDetails> getAllOrderDetails();
	public boolean updateOrderDetail(OrderDetails office);
	public boolean removeOrderDetail(int orderNumber, String productCode);
	public boolean createOrderDetail(OrderDetails office);
}
