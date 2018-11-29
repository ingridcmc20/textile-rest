package com.textile.rest.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.textile.db.OrdenTrabajoBD;
import com.textile.db.OrdenTrabajoDetalleBD;
import com.textile.db.commons.Constante;
import com.textile.vo.VOOrdenTrabajo;
import com.textile.vo.VOUsuario;
import com.textile.vo.VOrdenTrabajoDetalle;

@Path("/ot")
public class ServiceOrdenTrabajo {

	@POST
	@Path("/listaOTXUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public HashMap<String, Object> obtenerListaOrdenTrabajo(VOUsuario paramUsuario) {
		List<VOOrdenTrabajo> listaOrdenTrabajo = null;
		HashMap<String, Object> resultado = new HashMap<String, Object>();
		OrdenTrabajoBD ordenTrabajoBD = new OrdenTrabajoBD();
		int etapa = -1;
		if (paramUsuario.getId_perfil_sel().intValue() == (Constante.PERFIL_USUARIO_DISENIADOR.intValue())) {
			etapa = Constante.OT_ETAPA_DISENIO;
		} else if (paramUsuario.getId_perfil_sel().intValue() == (Constante.PERFIL_USUARIO_CORTADOR.intValue())) {
			etapa = Constante.OT_ETAPA_CORTE;
		} else if (paramUsuario.getId_perfil_sel().intValue() == (Constante.PERFIL_USUARIO_CONFECCIONISTA.intValue())) {
			etapa = Constante.OT_ETAPA_CONFECCION;
		} else if (paramUsuario.getId_perfil_sel().intValue() == (Constante.PERFIL_USUARIO_EMPAQUETADOR.intValue())) {
			etapa = Constante.OT_ETAPA_EMPAQUETADO;
		}

		if (etapa != -1) {
			System.out.println(etapa);
			System.out.println(paramUsuario.getId_usuario());
			listaOrdenTrabajo = ordenTrabajoBD.findByEtapaYUsuario(etapa, paramUsuario.getId_usuario());
		}

		if (listaOrdenTrabajo != null) {
			resultado.put("ordenesTrabajo", listaOrdenTrabajo);
			resultado.put("mensaje", "");
			resultado.put("estado", 200);
		} else {
			resultado.put("mensaje", "No existen pedidos");
			resultado.put("estado", 400);
		}
		return resultado;
	}

	@POST
	@Path("/terminarOT")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public HashMap<String, Object> terminar(VOOrdenTrabajo paramOT) {
		HashMap<String, Object> resultado = new HashMap<String, Object>();
		Date fechaActual = new Date();
		System.out.println("terminar");
		String estadoRes = null;
		String mensaje = "";
		OrdenTrabajoDetalleBD ordenTrabajoDetalleBD = new OrdenTrabajoDetalleBD();
		OrdenTrabajoBD ordenTrabajoBD = new OrdenTrabajoBD();

		try {
			VOrdenTrabajoDetalle otd = ordenTrabajoDetalleBD.findByIdOrdenByEstapa(paramOT);

			if (otd != null) {
				otd.setFecha_real_fin(new java.sql.Date((fechaActual).getTime()));
				if(paramOT.getId_etapa() == 2 || paramOT.getId_etapa() == 3){
					otd.setId_estado(Constante.OT_POR_APROBAR);	
				}
				else if(paramOT.getId_etapa() == 1){
					otd.setId_estado(Constante.OT_TERMINADO);
					paramOT.setId_estado(Constante.OT_EN_CURSO);
					ordenTrabajoBD.update(paramOT);
				}
				else{
					otd.setId_estado(Constante.OT_TERMINADO);
					paramOT.setId_estado(Constante.OT_TERMINADO);
					ordenTrabajoBD.update(paramOT);
				}
				
				ordenTrabajoDetalleBD.update(otd);
				estadoRes = "200";
				mensaje = "Orden de trabajo pendiente de aprobacion";
			} else {
				estadoRes = "400";
				mensaje = "No se encontro la orden de trabajo solicitada";
			}

			resultado.put("mensaje", mensaje);
			resultado.put("estado", estadoRes);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
}
