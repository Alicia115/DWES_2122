package org.iesalixar.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.model.Departamento;
import org.iesalixar.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepo;

	@Override
	public List<Departamento> getAllDepartments() {		
		
		
		//Obtengo el resultado a través del repositorio
		List<Departamento> deptsBD = departamentoRepo.findAll();		
		
		
		//Verificando que he obtenido algo 
		if (deptsBD!= null && deptsBD.size()> 0) {
			
			return deptsBD;
		}
		
		//No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Departamento>(); 
		
	}

	@Override
	public Departamento insertDepartamento(Departamento departamento) {
		
		if (departamento!=null) {
			
			return departamentoRepo.save(departamento);
		}
		
		return null;
	}
	
	
}