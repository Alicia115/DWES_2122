package org.iesalixar.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.model.Asignatura;
import org.iesalixar.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	AsignaturaRepository asignaturaRepo;

	@Override
	public List<Asignatura> getAllAsignaturas() {

		// Obtengo el resultado a través del repositorio
		List<Asignatura> asignBD = asignaturaRepo.findAll();

		// Verificando que he obtenido algo
		if (asignBD != null && asignBD.size() > 0) {

			return asignBD;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Asignatura>();
	}

}