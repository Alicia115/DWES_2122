package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.dto.GradoAsignaturaDTO;
import org.iesalixar.servidor.dto.GradoDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.model.Profesor;
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
	AsignaturaServiceImpl asigService;
	
	@RequestMapping("/grados")
	public String grados(Model model) {
		
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("grados",grados);
		return "grados";
	}


	@GetMapping("/grados/add")
	public String addGradoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="grado") String nombre,
			Model model) {
		
		GradoDTO grado = new GradoDTO();
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addGrado";
	}
	
	
	@PostMapping("/grados/add")
	public String addGradoPost(@ModelAttribute GradoDTO grado,Model model) {
		
		Grado gradoBD = new Grado();
		gradoBD.setNombre(grado.getNombre());
		
		if (gradoService.insertarGrado(gradoBD)==null) {
			return "redirect:/grados/add?error=Existe&grado="+grado.getNombre();
		}
		
		return "redirect:/grados";
	}
	
	@GetMapping("/grados/edit")
	public String editGrado(@RequestParam(name="grado") String grado,Model model) {
		
		
		Grado grad = gradoService.findGradoById(Long.parseLong(grado));
		model.addAttribute("grado", grad);
		return "editGrado";
	}
	
	
	@PostMapping("/grados/edit")
	public String updateGrado(@ModelAttribute Grado grado) {
		
		if (gradoService.actualizarGrado(grado)==null) {
			return "redirect:/grados/edit?error=error&grado"+grado.getId();
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
		
		GradoAsignaturaDTO asigGrado = new GradoAsignaturaDTO();
		List<Asignatura> asignaturas = asigService.getAllAsignaturas();
		List<Grado> grados = gradoService.getAllGrados();
		model.addAttribute("asigGrado",asigGrado);
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("grados",grados);
		model.addAttribute("error",error);
		return "addAsigGrado";
	}
	
	
	@PostMapping("/grados/addasignatura")
	public String addAsigGradoPost(@ModelAttribute GradoAsignaturaDTO asigGrado,Model model) {
		
		Grado grado = gradoService.findGradoById(asigGrado.getId_grado());
		Asignatura asig = asigService.findAsignaturaById(asigGrado.getId_asignatura()).get();
		
		if(grado != null && asig != null) {
			
			asig.setGrado(grado);
			asigService.actualizarAsignatura(asig);
			
			return "redirect:/grados/asignaturas?codigo="+grado.getId();

		} else {	
			return "redirect:/grados/addasignatura/";
		}

	}

	@GetMapping("/grados/asignaturas/delete")
	public String borrarAsignaturaGrado(			
			@RequestParam(required=false,name="asig") String asig,
			Model model) {
		
		Asignatura asigEntity = asigService.findAsignaturaById(Long.parseLong(asig)).get();
		Long gradoId = asigEntity.getGrado().getId();
		
		asigEntity.setGrado(null);
		
		asigService.actualizarAsignatura(asigEntity);
		
		return "redirect:/grados/asignaturas?codigo="+gradoId;
	}
	
	
}
