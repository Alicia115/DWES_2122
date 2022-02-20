package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.AlumnoDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	AlumnoServiceImpl alumnoService;

	@GetMapping("/")
	public String alumnos(Model model) {

		List<Alumno> alumnos = alumnoService.getAllAlumnos();

		model.addAttribute("alumnos", alumnos);
		return "alumnos";
	}

	@GetMapping("/asignaturas")
	public String alumnosMatricula(@RequestParam(required = false, name = "codigo") String codigo, Model model) {

		// Obtengo el parámetro de la URL (en caso de no esta vuelvo a la lista de
		// asignaturas
		if (codigo == null) {
			return "redirect:/alumnos/";
		}
		
		
		Optional<Alumno> alumno = alumnoService.findAlumnoById(Long.parseLong(codigo));
		model.addAttribute("alumno",alumno.get());		
		return "alumnosAsignaturas";
	}
	
	
	/*
	@GetMapping("/add")
	public String alumnosInsertarGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="alumno") String alumno,
			Model model) {
		
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		model.addAttribute("alumno", alumnoDTO);
		model.addAttribute("error", error);
		return "addAlumno";
		
	}
	
	@PostMapping("/add")
	public String alumnosInsertarPost(@ModelAttribute AlumnoDTO alumnoDTO,Model model) {
		
		if(alumnoService.findAlumnoByNif(alumnoDTO.getNif())==null) {
			Alumno alumn = new Alumno();		
			alumn.setNif(alumnoDTO.getNif());
			alumn.setNombre(alumnoDTO.getNombre());
			alumn.setApellido1(alumnoDTO.getApellido1());
			alumn.setApellido2(alumnoDTO.getApellido2());
			alumn.setCiudad(alumnoDTO.getCiudad());
			alumn.setDireccion(alumnoDTO.getDireccion());
			alumn.setFechaNacimiento(alumnoDTO.getFechaNacimiento());
			alumn.setSexo(alumnoDTO.getSexo());
			alumn.setTelefono(alumnoDTO.getTelefono());
			
			if (alumnoService.insertarAlumno(alumn)==null) {
				return "redirect:/alumnos/add?error=Existe&alumno="+alumnoDTO.getNombre();
			}else {
				return "redirect:/alumnos/";					
			}
		}else {
			return "redirect:/alumnos/add?error=ExisteNif&alumno="+alumnoDTO.getNif();
		}
		
	}*/
	
	@GetMapping("/edit")
	public String editAlumn(@RequestParam(name="alumn") String alumn,Model model) {
		
		Optional<Alumno> alumno = alumnoService.findAlumnoById(Long.parseLong(alumn));
		model.addAttribute("alumno",alumno.get());	
		return "editAlumno";
	}
	
	
	@PostMapping("/edit")
	public String updateAlumn(@ModelAttribute Alumno alumn) {
		
		if (alumnoService.actualizarAlumno(alumn)==null) {
			return "redirect:/alumnos/edit?error=error&alumn"+alumn.getId();
		}
		return "redirect:/alumnos/";
	}
	
	@GetMapping("/add")
	public String addAlumnoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="alumn") String nombre,
			Model model) {
		
		AlumnoDTO alumn = new AlumnoDTO();
		
		model.addAttribute("alumn", alumn);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addAlumno";
	}
	
	
	@PostMapping("/add")
	public String addAlumnoPost(@ModelAttribute AlumnoDTO alumn,Model model) {
		
		if(alumnoService.findAlumnoByNif(alumn.getNif())==null) {
			Alumno alumnBD = new Alumno();
			alumnBD.setNif(alumn.getNif());
			alumnBD.setNombre(alumn.getNombre());
			alumnBD.setApellido1(alumn.getApellido1());
			alumnBD.setApellido2(alumn.getApellido2());
			alumnBD.setCiudad(alumn.getCiudad());
			alumnBD.setDireccion(alumn.getDireccion());
			alumnBD.setFechaNacimiento(alumn.getFechaNacimiento());
			alumnBD.setSexo(alumn.getSexo());
			alumnBD.setTelefono(alumn.getTelefono());
			
			if (alumnoService.insertarAlumno(alumnBD)==null) {
				return "redirect:/alumnos/add?error=Existe&alumn="+alumn.getNombre();
			}
		}else {
			return "redirect:/alumnos/add?error=ExisteNif&alumn="+alumn.getNif();
		}
		
		return "redirect:/alumnos/";
	}
}
