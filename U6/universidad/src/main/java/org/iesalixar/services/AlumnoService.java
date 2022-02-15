package org.iesalixar.services;

import java.util.List;

import org.iesalixar.model.Alumno;
import org.springframework.stereotype.Service;

@Service
public interface AlumnoService {
	
	public List<Alumno> getAllAlumnos();

}
