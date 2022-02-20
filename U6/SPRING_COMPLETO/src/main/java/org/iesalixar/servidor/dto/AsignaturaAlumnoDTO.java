package org.iesalixar.servidor.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import org.iesalixar.servidor.model.Alumno;

public class AsignaturaAlumnoDTO implements Serializable{
	
	private Long id_asignatura;
	private Set<Alumno> alumnos;

	public AsignaturaAlumnoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Long getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(Long id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	
}
