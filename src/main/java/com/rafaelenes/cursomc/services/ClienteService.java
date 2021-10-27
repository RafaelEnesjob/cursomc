package com.rafaelenes.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelenes.cursomc.domain.Cliente;
import com.rafaelenes.cursomc.repositories.ClienteRepository;
import com.rafaelenes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repocli;
	
	public Cliente buscarClienteId(Integer id) {
		Optional<Cliente> obj = repocli.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Id do cliente inválido " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente buscarClienteDocumento(String documento) {
		Optional<Cliente> obj = repocli.findByDocumento(documento);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"CPF ou CNPJ do cliente inválido" + documento + ", Tipo: " + Cliente.class.getName()));			
				
	}

}



