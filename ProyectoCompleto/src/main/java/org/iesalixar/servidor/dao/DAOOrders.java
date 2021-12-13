package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Orders;

public interface DAOOrders {
	
	public Orders getOrder(int orderNumber);
	public ArrayList<Orders> getAllOrders();
	public boolean updateOrder(Orders order);
	public boolean removeOrder(int orderNumber);
	public boolean createOrder(Orders order);

}
