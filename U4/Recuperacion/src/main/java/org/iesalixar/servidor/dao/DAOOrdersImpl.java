package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Orders;

public class DAOOrdersImpl implements DAOOrders{
	
	@Override
	public Orders getOrder(int orderNumber) {
		
		Orders order = null;
		Connection con = null;

		try {

			String sql = "select * from orders where orderNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
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
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return order;
	}

	@Override
	public ArrayList<Orders> getAllOrders() {
		
		ArrayList<Orders> orderList = new ArrayList<>();
		Connection con = null;
		
		try {

			String sql = "select * from orders";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

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

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return orderList;
	}

	@Override
	public boolean updateOrder(Orders order) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "update orders set orderDate= ?, requiredDate=?, shippedDate=?, status=?, comments=?, customerNumber=? where orderNumber = ? ";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, order.getOrderDate());
			statement.setString(2, order.getRequiredDate());
			statement.setString(3, order.getShippedDate());
			statement.setString(4, order.getStatus());
			statement.setString(5, order.getComments());
			statement.setInt(6, order.getCustomerNumber());
			statement.setInt(7, order.getOrderNumber());
			
			resultado = statement.executeUpdate();


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean removeOrder(int orderNumber) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "delete from orders where orderNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, orderNumber);

			resultado = statement.executeUpdate(sql);

			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean createOrder(Orders order) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "insert into orders values(?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(2, order.getOrderDate());
			statement.setString(3, order.getRequiredDate());
			statement.setString(4, order.getShippedDate());
			statement.setString(5, order.getStatus());
			statement.setString(6, order.getComments());
			statement.setInt(7, order.getCustomerNumber());
			statement.setInt(1, order.getOrderNumber());

			resultado = statement.executeUpdate();


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}

}

