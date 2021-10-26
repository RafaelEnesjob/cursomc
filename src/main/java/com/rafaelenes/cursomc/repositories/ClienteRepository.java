package com.rafaelenes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelenes.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
