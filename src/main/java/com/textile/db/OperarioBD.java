package com.textile.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.textile.db.conn.ConectionDB;
import com.textile.vo.VOOperario;

public class OperarioBD { 
	public VOOperario obtenerOperario(Integer id_usuario) {
		String sql = "select id_operario,id_tipooperario,puntaje_acumulado,id_usuario,activo from victorian.t_operario where id_usuario=?";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VOOperario operario = null;
		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_usuario);
			resultSet = preparedStatement.executeQuery();
			operario = new VOOperario();
			while (resultSet.next()) {
				operario.setId_operario(resultSet.getInt(1));
				operario.setId_tipooperario(resultSet.getInt(2));
				operario.setPuntaje_acumulado(resultSet.getInt(3));
				operario.setId_usuario(resultSet.getInt(4));
				operario.setActivo(resultSet.getBoolean(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

		return operario;
	}
}
