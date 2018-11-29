package com.textile.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.textile.db.conn.ConectionDB;
import com.textile.vo.VOOrdenTrabajo;

public class OrdenTrabajoBD {
	public List<VOOrdenTrabajo> findByEtapaYUsuario(Integer etapa, Integer id_usuario) {
		String sql = "SELECT ot.id_ordentrabajo, ot.fecha_registro,cl.nombre_cliente,pr.descripcion as des_tipo_prenda,"+ 
				"tc.descripcion as des_tipo_confeccion, ot.fecha_entrega, p.fecha_entrega fecha_entrega_pedido,"+ 
				"ot.prioridad, ot.id_pedido, ot.id_estado, otd.id_etapa, e.descripcion as des_etapa, "+
				"otd.fecha_fin, otd.fecha_inicio, es.descripcion as des_estado "+
				"FROM victorian.t_orden_trabajo ot " +
				"inner join victorian.t_orden_trabajo_detalle otd on otd.id_ordentrabajo=ot.id_ordentrabajo " +
				"inner join victorian.t_pedido p on p.id_pedido=ot.id_pedido "+
				"inner join victorian.t_cliente cl on cl.id_cliente=p.id_cliente "+
				"inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "+
				"inner join victorian.t_tipo_confeccion tc on tc.id_tipoconfeccion=p.id_tipoconfeccion "+
				"inner join victorian.t_etapa e on e.id_etapa=otd.id_etapa "+
				"inner join victorian.t_estado es on es.id_estado=otd.id_estado "+
				"inner join victorian.t_ordentrabajo_operario oto on oto.id_ordentrabajo=ot.id_ordentrabajo "+
				"inner join victorian.t_operario o on o.id_operario=oto.id_operario "+
				"WHERE	ot.id_estado in (7,8) and otd.id_estado in (7) and otd.id_etapa=? and o.id_usuario=? "+
				"ORDER BY otd.id_etapa desc, ot.fecha_entrega desc";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<VOOrdenTrabajo> listaOrdenesTrabajo = null;
		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, 2);
			preparedStatement.setInt(2, 517);
			resultSet = preparedStatement.executeQuery();
			listaOrdenesTrabajo = new ArrayList<VOOrdenTrabajo>();
			while (resultSet.next()) {
				VOOrdenTrabajo ot = new VOOrdenTrabajo();
				ot.setId_ordentrabajo(resultSet.getInt(1));
				ot.setFecha_registro(resultSet.getDate(2));
				ot.setNombre_cliente(resultSet.getString(3));
				ot.setDes_tipo_prenda(resultSet.getString(4));
				ot.setDes_tipo_confeccion(resultSet.getString(5));
				ot.setFecha_entrega(resultSet.getDate(6));
				ot.setFecha_entrega_pedido(resultSet.getDate(7));
				ot.setPrioridad(resultSet.getInt(8));
				ot.setId_pedido(resultSet.getInt(9));
				ot.setId_estado(resultSet.getInt(10));
				ot.setId_etapa(resultSet.getInt(11));
				ot.setDes_etapa(resultSet.getString(12));
				ot.setFecha_fin(resultSet.getDate(13));
				ot.setFecha_inicio(resultSet.getDate(14));
				ot.setDes_estado(resultSet.getString(15));
				listaOrdenesTrabajo.add(ot);
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

		return listaOrdenesTrabajo;

	}
	
	public void update(VOOrdenTrabajo paramOT) {
		String sql = "UPDATE victorian.t_orden_trabajo SET id_estado=? WHERE id_ordentrabajo=?";
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, paramOT.getId_estado());
			preparedStatement.setInt(2, paramOT.getId_ordentrabajo());
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
