package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario{
	
	@Override
	public Usuario getUsuario(String nombre) {
		
		Usuario usuario = null;
		Connection con = null;

		try {

			String sql = "select * from usuarios where email=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, nombre);
			

			ResultSet rs = statement.executeQuery();

		
			while (rs.next()) {

				usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRole(rs.getString("rol"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));

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

		return usuario;
	}

	@Override
	public boolean registerUsuario(Usuario usuario) {
		
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "insert into usuarios values(?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getFirstName());
			statement.setString(3, usuario.getLastName());
			statement.setString(4, usuario.getPassword());
			statement.setString(5, usuario.getEmail());
			statement.setString(6, usuario.getRol());

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
