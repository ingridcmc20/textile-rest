package com.textile.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.textile.db.conn.ConectionDB;
import com.textile.vo.VOPerfil;

public class PerfilBD {
	public List<VOPerfil> listarPerfiles(Integer id_usuario) {
		String sql = "select p.cod_perfil,p.nombre from victorian.t_perfil p inner join victorian.t_usuarioxperfil up on up.cod_perfil=p.cod_perfil where up.id_usuario=?";
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<VOPerfil> listaPerfiles = null;
		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_usuario);
			resultSet = preparedStatement.executeQuery();
			listaPerfiles = new ArrayList<VOPerfil>();
			while (resultSet.next()) {
				VOPerfil perfil = new VOPerfil();
				perfil.setCod_perfil(resultSet.getInt(1));
				perfil.setNombre(resultSet.getString(2));
				listaPerfiles.add(perfil);
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

		return listaPerfiles;
	}
}
