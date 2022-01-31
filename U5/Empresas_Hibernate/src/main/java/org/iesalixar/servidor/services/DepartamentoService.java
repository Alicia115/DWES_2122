package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Departamento;


public interface DepartamentoService {
	
	public void insertNewDepartamento(final Departamento departamento);	
	 
	public void updateDepartamento(final Departamento departamento);	
	
	public void deleteDepartamento(final Departamento departamento);
	
	public Departamento searchById(final Long departamentoId);
	
	public List<Departamento> searchAll();
	
	public List<Departamento> searchByName(String name);
}
