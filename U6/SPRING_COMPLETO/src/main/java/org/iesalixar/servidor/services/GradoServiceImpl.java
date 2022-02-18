package org.iesalixar.servidor.services;

import org.iesalixar.servidor.repository.DepartamentoRepository;
import org.iesalixar.servidor.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradoServiceImpl implements GradoService{
	
	@Autowired
	GradoRepository gradoRepo;

}
