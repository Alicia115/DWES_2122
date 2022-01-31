package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Empleados;

public interface EmpleadoService {
	
	public void insertNewEmpleado(final Empleados empleado);	
	 
	public void updateEmpleado(final Empleados empleado);	
	
	public void deleteEmpleado(final Empleados empleado);
	
	public Empleados searchById(final Long empleadoId);
	
	public List<Empleados> searchAll();
	
	public List<Empleados> searchByFullName(final String firstName,final String lastName);

}
