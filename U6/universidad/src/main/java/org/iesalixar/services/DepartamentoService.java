package org.iesalixar.services;

import java.util.List;

import org.iesalixar.model.Departamento;
import org.iesalixar.model.Usuario;

public interface DepartamentoService {
	
	public List<Departamento> getAllDepartments();
	public Departamento insertDepartamento(Departamento departamento);
	
}