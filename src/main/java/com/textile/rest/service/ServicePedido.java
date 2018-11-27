package com.textile.rest.service;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.textile.db.PedidoBD;
import com.textile.vo.VOPedido;
import com.textile.vo.VOUsuario;

@Path("/pedido")
public class ServicePedido {
	
	@POST
	@Path("/listaPedidoXCliente")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public HashMap<String, Object> obtenerListaPedidosPorCliente(VOUsuario vo) {
		PedidoBD pedidoBD = new PedidoBD();
		HashMap<String, Object> resultado = new HashMap<String, Object>();
		List<VOPedido> resPedido = pedidoBD.listarPedidosPorCliente(vo.getId_empresa());
		if(resPedido!=null){
			resultado.put("pedidos", resPedido);
			resultado.put("mensaje", "");
			resultado.put("estado", 200);
		}
		else{
			resultado.put("mensaje", "No existen pedidos");
			resultado.put("estado", 400);
		}
		return resultado;
	}
}
