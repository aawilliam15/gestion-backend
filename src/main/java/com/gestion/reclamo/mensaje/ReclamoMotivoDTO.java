package com.gestion.reclamo.mensaje;

import java.util.Date;

import com.gestion.reclamo.modelo.Reclamo;

public class ReclamoMotivoDTO extends Reclamo {

	public String motivodsc;
	public String empresadsc;

	public ReclamoMotivoDTO() {

	}

	public ReclamoMotivoDTO(Reclamo reclamo, String motivodsc,String empresadsc) {
		super(reclamo.getId(), reclamo.getEmpresaId(), reclamo.getMotivoId(), reclamo.getDescripcion(),
				reclamo.getAdjunto(), reclamo.getFechaRegistro(), reclamo.getCorreo(),reclamo.getEstado());
		this.motivodsc = motivodsc;
		this.empresadsc=empresadsc;
	}

	public String getMotivodsc() {
		return motivodsc;
	}

	@Override
	public Long getId() {
		return super.getId() != null ? super.getId() : null;
	}

	@Override
	public String getDescripcion() {
		return super.getDescripcion() != null ? super.getDescripcion() : null;
	}

	@Override
	public Long getMotivoId() {
		return super.getMotivoId() != null ? super.getMotivoId() : null;
	}

	@Override
	public Date getFechaRegistro() {
		return super.getFechaRegistro() != null ? super.getFechaRegistro() : null;
	}

	@Override
	public String getAdjunto() {
		return super.getAdjunto() != null ? super.getAdjunto() : null;
	}

	@Override
	public String getCorreo() {
		return super.getCorreo() != null ? super.getCorreo() : null;
	}

	@Override
	public Long getEmpresaId() {
		return super.getEmpresaId() != null ? super.getEmpresaId() : null;
	}
	
	@Override
	public String getEstado() {
		return super.getEstado() != null ? super.getEstado() : null;
	}
	
}
