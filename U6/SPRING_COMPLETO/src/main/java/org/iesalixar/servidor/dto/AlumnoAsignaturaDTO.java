package org.iesalixar.servidor.dto;

import java.io.Serializable;

public class AlumnoAsignaturaDTO implements Serializable {
	
	private Long id_asignatura;
	private Long id_alumno;
	
	public AlumnoAsignaturaDTO() {
	}

	public Long getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(Long id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public Long getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(Long id_alumno) {
		this.id_alumno = id_alumno;
	}

}
