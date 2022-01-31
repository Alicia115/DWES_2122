package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Empresa;

public interface EmpresaService {
	
	public void insertNewEmpresa(final Empresa empresa);	
	 
	public void updateEmpresa(final Empresa empresa);	
	
	public void deleteEmpresa(final Empresa empresa);
	
	public Empresa searchById(final Long empresaId);
	
	public List<Empresa> searchAll();
	
	public Empresa searchEmpresaByName(final String name);

}
