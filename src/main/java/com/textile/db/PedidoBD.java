package com.textile.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.textile.db.conn.ConectionDB;
import com.textile.vo.VOPedido;

public class PedidoBD {
	public List<VOPedido> listarPedidosPorCliente(Integer id_cliente) {
		String sql = "select p.id_pedido,pr.descripcion as des_tipo_prenda,p.cantidad_prenda,p.fecha_entrega,e.descripcion as des_estado, p.id_cliente from victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda inner join victorian.t_estado e on e.id_estado=p.id_estado where id_cliente=?";

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<VOPedido> listaPedidos = null;
		try {
			conn = ConectionDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_cliente);
			resultSet = preparedStatement.executeQuery();
			listaPedidos = new ArrayList<VOPedido>();
			while (resultSet.next()) {
				VOPedido pedido = new VOPedido();
				pedido.setId_pedido(resultSet.getInt(1));
				pedido.setDes_tipo_prenda(resultSet.getString(2));
				pedido.setCantidad_prenda(resultSet.getInt(3));
				pedido.setFecha_entrega(resultSet.getDate(4));
				pedido.setDes_estado(resultSet.getString(5));
				listaPedidos.add(pedido);
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

		return listaPedidos;
	}
}
