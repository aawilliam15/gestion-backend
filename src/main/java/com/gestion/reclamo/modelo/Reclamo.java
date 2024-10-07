package com.gestion.reclamo.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reclamo")
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "Empresa", length = 100, nullable = false)
	private String Empresa;

	@Column(name = "MotivoId", nullable = false)
	private Long MotivoId;

	@Column(name = "Descripcion", length = 100, nullable = false)
	private String Descripcion;

	@Column(name = "Adjunto", length = 1000, nullable = false)
	private String Adjunto;

	@Column(name = "FechaRegistro", nullable = false)
	private Date FechaRegistro;

	@Column(name = "Correo", length = 100, nullable = false)
	private String Correo;

	@Column(name = "Estado", length = 100, nullable = false)
	private String Estado;

	
	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Reclamo(Long id, String empresa, Long motivoId, String descripcion, String adjunto, Date fechaRegistro,
			String correo,String estado) {
		super();
		Id = id;
		Empresa = empresa;
		MotivoId = motivoId;
		Descripcion = descripcion;
		Adjunto = adjunto;
		FechaRegistro = fechaRegistro;
		Correo = correo;
		Estado = estado;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public Long getMotivoId() {
		return MotivoId;
	}

	public void setMotivoId(Long motivoId) {
		MotivoId = motivoId;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getAdjunto() {
		return Adjunto;
	}

	public void setAdjunto(String adjunto) {
		Adjunto = adjunto;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public Reclamo() {

	}

}
