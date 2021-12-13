package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.OrderDetails;

public class DAOOrderDetailsImpl implements DAOOrderDetails{
	@Override
	public OrderDetails getOrderDetail(int orderNumber, String productCode) {
		
		OrderDetails orderDetail = null;
		Connection con = null;

		try {

			String sql = "select * from orderdetails where orderNumber=? and productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
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
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return orderDetail;
	}

	@Override
	public ArrayList<OrderDetails> getAllOrderDetails() {
		
		ArrayList<OrderDetails> orderDetailList = new ArrayList<>();
		Connection con = null;
		
		try {

			String sql = "select * from orderdetails";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

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

		return orderDetailList;
	}

	@Override
	public boolean updateOrderDetail(OrderDetails office) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "update orderdetails set quantityOrdered= ?, priceEach=?, orderLineNumber=? where orderNumber = ? and productCode = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, office.getQuantityOrdered());
			statement.setDouble(2, office.getPriceEach());
			statement.setInt(3, office.getOrderLineNumber());
			statement.setInt(4, office.getOrderNumber());
			statement.setString(5, office.getProductCode());

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
