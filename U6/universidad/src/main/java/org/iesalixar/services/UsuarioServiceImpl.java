package org.iesalixar.services;

import org.iesalixar.model.Usuario;
import org.iesalixar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository userRepo;
	
	@Override
	public Usuario insertUsuario(Usuario usuario) {
		
		if (usuario!=null) {
			
			return userRepo.save(usuario);
		}
		
		return null;
		
	}

	
}