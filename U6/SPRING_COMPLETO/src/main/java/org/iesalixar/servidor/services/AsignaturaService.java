package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;

public interface AsignaturaService {
	
	public List<Asignatura> getAllAsignaturas();
	public Optional<Asignatura> findAsignaturaById(Long id);
	public Asignatura getAsignaturaByName(String nombre);
	public Asignatura insertarAsignatura(Asignatura asignatura);
	public Asignatura actualizarAsignatura(Asignatura asignatura);

}
