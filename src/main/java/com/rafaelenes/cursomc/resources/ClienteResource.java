package com.rafaelenes.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelenes.cursomc.domain.Cliente;
import com.rafaelenes.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = clienteService.buscarClienteId(id);
		return ResponseEntity.ok().body(obj);
	}
	

	
	@GetMapping
	public ResponseEntity<?> buscarClienteDocumento(@RequestParam (name = "buscarDocumento") String documento) {
		Cliente obj = clienteService.buscarClienteDocumento(documento);
		return ResponseEntity.ok().body(obj);
	}


}


//@GetMapping("/{clienteId}") ASSIM NÃO FUNCIONA POIS NÃO TA PASSANDO PARAMETRO 
//public ResponseEntity<?> find(@PathVariable Integer id) {
//	Cliente obj = clienteService.buscarClienteId(id);
//	return ResponseEntity.ok().body(obj);
//}
