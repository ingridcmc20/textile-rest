package com.textile.vo;

import java.sql.Date;

public class VOPedido {
	private Integer id_pedido;
	private String des_tipo_prenda;
	private Integer cantidad_prenda;
	private Date fecha_entrega;
	private String des_estado;

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getDes_tipo_prenda() {
		return des_tipo_prenda;
	}

	public void setDes_tipo_prenda(String des_tipo_prenda) {
		this.des_tipo_prenda = des_tipo_prenda;
	}

	public Integer getCantidad_prenda() {
		return cantidad_prenda;
	}

	public void setCantidad_prenda(Integer cantidad_prenda) {
		this.cantidad_prenda = cantidad_prenda;
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
}