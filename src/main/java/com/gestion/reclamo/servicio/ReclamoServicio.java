package com.gestion.reclamo.servicio;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.reclamo.mensaje.ReclamoMotivoDTO;
import com.gestion.reclamo.modelo.Empresa;
import com.gestion.reclamo.modelo.Motivo;
import com.gestion.reclamo.modelo.Reclamo;
import com.gestion.reclamo.repositorio.EmpresaRepositorio;
import com.gestion.reclamo.repositorio.MotivoRepositorio;
import com.gestion.reclamo.repositorio.ReclamoRepositorio;

import ch.qos.logback.core.pattern.parser.Parser;
import jakarta.persistence.Convert;

@Service
public class ReclamoServicio {

	@Autowired
	private ReclamoRepositorio repositorioreclamo;

	@Autowired
	private MotivoRepositorio repositoriomotivo;

	@Autowired
	private EmpresaRepositorio repositorioempresa;

	public List<ReclamoMotivoDTO> getAllReclamos() {

		List<Reclamo> reclamos = repositorioreclamo.findAll();
		List<Motivo> motivos = repositoriomotivo.findAll();
		List<Empresa> empresas = repositorioempresa.findAll();

		List<ReclamoMotivoDTO> reclamosConMotivo = reclamos.stream().map(reclamo -> {
			String motivoDescripcion = motivos.stream().filter(motivo -> motivo.getId().equals(reclamo.getMotivoId()))
					.map(Motivo::getDescripcion).findFirst().orElse("");

			String empresaDescripcion = empresas.stream()
					.filter(empresa -> empresa.getId().equals(reclamo.getEmpresaId())).map(Empresa::getDescripcion)
					.findFirst().orElse("");

			return new ReclamoMotivoDTO(reclamo, motivoDescripcion, empresaDescripcion);
		}).collect(Collectors.toList());

		return reclamosConMotivo;
	}

	public List<Motivo> getAllMotivo() {

		List<Motivo> motivos = repositoriomotivo.findAll();

		return motivos;
	}

	public List<Empresa> getAllEmpresa() {

		List<Empresa> empresas = repositorioempresa.findAll();

		return empresas;
	}

	public Boolean RegistroReclamo(Reclamo updatedReclamo) {

		Boolean bresultado = false;
		try {

			long id = updatedReclamo.getId() != null ? updatedReclamo.getId() : 0;
			if (id > 0 && repositorioreclamo.existsById(id)) {
				Reclamo existingReclamo = repositorioreclamo.findById(updatedReclamo.getId()).orElse(null);

				if (existingReclamo != null) {

					existingReclamo.setMotivoId(updatedReclamo.getMotivoId());

					existingReclamo.setDescripcion(updatedReclamo.getDescripcion());
					existingReclamo.setFechaRegistro(updatedReclamo.getFechaRegistro());
					repositorioreclamo.save(existingReclamo);
					bresultado = true;
				}

			} else {
				updatedReclamo.setFechaRegistro(new Date());
				repositorioreclamo.save(updatedReclamo);
				bresultado = true;
			}

		} catch (Exception e) {
			bresultado = false;
		}

		return bresultado;
	}

	public Boolean EliminaReclamo(Long reclamoId) {
		Boolean bresultado = false;

		try {

			if (repositorioreclamo.existsById(reclamoId)) {
				Reclamo existingReclamo = repositorioreclamo.findById(reclamoId).orElse(null);
				existingReclamo.setEstado("Eliminado");
				repositorioreclamo.save(existingReclamo);
				bresultado = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			bresultado = false;
		}
		return bresultado;
	}

}
