package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.AsignaturaAlumnoDTO;
import org.iesalixar.servidor.dto.AsignaturaDTO;
import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
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
@RequestMapping("/asignaturas")
public class AsignaturaController {

	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@Autowired
	ProfesorServiceImpl profService;
	
	@Autowired
	GradoServiceImpl gradoService;
	
	@Autowired
	AlumnoServiceImpl alumService;
	
	@GetMapping("/") 
	public String asignaturas(Model model) {
		
		model.addAttribute("asignaturas", asignaturaService.getAllAsignaturas());
			
		return "asignaturas";
	}
	
	
	@GetMapping("/alumnos")
	public String asignaturasAlumnos(@RequestParam(required=false,name="codigo") String codigo,Model model) {
		
		if (codigo==null) {
			return "redirect:/asignaturas/";
		}
		
		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(codigo));
		model.addAttribute("asignatura",asignatura.get());				
		return "asignaturasAlumnos";
	}
	
	@GetMapping("/alumnos/delete")
    public String asignaturaAlumnoDelete(@RequestParam(required=true, name="asig") String asig,
            @RequestParam(required=true, name="alumn") String alumn){

        Asignatura asignatura = asignaturaService.findAsignaturaById(Long.parseLong(asig)).get();
        if(asignatura !=null) {
            Alumno alumno = alumService.findAlumnoById(Long.parseLong(alumn)).get();
            asignatura.removeNota(alumno);
            asignaturaService.actualizarAsignatura(asignatura);
            return "redirect:/asignaturas/alumnos?codigo="+asig;
        }else {
            return "redirect:/asignaturas/";
        }
    }
	
	
	@GetMapping("/add")
	public String addAsignaturaGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="asig") String nombre,
			Model model) {
		
		AsignaturaDTO asig = new AsignaturaDTO();
		List<Profesor> profesores = profService.getAllProfesores();
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("asig", asig);
		model.addAttribute("profesores",profesores);
		model.addAttribute("grados", grados);
		model.addAttribute("error", error);
		return "addAsignatura";
	}
	
	
	@PostMapping("/add")
	public String addAsignaturaPost(@ModelAttribute AsignaturaDTO asig,Model model) {
		
		Asignatura asigBD = new Asignatura();
		asigBD.setNombre(asig.getNombre());
		asigBD.setCurso(asig.getCurso());
		asigBD.setCuatrimestre(asig.getCuatrimestre());
		asigBD.setTipo(asig.getTipo());
		asigBD.setCreditos(asig.getCreditos());
		asigBD.setProfesor(profService.findProfesorById((long)asig.getId_profesor()).get());
		asigBD.setGrado(gradoService.findGradoById((long) asig.getId_grado()));
		
		if (asignaturaService.insertarAsignatura(asigBD)==null) {
			return "redirect:/asignaturas/add?error=Existe&asig="+asig.getNombre();
		}
		
		return "redirect:/asignaturas/";
	}
	
	
	@GetMapping("/edit")
	public String editAsig(@RequestParam(name="asig") String asig,Model model) {
		List<Profesor> profesores = profService.getAllProfesores();
		List<Grado> grados = gradoService.getAllGrados();
		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(asig));
		model.addAttribute("asignatura",asignatura.get());	
		model.addAttribute("profesores",profesores);
		model.addAttribute("grados",grados);
		return "editAsignatura";
	}
	
	
	@PostMapping("/edit")
	public String updateAsig(@ModelAttribute Asignatura asig) {
		
		if (asignaturaService.actualizarAsignatura(asig)==null) {
			return "redirect:/asignaturas/edit?error=error&asig"+asig.getId();
		}
		return "redirect:/asignaturas/";
	}
	
	/*
	
	@GetMapping("/editAlumno")
	public String editAlumn(@RequestParam(name="asig") String asig,Model model) {
		
		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(asig));
		model.addAttribute("asignatura",asignatura.get());				
		return "editAsignaturasAlumnos";
	}
	
	
	@PostMapping("/editAlumno")
	public String updateAlumn(@ModelAttribute Asignatura asig) {
		
		if (asignaturaService.actualizarAsignatura(asig)==null) {
			return "redirect:/asignaturas/editAlumno?error=error&asig"+asig.getId();
		}
		return "redirect:/asignaturas/";
	}
	

	@GetMapping("/addAlumno")
	public String addAlumnoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="asig") String nombre,
			Model model) {
		
		AsignaturaAlumnoDTO asig = new AsignaturaAlumnoDTO();
		List<Alumno> alumnos = alumService.getAllAlumnos();

		model.addAttribute("asig", asig);
		model.addAttribute("alumnos",alumnos);
		model.addAttribute("error", error);
		return "addAsignaturaAlumno";
	}
	
	
	@PostMapping("/addAlumno")
	public String addAlumnoPost(@ModelAttribute AsignaturaAlumnoDTO asig,Model model) {
		
		AlumnoAsignatura asigBD = new AlumnoAsignatura();
		asigBD.
		
		if (asignaturaService.insertarAsignatura(asigBD)==null) {
			return "redirect:/asignaturas/addAsignatura?error=Existe&asig="+asig.getNombre();
		}
		
		return "redirect:/asignaturas/";
	}*/
}
