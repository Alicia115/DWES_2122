package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
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
	
	@RequestMapping("/departments")
	public String departaments(Model model) {
		
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		
		model.addAttribute("departamentos",departamentos);
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
		
		return "redirect:/departments";
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
		return "redirect:/departments";
	}
	
	
	
	
}
