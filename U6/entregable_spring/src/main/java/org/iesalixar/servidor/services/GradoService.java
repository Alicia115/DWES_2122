package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Grado;

public interface GradoService {

	public List<Grado> getAllGrados();
	public Grado insertarGrado(Grado grado);
	public Grado actualizarGrado(Grado grado);
	public Grado findGradoById(Long id);
	public Grado getGradoByName(String nombre);

}