package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.VehiculoDAO;
import org.iesalixar.servidor.dao.VehiculoDAOImpl;
import org.iesalixar.servidor.model.Vehiculo;

public class VehiculoServiceImpl implements VehiculoService{
	
	// El servicio encapsulará el uso del DAO
	// y añadirá lógica de negocio necesaria
	private VehiculoDAO vehiculoDao;

	public VehiculoServiceImpl(final Session session) {

		this.vehiculoDao = new VehiculoDAOImpl(session);
	}
	

	public void insertNewVehiculo(Vehiculo vehiculo) {

		if (vehiculo != null && vehiculo.getId() == null) {

			// Inserción del publisher
			vehiculoDao.insert(vehiculo);
		}
		
	}

	public void updateVehiculo(Vehiculo vehiculo) {

		if (vehiculo != null && vehiculo.getId() != null) {

			// Actualizo el publisher
			vehiculoDao.update(vehiculo);
		}
		
	}

	public void deleteVehiculo(Vehiculo vehiculo) {

		if (vehiculo != null && vehiculo.getId() != null) {

			// Actualizo el publisher
			vehiculoDao.delete(vehiculo);
		}
	}
	

	public Vehiculo searchById(Long vehiculoId) {
		
		Vehiculo vehiculo = null;

		if (vehiculoId != null) {

			vehiculo = vehiculoDao.searchById(vehiculoId);
		}

		return vehiculo;
	}
	

	public List<Vehiculo> searchAll() {

		List<Vehiculo> vehiculoList = new ArrayList<Vehiculo>();

		vehiculoList = vehiculoDao.searchAll();

		return vehiculoList;
	}
	

	public Vehiculo searchByMatricula(String matricula) {

		Vehiculo vehiculo = null;

		if (matricula != null) {
			
			vehiculo = vehiculoDao.searchByMatricula(matricula);
		}

		return vehiculo;
	}

}
