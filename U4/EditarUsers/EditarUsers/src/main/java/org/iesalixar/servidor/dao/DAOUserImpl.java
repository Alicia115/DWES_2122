package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.User;

public class DAOUserImpl implements DAOUser {

	@Override
	public User getUser(String usuario) {

		User user = null;

		try {

			String sql = "select * from users where usuario=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, usuario);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				user = new User();

				user.setUsuario(rs.getString("usuario"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setRol(rs.getString("rol"));
			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return user;
	}

	@Override
	public boolean removeUser(String usuario) {

		int resultado = 0;

		try {

			String sql = "delete from users where usuario=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, usuario);

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean updateUser(User user) {
		
		int resultado=0;

		try {

			String sql = "update users set password=? , email=?, rol=? where usuario = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getRol());
			statement.setString(4, user.getUsuario());

			resultado = statement.executeUpdate();

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean insertUser(User user) {

		int resultado = 0;
		
		try {
			
			String sql = "insert into users (usuario, password, email) values (?,?,?)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, user.getUsuario());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			
			resultado = statement.executeUpdate();
			
			ConexionBD.close();
			
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (resultado==0?false:true);
	}

	

	@Override
	public boolean comprobacionUser(String usuario, String password) {
		try {
			
			String sql = "select * from users where usuario=? and password=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, usuario);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()){
				
				return true;
			}
			
			
			ConexionBD.close();
			return false;
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	
}
