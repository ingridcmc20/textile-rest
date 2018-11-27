package com.textile.vo;

import java.sql.Date;

public class VOOrdenTrabajo {
	private Integer id_ordentrabajo;
	private Integer id_pedido;
	private Date fecha_registro;
	private Date fecha_entrega;
	private Date fecha_entrega_pedido;
	private Integer id_estado;
	private Integer id_etapa;

	// Columnas adicionales
	private String nombre_cliente;
	private String des_tipo_prenda;
	private String des_tipo_confeccion;
	private Integer prioridad;
	private String des_etapa;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String des_estado;

	VOUsuario paramUsuario;

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Integer getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		this.id_etapa = id_etapa;
	}

	public String getDes_etapa() {
		return des_etapa;
	}

	public void setDes_etapa(String des_etapa) {
		this.des_etapa = des_etapa;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDes_tipo_prenda() {
		return des_tipo_prenda;
	}

	public void setDes_tipo_prenda(String des_tipo_prenda) {
		this.des_tipo_prenda = des_tipo_prenda;
	}

	public String getDes_tipo_confeccion() {
		return des_tipo_confeccion;
	}

	public void setDes_tipo_confeccion(String des_tipo_confeccion) {
		this.des_tipo_confeccion = des_tipo_confeccion;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Date getFecha_entrega_pedido() {
		return fecha_entrega_pedido;
	}

	public void setFecha_entrega_pedido(Date fecha_entrega_pedido) {
		this.fecha_entrega_pedido = fecha_entrega_pedido;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public Integer getId_ordentrabajo() {
		return id_ordentrabajo;
	}

	public void setId_ordentrabajo(Integer id_ordentrabajo) {
		this.id_ordentrabajo = id_ordentrabajo;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public String getDes_estado() {
		return des_estado;
	}

	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}

	public VOUsuario getParamUsuario() {
		return paramUsuario;
	}

	public void setParamUsuario(VOUsuario paramUsuario) {
		this.paramUsuario = paramUsuario;
	}

}