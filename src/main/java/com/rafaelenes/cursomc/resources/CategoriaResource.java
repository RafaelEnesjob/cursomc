package com.rafaelenes.cursomc.resources;

import com.rafaelenes.cursomc.domain.Categoria;
import com.rafaelenes.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = categoriaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}
	
//	@GetMapping("/{id}") NÃO FUNCIONA ASSIM POIS NÃO DA PRA CONVERTER DE <CATEGORIA> PARA OPTIONAL
//	public ResponseEntity<?> find(@PathVariable Integer id) {
//		Optional<Categoria> obj = service.buscar(id);
//		return ResponseEntity.ok().body(obj);
//	}
	
}
