package com.rafaelenes.cursomc.services;

import com.rafaelenes.cursomc.domain.Pedido;
import com.rafaelenes.cursomc.repositories.PedidoRepository;
import com.rafaelenes.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Id informado não existe " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
