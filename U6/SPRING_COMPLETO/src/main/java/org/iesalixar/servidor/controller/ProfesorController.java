package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
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
	
	@GetMapping("/")
	public String profesores(Model model) {

		List<Profesor> profesores = profesorService.getAllProfesores();

		model.addAttribute("profesores", profesores);
		return "profesores";
	}
	
	@GetMapping("/edit")
	public String editProf(@RequestParam(name="prof") String prof,Model model) {
		
		Optional<Profesor> profesor = profesorService.findProfesorById(Long.parseLong(prof));
		model.addAttribute("profesor", profesor);
		return "editProfesor";
	}
	
	
	@PostMapping("/edit")
	public String updateProf(@ModelAttribute Profesor prof) {
		
		if (profesorService.actualizarProfesor(prof)==null) {
			return "redirect:/profedores/edit?error=error&prof"+prof.getId();
		}
		return "redirect:/profesores";
	}

	
	
	
}
