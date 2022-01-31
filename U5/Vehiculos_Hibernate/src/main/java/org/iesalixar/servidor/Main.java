package org.iesalixar.servidor;

import java.util.Date;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Marca;
import org.iesalixar.servidor.model.Multas;
import org.iesalixar.servidor.model.Propietario;
import org.iesalixar.servidor.model.Vehiculo;
import org.iesalixar.servidor.services.MarcaService;
import org.iesalixar.servidor.services.MarcaServiceImpl;
import org.iesalixar.servidor.services.MultasService;
import org.iesalixar.servidor.services.MultasServiceImpl;
import org.iesalixar.servidor.services.PropietarioService;
import org.iesalixar.servidor.services.PropietarioServiceImpl;
import org.iesalixar.servidor.services.VehiculoService;
import org.iesalixar.servidor.services.VehiculoServiceImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class Main {
	
public static void main(String[] args) {
		
		//Creo la sesión
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//Creo los servicios
		MultasService multaService = new MultasServiceImpl(session);
		VehiculoService vehiculoService = new VehiculoServiceImpl(session);
		MarcaService marcaService = new MarcaServiceImpl(session);
		PropietarioService propietarioService = new PropietarioServiceImpl(session);
		
		//Creo los objetos necesarios
		Vehiculo v1 = new Vehiculo();
		v1.setMatricula("2345LKO");
		v1.setColor("Blanco");
		Vehiculo v2 = new Vehiculo();
		v2.setMatricula("5478POI");
		v2.setColor("Negro");
		Vehiculo v3 = new Vehiculo();
		v3.setMatricula("1123UYT");
		v3.setColor("Rojo");
		Vehiculo v4 = new Vehiculo();
		v4.setMatricula("9987KJJ");
		v4.setColor("Azul");
		
		//Persisto las empresas
		vehiculoService.insertNewVehiculo(v1);
		vehiculoService.insertNewVehiculo(v2);
		vehiculoService.insertNewVehiculo(v3);
		vehiculoService.insertNewVehiculo(v4);
	
		
		//Creo dos departamentos para cada empresa
		Multas m1 = new Multas();
		m1.setQuantity(3);		
		Multas m2 = new Multas();
		m2.setQuantity(2);	
		Multas m3 = new Multas();
		m3.setQuantity(5);	
		Multas m4 = new Multas();
		m4.setQuantity(1);	
		
		
		multaService.insertNewMulta(m1);
		multaService.insertNewMulta(m2);
		multaService.insertNewMulta(m3);
		multaService.insertNewMulta(m4);
		

		//Asociar Empresas-Departamentos
		v1.addMultas(m1);
		v2.addMultas(m2);
		v3.addMultas(m3);
		v4.addMultas(m4);
		
		vehiculoService.updateVehiculo(v1);
		vehiculoService.updateVehiculo(v2);
		vehiculoService.updateVehiculo(v3);
		vehiculoService.updateVehiculo(v4);
		
		Marca mar1 = new Marca();
		mar1.setName("Ford");
		mar1.setYear(1998);
		mar1.setCountry("España");
		Marca mar2 = new Marca();
		mar2.setName("Mercedes");
		mar2.setYear(2001);
		mar2.setCountry("NewYork");
		Marca mar3 = new Marca();
		mar3.setName("Seat");
		mar3.setYear(2019);
		mar3.setCountry("Portugal");
		Marca mar4 = new Marca();
		mar4.setName("Jeep");
		mar4.setYear(2021);
		mar4.setCountry("Alemania");
		
		marcaService.insertNewMarca(mar1);
		marcaService.insertNewMarca(mar2);
		marcaService.insertNewMarca(mar3);
		marcaService.insertNewMarca(mar4);
		
		mar1.addVehiculo(v4);
		mar2.addVehiculo(v3);
		mar3.addVehiculo(v2);
		mar4.addVehiculo(v1);
		
		marcaService.updateMarca(mar1);
		marcaService.updateMarca(mar2);
		marcaService.updateMarca(mar3);
		marcaService.updateMarca(mar4);
		
		
		Propietario p1 = new Propietario();
		p1.setFirstName("Alicia");
		p1.setLastName("Acosta");
		p1.setTelefono(954878985);
		p1.setDns("aser5874");
		Propietario p2 = new Propietario();
		p2.setFirstName("Almudena");
		p2.setLastName("Groso");
		p2.setTelefono(954712365);
		p2.setDns("skdiu5487");
		Propietario p3 = new Propietario();
		p3.setFirstName("Juanito");
		p3.setLastName("Bellacoso");
		p3.setTelefono(954665587);
		p3.setDns("lois4587");
		Propietario p4 = new Propietario();
		p4.setFirstName("Daniel");
		p4.setLastName("Ballesta");
		p4.setTelefono(954236589);
		p4.setDns("aser5874");
		Propietario p5 = new Propietario();
		p5.setFirstName("Mercedes");
		p5.setLastName("Maerty");
		p5.setTelefono(954787744);
		p5.setDns("erty4784");
		Propietario p6 = new Propietario();
		p6.setFirstName("Alejandro");
		p6.setLastName("Narvie");
		p6.setTelefono(954554412);
		p6.setDns("eraj2145");
		Propietario p7 = new Propietario();
		p7.setFirstName("Andrea");
		p7.setLastName("Acosta");
		p7.setTelefono(954221030);
		p7.setDns("etya9856");
		Propietario p8 = new Propietario();
		p8.setFirstName("Raul");
		p8.setLastName("Acosta");
		p8.setTelefono(954203698);
		p8.setDns("lopi5647");
		
		
		propietarioService.insertNewPropietario(p1);
		propietarioService.insertNewPropietario(p2);
		propietarioService.insertNewPropietario(p3);
		propietarioService.insertNewPropietario(p4);
		propietarioService.insertNewPropietario(p5);
		propietarioService.insertNewPropietario(p6);
		propietarioService.insertNewPropietario(p7);
		propietarioService.insertNewPropietario(p8);
		
		
		v1.addPropietario(p1, new Date(1998, 5, 18));
		v1.addPropietario(p2, new Date(2000, 12, 21));
		v2.addPropietario(p3, new Date(1996, 11, 18));
		v2.addPropietario(p4, new Date(1896, 9, 12));
		v3.addPropietario(p5, new Date(1799, 2, 28));
		v3.addPropietario(p6, new Date(1890, 1, 22));
		v4.addPropietario(p7, new Date(1990, 4, 15));
		v4.addPropietario(p8, new Date(1854, 7, 05));
		
		vehiculoService.updateVehiculo(v1);
		vehiculoService.updateVehiculo(v2);
		vehiculoService.updateVehiculo(v3);
		vehiculoService.updateVehiculo(v4);
		
		
		
				
		//Cerramos la sesión
		session.close();
	}

}
