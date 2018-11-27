package com.textile.rest.service;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.textile.db.OperarioBD;
import com.textile.db.PerfilBD;
import com.textile.db.UsuarioBD;
import com.textile.vo.VOOperario;
import com.textile.vo.VOPerfil;
import com.textile.vo.VOUsuario;

@Path("/login")
public class ServiceLogin {
	
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public HashMap<String, Object> validaUsuario(VOUsuario vo) {
		UsuarioBD usuarioBD = new UsuarioBD();
		HashMap<String, Object> resultado = new HashMap<String, Object>();
		VOUsuario resUsuario = null;		
		resUsuario = usuarioBD.login(vo);
		
				
		if(resUsuario!=null){
			OperarioBD operarioBD = new OperarioBD();
			PerfilBD perfilBD = new PerfilBD();
			
			VOOperario resOperario = operarioBD.obtenerOperario(resUsuario.getId_usuario());
			List<VOPerfil> resPerfiles = perfilBD.listarPerfiles(resUsuario.getId_usuario());
			
			if(resOperario!=null){
				resUsuario.setPuntaje(resOperario.getPuntaje_acumulado());
			}
			
			if(resPerfiles!=null){
				resUsuario.setListaPerfiles(resPerfiles);
			}
			
			resultado.put("usuario", resUsuario);
			resultado.put("mensaje", "");
			resultado.put("estado", 200);
		}
		else{
			resultado.put("mensaje", "Usuario no existe");
			resultado.put("estado", 400);
		}
		
		return resultado;
	}
}
