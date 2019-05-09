package com.dte.app.dl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="documentos")
public class Documento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   	private Long id;
	private String tipo;
	private String razon_social;
	private Double monto_afecto;
	private Double tasa_iva;
	
	@Column(name="fecha_emision")
	@Temporal(TemporalType.DATE)
	private Date fecha_emision;
	
	@PrePersist
	public void prePersist() {
		fecha_emision=new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public Double getMonto_afecto() {
		return monto_afecto;
	}
	public void setMonto_afecto(Double monto_afecto) {
		this.monto_afecto = monto_afecto;
	}
	public Double getTasa_iva() {
		return tasa_iva;
	}
	public void setTasa_iva(Double tasa_iva) {
		this.tasa_iva = tasa_iva;
	}
	public Date getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	
	
}
