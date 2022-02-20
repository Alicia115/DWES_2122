package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
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
			return "redirect:/profedores/edit?error=error&prof"+prof.getId();
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
		
		Profesor profBD = new Profesor();
		profBD.setNombre(prof.getNombre());
		
		if (profesorService.insertarProfesor(profBD)==null) {
			return "redirect:/profesores/add?error=Existe&prof="+prof.getNombre();
		}
		
		return "redirect:/profesores/";
	}
	
	
}
