package org.iesalixar.controller;

import java.util.List;

import org.iesalixar.dto.DepartamentoDTO;
import org.iesalixar.dto.UsuarioDTO;
import org.iesalixar.model.Departamento;
import org.iesalixar.model.Usuario;
import org.iesalixar.services.AsignaturaServiceImpl;
import org.iesalixar.services.DepartamentoServiceImpl;
import org.iesalixar.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	DepartamentoServiceImpl departamentoService;
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("contenido","ABOUT");
		return "about";
	}
	
	@RequestMapping("/departments")
	public String products(Model model) {
		
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		
		model.addAttribute("contenido","PRODUCTOS");
		model.addAttribute("departamentos",departamentos);
		return "departments";
	}
	
	@RequestMapping("/services")
	public String services(Model model)  {
		model.addAttribute("contenido","SERVICIOS");
		return "services";
	}
	
	
	@GetMapping("/register")
	public String registerGet(Model model) {
		
		UsuarioDTO userDTO = new UsuarioDTO();		
		model.addAttribute("usuario", userDTO);		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute UsuarioDTO usuario) {
		
		Usuario userBD = new Usuario();
		userBD.setActivo(true);
		userBD.setNombre(usuario.getNombre());
		userBD.setApellidos(usuario.getApellidos());
		userBD.setUserName(usuario.getUsuario());
		userBD.setRole("ROLE_USER");
		userBD.setEmail(usuario.getEmail());		
		userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));
		
		userBD = usuarioService.insertUsuario(userBD);
		
		if (userBD==null) {
			return "redirect:/register";
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping("/asignaturas") 
	public String asignaturas(Model model) {
		
		model.addAttribute("asignaturas", asignaturaService.getAllAsignaturas());
		
		return "asignaturas";
	}

	
	@GetMapping("/departments/add")
	public String departmentsGet(Model model) {
		
		DepartamentoDTO departamentoDTO = new DepartamentoDTO();		
		model.addAttribute("departamento", departamentoDTO);		
		return "register";
	}
	
	@PostMapping("/departments/add")
	public String departmentsPost(@ModelAttribute UsuarioDTO usuario) {
		
		Usuario userBD = new Usuario();
		userBD.setActivo(true);
		userBD.setNombre(usuario.getNombre());
		userBD.setApellidos(usuario.getApellidos());
		userBD.setUserName(usuario.getUsuario());
		userBD.setRole("ROLE_USER");
		userBD.setEmail(usuario.getEmail());		
		userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));
		
		userBD = usuarioService.insertUsuario(userBD);
		
		if (userBD==null) {
			return "redirect:/register";
		}
		
		return "redirect:/";
	}
	
}
