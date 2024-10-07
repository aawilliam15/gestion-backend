package com.gestion.reclamo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Motivo")
public class Motivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "Descripcion", length = 300, nullable = false)
	private String Descripcion;

	@Column(name = "Estado", nullable = false)
	private int Estado;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public Motivo(Long id, String descripcion, int estado) {
		super();
		Id = id;
		Descripcion = descripcion;
		Estado = estado;
	}

	public Motivo() {

	}

}
