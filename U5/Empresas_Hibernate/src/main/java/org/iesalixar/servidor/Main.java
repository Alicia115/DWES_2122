package org.iesalixar.servidor;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Empleados;
import org.iesalixar.servidor.model.Empresa;
import org.iesalixar.servidor.model.Sede;
import org.iesalixar.servidor.services.DepartamentoService;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.EmpleadoService;
import org.iesalixar.servidor.services.EmpleadoServiceImpl;
import org.iesalixar.servidor.services.EmpresaService;
import org.iesalixar.servidor.services.EmpresaServiceImpl;
import org.iesalixar.servidor.services.SedeService;
import org.iesalixar.servidor.services.SedeServiceImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class Main {
	
	public static void main(String[] args) {
		
		//Creo la sesión
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//Creo los servicios
		EmpresaService empresaService = new EmpresaServiceImpl(session);
		DepartamentoService departamentoService = new DepartamentoServiceImpl(session);
		SedeService sedeService = new SedeServiceImpl(session);
		EmpleadoService empleadoService = new EmpleadoServiceImpl(session);
		
		//Creo los objetos necesarios
		Empresa em1 = new Empresa();
		em1.setName("Adobe");
		em1.setCountry("USA");
		Empresa em2 = new Empresa();
		em2.setName("Instructure");
		em2.setCountry("USA");
		
		//Persisto las empresas
		empresaService.insertNewEmpresa(em1);
		empresaService.insertNewEmpresa(em2);
		
		//Creo dos departamentos para cada empresa
		Departamento d1 = new Departamento();
		d1.setName("Ventas");		
		Departamento d2 = new Departamento();
		d2.setName("Compras");
		Departamento d3 = new Departamento();
		d3.setName("Marketing");
		Departamento d4 = new Departamento();
		d4.setName("Ingeniería");
		
		
		departamentoService.insertNewDepartamento(d1);
		departamentoService.insertNewDepartamento(d2);
		departamentoService.insertNewDepartamento(d3);
		departamentoService.insertNewDepartamento(d4);
		
		
		//Creo dos sedes para para cada departamento (8)
				Sede s1 = new Sede();
				s1.setCity("Barcelona");
				s1.setCountry("Spain");
				Sede s2 = new Sede();
				s2.setCity("Madrid");
				s2.setCountry("Spain");
				Sede s3 = new Sede();
				s3.setCity("Paris");
				s3.setCountry("France");
				Sede s4 = new Sede();
				s4.setCity("Marsella");
				s4.setCountry("France");
				Sede s5 = new Sede();
				s5.setCity("Londres");
				s5.setCountry("UK");
				Sede s6 = new Sede();
				s6.setCity("Manchester");
				s6.setCountry("UK");
				Sede s7 = new Sede();
				s7.setCity("Bruselss");
				s7.setCountry("Belgium");
				Sede s8= new Sede();
				s8.setCity("Roma");
				s8.setCountry("Italy");
				
				sedeService.insertNewSede(s1);
				sedeService.insertNewSede(s2);
				sedeService.insertNewSede(s3);
				sedeService.insertNewSede(s4);
				sedeService.insertNewSede(s5);
				sedeService.insertNewSede(s6);
				sedeService.insertNewSede(s7);
				sedeService.insertNewSede(s8);
				
				
				//Creo 10 empleados	para ir añadiendo a los departamentos 	
				Empleados e1 = new Empleados();
				e1.setFirstName("Pepe");
				e1.setLastName("Perez");
				Empleados e2 = new Empleados();
				e2.setFirstName("Ana");
				e2.setLastName("Lopez");
				Empleados e3 = new Empleados();
				e3.setFirstName("Rosa");
				e3.setLastName("Torres");
				Empleados e4 = new Empleados();
				e4.setFirstName("Ricardo");
				e4.setLastName("Antunez");
				Empleados e5 = new Empleados();
				e5.setFirstName("Asunción");
				e5.setLastName("Martínez");
				Empleados e6 = new Empleados();
				e6.setFirstName("Francisco");
				e6.setLastName("Gutiérrez");
				Empleados e7 = new Empleados();
				e7.setFirstName("Luis");
				e7.setLastName("Irigoyen");
				Empleados e8 = new Empleados();
				e8.setFirstName("Jesús");
				e8.setLastName("Durán");
				Empleados e9 = new Empleados();
				e9.setFirstName("Pedro");
				e9.setLastName("González");
				Empleados e10 = new Empleados();
				e10.setFirstName("Manuel");
				e10.setLastName("Garrido");
				
				
				//Persisto los empleados
				empleadoService.insertNewEmpleado(e1);
				empleadoService.insertNewEmpleado(e2);
				empleadoService.insertNewEmpleado(e3);
				empleadoService.insertNewEmpleado(e4);
				empleadoService.insertNewEmpleado(e5);
				empleadoService.insertNewEmpleado(e6);
				empleadoService.insertNewEmpleado(e7);
				empleadoService.insertNewEmpleado(e8);
				empleadoService.insertNewEmpleado(e9);
				empleadoService.insertNewEmpleado(e10);
				
				//Asociar Empresas-Departamentos
				em1.addDepartamento(d1);
				em1.addDepartamento(d2);
				em2.addDepartamento(d3);
				em2.addDepartamento(d4);
				
				empresaService.updateEmpresa(em1);
				empresaService.updateEmpresa(em2);
				
				d1.addSede(s1);
				d1.addSede(s2);
				d2.addSede(s3);
				d2.addSede(s4);
				d3.addSede(s5);
				d3.addSede(s6);
				d4.addSede(s7);
				d4.addSede(s8);
				
				departamentoService.updateDepartamento(d1);
				departamentoService.updateDepartamento(d2);
				departamentoService.updateDepartamento(d3);
				departamentoService.updateDepartamento(d4);		
				

				d1.addEmpleado(e1, "Programador");
				d2.addEmpleado(e2, "Programador");
				d3.addEmpleado(e3, "Programador");
				d4.addEmpleado(e4, "Analista");
				d1.addEmpleado(e5, "Programador");
				d2.addEmpleado(e6, "Programador");
				d2.addEmpleado(e7, "Tester");
				d3.addEmpleado(e8, "Programador");
				d1.addEmpleado(e9, "Programador");
				d1.addEmpleado(e10, "Technical Writer");
				
				
				departamentoService.updateDepartamento(d1);
				departamentoService.updateDepartamento(d2);
				departamentoService.updateDepartamento(d3);
				departamentoService.updateDepartamento(d4);
				
				
				//Cerramos la sesión
				session.close();
	}
}
