package org.iesalixar.servidor.dao;


import java.util.List;

import org.hibernate.Session;

import org.iesalixar.servidor.model.Vehiculo;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class VehiculoDAOImpl extends GenericDAOImpl<Vehiculo> implements VehiculoDAO {
	
		private Session session;
		
		public VehiculoDAOImpl(Session session) {
			super(session);
			this.session = session;
		}

		public Vehiculo searchByMatricula(String matricula) {
			
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Recupero las editoriales por nombre
			List<Vehiculo> vehiculoList = session.createQuery("FROM Vehiculo WHERE matricula='" + matricula+"'").list();

			// Como el nombre del publisher debe ser único me quedo con el primero en caso
			// de que se haya devuelvo algo (existe)
			Vehiculo vehiculo = null;
			if (vehiculoList != null && vehiculoList.size() > 0) {
				vehiculo = vehiculoList.get(0);
			}

			return vehiculo;
		}

}
