package org.iesalixar.servidor.services;


import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Departamento;

public interface AlumnoService {

	public List<Alumno> getAllAlumnos();
	public Optional<Alumno> findAlumnoById(Long id);
	public Alumno insertarAlumno(Alumno alumno);
	public Alumno actualizarAlumno(Alumno alumno);
}