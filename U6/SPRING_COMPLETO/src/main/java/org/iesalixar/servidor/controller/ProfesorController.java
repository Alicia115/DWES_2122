package org.iesalixar.servidor.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.dto.GradoAsignaturaDTO;
import org.iesalixar.servidor.dto.ProfesorAsignaturaDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	ProfesorServiceImpl profesorService;
	
	@Autowired
	DepartamentoServiceImpl departService;
	
	@Autowired
	AsignaturaServiceImpl asigService;
	
	@GetMapping("/")
	public String profesores(Model model) {

		List<Profesor> profesores = profesorService.getAllProfesores();

		model.addAttribute("profesores", profesores);
		return "profesores";
	}
	
	@GetMapping("/edit")
	public String editProf(@RequestParam(name="prof") String prof,Model model) {
		List<Departamento> departamentos = departService.getAllDepartments();
		Optional<Profesor> profesor = profesorService.findProfesorById(Long.parseLong(prof));
		model.addAttribute("profesor", profesor.get());
		model.addAttribute("departamentos",departamentos);
		return "editProfesor";
	}
	
	
	@PostMapping("/edit")
	public String updateProf(@ModelAttribute Profesor prof) {
		
		if (profesorService.actualizarProfesor(prof)==null) {
			return "redirect:/profesores/edit?error=error&prof"+prof.getId();
		}
		return "redirect:/profesores/";
	}
	

	@GetMapping("/add")
	public String addProfesorGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="prof") String nombre,
			Model model) {
		
		ProfesorDTO prof = new ProfesorDTO();
		List<Departamento> departamentos = departService.getAllDepartments();
		
		model.addAttribute("prof", prof);
		model.addAttribute("departamentos",departamentos);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addProfesor";
	}
	
	
	@PostMapping("/add")
	public String addProfesorPost(@ModelAttribute ProfesorDTO prof,Model model) {
		
		if(profesorService.findProfesorByNif(prof.getNif())==null) {
			Profesor profBD = new Profesor();
			profBD.setNif(prof.getNif());
			profBD.setNombre(prof.getNombre());
			profBD.setApellido1(prof.getApellido1());
			profBD.setApellido2(prof.getApellido2());
			profBD.setCiudad(prof.getCiudad());
			profBD.setDireccion(prof.getDireccion());
			profBD.setFechaNacimiento(prof.getFechaNacimiento());
			profBD.setSexo(prof.getSexo());
			profBD.setTelefono(prof.getTelefono());
			profBD.setDepartamento(departService.findDepartamentoById((long) prof.getId_departamento()));
			
			if (profesorService.insertarProfesor(profBD)==null) {
				return "redirect:/profesores/add?error=Existe&prof="+prof.getNombre();
			}
		}else {
			return "redirect:/profesores/add?error=ExisteNif&prof="+prof.getNif();
		}
		
		return "redirect:/profesores/";
	}
	
	
	@GetMapping("/asignaturas")
	public String profesoresAsignatura(
			@RequestParam(required=false,name="prof") String prof,
			Model model) {
		
		Optional<Profesor> profesores = profesorService.findProfesorById(Long.parseLong(prof));
		
		if (prof==null || profesores == null) {
			return "redirect:/";
		}
		
		model.addAttribute("profesores", profesores.get());		
		
		return "asignaturasProfesor";
	}
	
	@GetMapping("/asignaturas/delete")
	public String borrarAsignaturaProfesor(			
			@RequestParam(required=false,name="asig") String asig,
			Model model) {
		
		Asignatura asigEntity = asigService.findAsignaturaById(Long.parseLong(asig)).get();
		System.out.println(asigEntity);
		
		Long profId = asigEntity.getProfesor().getId();
		
		asigEntity.setProfesor(null);
		
		asigService.actualizarAsignatura(asigEntity);
		
		return "redirect:../asignaturas?prof="+profId;
		
	}
	
	@GetMapping("/addasignatura")
	public String addAsigProfesorGet(@RequestParam(required=false,name="error") String error, @RequestParam(required=false,name="id_prof") String id_prof,Model model) {
		
		ProfesorAsignaturaDTO asigProf = new ProfesorAsignaturaDTO();
		List<Asignatura> asignaturas = asigService.getAllAsignaturas();
		List<Profesor> profesores = profesorService.getAllProfesores();
		model.addAttribute("asigProf",asigProf);
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("profesores",profesores);
		model.addAttribute("error",error);
		if(id_prof!=null) {
			model.addAttribute("id_prof", id_prof);
		}
		return "addAsigProfesor";
	}
	
	
	@PostMapping("/addasignatura")
	public String addAsigProfesorPost(@ModelAttribute ProfesorAsignaturaDTO asigProf,Model model) {
		
		Profesor profesor = profesorService.findProfesorById(asigProf.getId_profesor()).get();
		Asignatura asig = asigService.findAsignaturaById(asigProf.getId_asignatura()).get();
		System.out.println(asigProf.getId_profesor());
		
		if(profesor != null && asig != null) {
			
			asig.setProfesor(profesor);
			asigService.actualizarAsignatura(asig);
			
			return "redirect:./asignaturas?prof="+profesor.getId();

		} else {	
			return "redirect:./addasignatura/";
		}

	}
	
}
