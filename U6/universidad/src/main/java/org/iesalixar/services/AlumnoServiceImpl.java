package org.iesalixar.services;

import java.util.ArrayList;

import java.util.List;

import org.iesalixar.model.Alumno;
import org.iesalixar.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	AlumnoRepository alumnoRepo;

	@Override
	public List<Alumno> getAllAlumnos() {
		
		List<Alumno> alumnBD = alumnoRepo.findAll();
		
		if(alumnBD != null && alumnBD.size()>0) {
			
			return alumnBD;
		}
		
		return new ArrayList<Alumno>();
	}

}
