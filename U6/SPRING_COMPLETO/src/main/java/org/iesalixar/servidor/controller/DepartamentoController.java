package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.dto.DepartamentoProfesorDTO;
import org.iesalixar.servidor.dto.GradoAsignaturaDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;
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
public class DepartamentoController {
	
	@Autowired
	DepartamentoServiceImpl departamentoService;
	
	@Autowired
	ProfesorServiceImpl profesorService;
	
	@RequestMapping("/departments")
	public String departaments(Model model,
			@RequestParam(required=false,name="correctoadd") String correctoadd,
			@RequestParam(required=false,name="correctoupdate") String correctoupdate){
		
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		
		model.addAttribute("departamentos",departamentos);
		if(correctoadd!=null) {
            model.addAttribute("correctoadd", correctoadd);
        }
		if(correctoupdate!=null) {
            model.addAttribute("correctoupdate", correctoupdate);
        }
		return "departments";
	}
	
	@GetMapping("/departments/add")
	public String addDepartmentGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="dpto") String nombre,
			Model model) {
		
		DepartamentoDTO dpto = new DepartamentoDTO();
		
		model.addAttribute("dpto", dpto);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addDepartment";
	}
	
	
	@PostMapping("/departments/add")
	public String addDepartmentPost(@ModelAttribute DepartamentoDTO dpto,Model model) {
		
		Departamento dptoBD = new Departamento();
		dptoBD.setNombre(dpto.getNombre());
		
		if (departamentoService.insertarDepartamento(dptoBD)==null) {
			return "redirect:/departments/add?error=Existe&dpto="+dpto.getNombre();
		}
		
		return "redirect:/departments?correctoadd=addDepartment";
	}
	
	@GetMapping("/departments/edit")
	public String editDpto(@RequestParam(name="dpto") String dpto,Model model) {
		
		
		Departamento department = departamentoService.findDepartamentoById(Long.parseLong(dpto));
		model.addAttribute("department", department);
		return "editDepartment";
	}
	
	
	@PostMapping("/departments/edit")
	public String updateDpto(@ModelAttribute Departamento dpto) {
		
		if (departamentoService.actualizarDepartamento(dpto)==null) {
			return "redirect:/departments/edit?error=error&dpto"+dpto.getId();
		}
		return "redirect:/departments?correctoupdate=updateDepartment";
	}
	
	
	@GetMapping("/departments/profesores")
	public String profesoresDepartamento(
			@RequestParam(required=false,name="dpto") String dpto,
			@RequestParam(required=false,name="correcto") String correcto,
			@RequestParam(required=false,name="correctoaddProf") String correctoaddProf,
			Model model) {
		
		Departamento dptoEntity = departamentoService.findDepartamentoById(Long.parseLong(dpto));
		
		if (dpto==null || dptoEntity == null) {
			return "redirect:/departments";
		}
		
		model.addAttribute("departamento", dptoEntity);	
		if(correcto!=null) {
            model.addAttribute("correcto", correcto);
        }
		if(correctoaddProf!=null) {
            model.addAttribute("correctoaddProf", correctoaddProf);
        }
		
		return "profesoresDepartment";
	}
	
	
	@GetMapping("/departments/profesor/delete")
	public String borrarProfesorDepartamento(			
			@RequestParam(required=false,name="prof") String prof,
			Model model) {
		
		Profesor profEntity = profesorService.findProfesorById(Long.parseLong(prof)).get();
		Long dptoId = profEntity.getDepartamento().getId();
		
		profEntity.setDepartamento(null);
		
		profesorService.actualizarProfesor(profEntity);
		
		return "redirect:/departments/profesores?dpto="+dptoId+"&correcto=deleteProfDepart";
		
	}
	
	@GetMapping("/departments/addprofesor")
	public String addProfDepartGet(@RequestParam(required=false,name="error") String error, @RequestParam(required=false,name="id_depart") String id_depart, Model model) {
		
		DepartamentoProfesorDTO profDepart = new DepartamentoProfesorDTO();
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		List<Profesor> profesores = profesorService.getAllProfesores();
		model.addAttribute("profDepart", profDepart);
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("profesores", profesores);
		model.addAttribute("error",error);
		if(id_depart!=null) {
			model.addAttribute("id_depart", id_depart);
		}
		return "addProfDepartamento";
	}
	
	@PostMapping("/departments/addprofesor")
	public String addProfDepartPost(@ModelAttribute DepartamentoProfesorDTO profDepart,Model model) {
		
		Departamento departamento = departamentoService.findDepartamentoById(profDepart.getId_departamento());
		Profesor profesor = profesorService.findProfesorById(profDepart.getId_profesor()).get();
		
		if(departamento != null && profesor != null) {
			
			profesor.setDepartamento(departamento);
			profesorService.actualizarProfesor(profesor);
			
			return "redirect:/departments/profesores?dpto="+departamento.getId()+"&correctoaddProf=correctAddProfDepart";

		} else {	
			return "redirect:/departments/addprofesor?error=errorAddProfDepart";
		}

	}
	
}
