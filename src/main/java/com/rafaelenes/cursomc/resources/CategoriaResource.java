package com.rafaelenes.cursomc.resources;

import com.rafaelenes.cursomc.domain.Categoria;
import com.rafaelenes.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@GetMapping("/{id}") NÃO FUNCIONA ASSIM POIS NÃO DA PRA CONVERTER DE <CATEGORIA> PARA OPTIONAL
//	public ResponseEntity<?> find(@PathVariable Integer id) {
//		Optional<Categoria> obj = service.buscar(id);
//		return ResponseEntity.ok().body(obj);
//	}
	
}
