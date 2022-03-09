package org.iesalixar.servidor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.AlumnoAsignaturaDTO;
import org.iesalixar.servidor.dto.AlumnoDTO;
import org.iesalixar.servidor.dto.AsignaturaAlumnoDTO;
import org.iesalixar.servidor.dto.GradoAsignaturaDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
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
	
	@Autowired
	AsignaturaServiceImpl asigService;

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
	@GetMapping("/addasignaturaalumno")
	public String addAsigAlumnoGet(@RequestParam(required=false,name="error") String error, @RequestParam(required=false,name="id_alum") String id_alum,Model model) {
		
		AlumnoAsignaturaDTO asigAlumn= new AlumnoAsignaturaDTO();
		List<Alumno> alumnos = alumnoService.getAllAlumnos();
		List<Asignatura> asignaturas = asigService.getAllAsignaturas();
		
		model.addAttribute("asigAlumn",asigAlumn);
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("alumnos",alumnos);
		model.addAttribute("error",error);
		if(id_alum!=null) {
			model.addAttribute("id_alum", id_alum);
		}
		return "addAsignaturaAlumno";
	}
	
	
	@PostMapping("/addasignaturaalumno")
	public String addAsigAlumnoPost(@ModelAttribute AlumnoAsignaturaDTO asigAlumn,Model model) {
		
		Alumno alumno = alumnoService.findAlumnoById(asigAlumn.getId_alumno()).get();
		Asignatura asig = asigService.findAsignaturaById(asigAlumn.getId_asignatura()).get();
		
		if(grado != null && asig != null) {
			
			asig.setGrado(grado);
			asigService.actualizarAsignatura(asig);
			
			return "redirect:/grados/asignaturas?codigo="+grado.getId();

		} else {	
			return "redirect:/grados/addasignatura/";
		}
	}
	*/
	
	@GetMapping("/asignaturas/delete")
    public String asignaturaAlumnoDelete(@RequestParam(required=true, name="asig") String asig,
            @RequestParam(required=true, name="alumn") String alumn){

        Asignatura asignatura = asigService.findAsignaturaById(Long.parseLong(asig)).get();
        if(asignatura !=null) {
            Alumno alumno = alumnoService.findAlumnoById(Long.parseLong(alumn)).get();
            asignatura.removeNota(alumno);
            asigService.actualizarAsignatura(asignatura);
            return "redirect:/alumnos/asignaturas?codigo="+alumn;
        }else {
            return "redirect:/alumnos/";
        }
    }
	
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
