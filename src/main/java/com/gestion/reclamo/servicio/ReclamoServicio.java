package com.gestion.reclamo.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.reclamo.mensaje.ReclamoMotivoDTO;
import com.gestion.reclamo.modelo.Motivo;
import com.gestion.reclamo.modelo.Reclamo;
import com.gestion.reclamo.repositorio.MotivoRepositorio;
import com.gestion.reclamo.repositorio.ReclamoRepositorio;

@Service
public class ReclamoServicio {

	@Autowired
	private ReclamoRepositorio repositorioreclamo;
	@Autowired
	private MotivoRepositorio repositoriomotivo;

	public List<ReclamoMotivoDTO> getAllReclamos() {

		List<Reclamo> reclamos = repositorioreclamo.findAll();

		List<Motivo> motivos = repositoriomotivo.findAll();

		List<ReclamoMotivoDTO> reclamosConMotivo = reclamos.stream().map(reclamo -> {
			String motivoDescripcion = motivos.stream().filter(motivo -> motivo.getId().equals(reclamo.getMotivoId()))
					.map(Motivo::getDescripcion).findFirst().orElse("");

			return new ReclamoMotivoDTO(reclamo, motivoDescripcion);
		}).collect(Collectors.toList());

		return reclamosConMotivo;
	}

	public List<Motivo> getAllMotivo() {

		List<Motivo> motivos = repositoriomotivo.findAll();

		return motivos;
	}

	public Boolean RegistroReclamo(Reclamo updatedReclamo) {
		Boolean bresultado = false;

		if (repositorioreclamo.existsById(updatedReclamo.getId())) {
			Reclamo existingReclamo = repositorioreclamo.findById(updatedReclamo.getId()).orElse(null);

			if (existingReclamo != null) {

				existingReclamo.setMotivoId(updatedReclamo.getMotivoId());
				existingReclamo.setDescripcion(updatedReclamo.getDescripcion());
				existingReclamo.setFechaRegistro(updatedReclamo.getFechaRegistro());
				repositorioreclamo.save(existingReclamo);
				bresultado = true;
			} else {
				repositorioreclamo.save(updatedReclamo);
				bresultado = true;
			}
		}

		return bresultado;
	}

	public Boolean EliminaReclamo(Long reclamoId) {
		Boolean bresultado = false;

		if (repositorioreclamo.existsById(reclamoId)) {
			Reclamo existingReclamo = repositorioreclamo.findById(reclamoId).orElse(null);
			existingReclamo.setEstado("Eliminado");
			repositorioreclamo.save(existingReclamo);
			bresultado = true;
		}

		return bresultado;
	}

}
