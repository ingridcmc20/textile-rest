package com.textile.vo;

import java.util.List;

public class VOUsuario {
	private Integer id_usuario;
	private String login;
	private String password;
	private String nombre;
	private Integer puntaje;
	private Integer id_empresa;
	private Integer id_perfil_sel;
	private List<VOPerfil> listaPerfiles;

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public List<VOPerfil> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<VOPerfil> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getId_perfil_sel() {
		return id_perfil_sel;
	}

	public void setId_perfil_sel(Integer id_perfil_sel) {
		this.id_perfil_sel = id_perfil_sel;
	}

}
