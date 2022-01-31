package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.EmpleadoDAO;
import org.iesalixar.servidor.dao.EmpleadoDAOImpl;
import org.iesalixar.servidor.model.Empleados;

public class EmpleadoServiceImpl implements EmpleadoService {
	
	private EmpleadoDAO empleadoDao;

	public EmpleadoServiceImpl(final Session session) {
		this.empleadoDao = new EmpleadoDAOImpl(session);
	}

	@Override
	public void insertNewEmpleado(Empleados empleado) {
		
		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (empleado != null && empleado.getId() == null) {
			// Inserción del pedido
			empleadoDao.insert(empleado);
		}
	}

	@Override
	public void updateEmpleado(Empleados empleado) {
		
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (empleado != null && empleado.getId() != null) {

			// Actualizo el pedido
			empleadoDao.update(empleado);
		}
	}

	@Override
	public void deleteEmpleado(Empleados empleado) {

		if (empleado != null && empleado.getId() != null) {

			// Actualizo el pedido
			empleadoDao.delete(empleado);
		}
	}

	@Override
	public Empleados searchById(Long empleadoId) {
	
		Empleados empleado = null;

		if (empleadoId != null) {

			empleado = empleadoDao.searchById(empleadoId);
		}

		return empleado;
	}

	@Override
	public List<Empleados> searchAll() {

		List<Empleados> empleadoList = new ArrayList<Empleados>();

		empleadoList = empleadoDao.searchAll();

		return empleadoList;
	}

	@Override
	public List<Empleados> searchByFullName(String firstName, String lastName) {

		List<Empleados> empleadoList = new ArrayList<Empleados>();

		if (firstName!=null && lastName!=null) {
			empleadoList = empleadoDao.searchByFullName(firstName, lastName);
		}		

		return empleadoList;
	}

}
