package com.textile.vo;

import java.sql.Date;

public class VOrdenTrabajoDetalle {
	private Integer id_ordentrabajo;
	private Integer id_etapa;
	private Integer id_plan_produccion;
	private Date fecha_fin;
	private Date fecha_inicio;
	private Date fecha_real_fin;
	private Integer id_estado;

	public Integer getId_ordentrabajo() {
		return id_ordentrabajo;
	}

	public void setId_ordentrabajo(Integer id_ordentrabajo) {
		this.id_ordentrabajo = id_ordentrabajo;
	}

	public Integer getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		this.id_etapa = id_etapa;
	}

	public Integer getId_plan_produccion() {
		return id_plan_produccion;
	}

	public void setId_plan_produccion(Integer id_plan_produccion) {
		this.id_plan_produccion = id_plan_produccion;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_real_fin() {
		return fecha_real_fin;
	}

	public void setFecha_real_fin(Date fecha_real_fin) {
		this.fecha_real_fin = fecha_real_fin;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
}
