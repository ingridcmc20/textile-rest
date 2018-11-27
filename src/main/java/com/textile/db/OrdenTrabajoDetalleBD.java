package com.textile.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.textile.db.conn.ConectionDB;
import com.textile.vo.VOOrdenTrabajo;
import com.textile.vo.VOrdenTrabajoDetalle;

public class OrdenTrabajoDetalleBD {

	public VOrdenTrabajoDetalle findByIdOrdenByEstapa(VOOrdenTrabajo paramOTD) {
		String sql = "SELECT id_ordentrabajo, id_etapa, fecha_fin, fecha_inicio, fecha_real_fin "
				+ "FROM victorian.t_orden_trabajo_detalle " + "where id_ordentrabajo=? and id_etapa=?";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VOrdenTrabajoDetalle otd = null;

		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, paramOTD.getId_ordentrabajo());
			preparedStatement.setInt(2, paramOTD.getId_etapa());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				otd = new VOrdenTrabajoDetalle();
				otd.setId_ordentrabajo(resultSet.getInt(1));
				otd.setId_etapa(resultSet.getInt(2));
				otd.setFecha_fin(resultSet.getDate(3));
				otd.setFecha_inicio(resultSet.getDate(4));
				otd.setFecha_real_fin(resultSet.getDate(5));
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

		return otd;
	}

	public void update(VOrdenTrabajoDetalle paramOTD) {
		String sql = "UPDATE victorian.t_orden_trabajo_detalle SET fecha_real_fin=?, id_estado=? WHERE id_ordentrabajo=? and id_etapa=?";
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setDate(1, paramOTD.getFecha_real_fin());
			preparedStatement.setInt(2, paramOTD.getId_estado());
			preparedStatement.setInt(3, paramOTD.getId_ordentrabajo());
			preparedStatement.setInt(4, paramOTD.getId_etapa());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
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
	}

}
