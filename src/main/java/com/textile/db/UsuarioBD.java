package com.textile.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.textile.db.conn.ConectionDB;
import com.textile.vo.VOUsuario;

public class UsuarioBD {

	public VOUsuario login(VOUsuario vo) {
		String sql = "SELECT id_usuario,nombre,login,id_empresa from victorian.t_usuario where login=? And password=?";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VOUsuario usuario = null;
		
		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, vo.getLogin());
			preparedStatement.setString(2, vo.getPassword());
			resultSet = preparedStatement.executeQuery();
			usuario = new VOUsuario();
			while (resultSet.next()) {
				usuario.setId_usuario(resultSet.getInt(1));
				usuario.setNombre(resultSet.getString(2));
				usuario.setLogin(resultSet.getString(3));
				usuario.setId_empresa(resultSet.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return usuario;
	}

}
