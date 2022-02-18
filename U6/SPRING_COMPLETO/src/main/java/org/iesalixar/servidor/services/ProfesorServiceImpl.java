package org.iesalixar.servidor.services;

import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	ProfesorRepository profrepo;

}
