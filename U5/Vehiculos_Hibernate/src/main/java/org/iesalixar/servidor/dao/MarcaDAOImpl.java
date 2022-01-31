package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Marca;
import org.iesalixar.servidor.model.Vehiculo;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class MarcaDAOImpl extends GenericDAOImpl<Marca> implements MarcaDAO{
	
		private Session session;
		
		public MarcaDAOImpl(Session session) {
			super(session);
			this.session = session;
		}

		public Marca searchByName(String name) {
			
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Recupero las editoriales por nombre
			List<Marca> marcaList = session.createQuery("FROM Marca WHERE name='" + name+"'").list();

			// Como el nombre del publisher debe ser único me quedo con el primero en caso
			// de que se haya devuelvo algo (existe)
			Marca marca = null;
			if (marcaList != null && marcaList.size() > 0) {
				marca = marcaList.get(0);
			}

			return marca;
		}
		

		public Marca searchByCountry(String country) {
			
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Recupero las editoriales por nombre
			List<Marca> marcaList = session.createQuery("FROM Marca WHERE country='" + country+"'").list();

			// Como el nombre del publisher debe ser único me quedo con el primero en caso
			// de que se haya devuelvo algo (existe)
			Marca marca = null;
			if (marcaList != null && marcaList.size() > 0) {
				marca = marcaList.get(0);
			}

			return marca;
		}
		
		
}
