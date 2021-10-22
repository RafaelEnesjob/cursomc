package com.rafaelenes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelenes.cursomc.domain.Categoria;
import com.rafaelenes.cursomc.repositories.CategoriaRepository;
import com.rafaelenes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Id informado não existe " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
