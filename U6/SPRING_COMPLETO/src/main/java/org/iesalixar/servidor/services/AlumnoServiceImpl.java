package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepo;
	
	@Override
	public Optional<Alumno> findAlumnoById(Long id) {
		
		if(id != null) {
			return alumnoRepo.findById(id);
		}
		return null;
	}

	@Override
	public List<Alumno> getAllAlumnos() {
		
		List<Alumno> alumns = alumnoRepo.findAll();	
		
		
		//Verificando que he obtenido algo 
		if (alumns!= null && alumns.size()> 0) {
			
			return alumns;
		}
		
		//No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Alumno>();
	}


	@Override
	public Alumno insertarAlumno(Alumno alumno) {
		
		if (alumno!=null && alumno.getId()== null) {
			Alumno alumn = alumnoRepo.save(alumno);
			return alumn;
		}
		
		return null;
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		
		if (alumno==null || alumno.getId() ==null) {
			return null;
		}
		
		return alumnoRepo.save(alumno); 
	}

	@Override
	public Alumno findAlumnoByNif(String nif) {
		if(!nif.equals("") && nif!=null) {
			return alumnoRepo.findByNif(nif);
		}
		return null;
	}

}
