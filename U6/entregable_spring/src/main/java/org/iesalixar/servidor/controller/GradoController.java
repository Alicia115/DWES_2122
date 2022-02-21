package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.GradoAsginaturaDTO;
import org.iesalixar.servidor.dto.GradoDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {
	
	@Autowired
	GradoServiceImpl gradoService;
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@RequestMapping("/grados")
	public String grados(Model model) {
		
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("grados",grados);
		return "grados";
	}


	@GetMapping("/grados/addGrado")
	public String addGradoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="grado") String nombre,
			Model model) {
		
		GradoDTO grado = new GradoDTO();
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addGrado";
	}
	
	
	@PostMapping("/grados/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO grado,Model model) {
		
		Grado gradoBD = new Grado();
		gradoBD.setNombre(grado.getNombre());
		
		if (gradoService.insertarGrado(gradoBD)==null) {
			return "redirect:/grados/addGrado?error=Existe&grado="+grado.getNombre();
		}
		
		return "redirect:/grados";
	}
	
	@GetMapping("/grados/asignaturas")
	public String gradosAsignaturas(@RequestParam(required = false, name = "codigo") String codigo,
			@RequestParam(required=false,name="error") String error, Model model) {

		
		if (codigo == null) {
			return "redirect:/grados/";
		}
		
		Grado grado = gradoService.findGradoById(Long.parseLong(codigo));
		model.addAttribute("grado",grado);	
		model.addAttribute("error",error);	
		return "gradoAsignatura";
	}
	
	
	@GetMapping("/grados/addasignatura")
	public String addAsigGradoGet(@RequestParam(required=false,name="error") String error, Model model) {
		
		GradoAsginaturaDTO asigGrado = new GradoAsginaturaDTO();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		List<Grado> grados = gradoService.getAllGrados();
		model.addAttribute("asigGrado",asigGrado);
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("grados",grados);
		model.addAttribute("error",error);
		return "addAsigGrado";
	}
	
	
	@PostMapping("/grados/addasignatura")
	public String addAsigGradoPost(@ModelAttribute GradoAsginaturaDTO asigGrado,Model model) {
		
		Grado grado = gradoService.findGradoById(asigGrado.getId_grado());
		Asignatura asig = asignaturaService.findAsignaturaById(asigGrado.getId_asignatura());
		
		if(grado != null && asig != null) {
			
			asig.setGrado(grado);
			asignaturaService.actualizarAsignatura(asig);
			
			return "redirect:/grados/asignaturas?codigo="+grado.getId();

		} else {	
			return "redirect:/grados/addasignatura/";
		}

	}

}
