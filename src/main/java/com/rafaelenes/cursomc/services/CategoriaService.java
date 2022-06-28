package com.rafaelenes.cursomc.services;

import com.rafaelenes.cursomc.domain.Categoria;
import com.rafaelenes.cursomc.repositories.CategoriaRepository;
import com.rafaelenes.cursomc.services.exceptions.DataIntegrityException;
import com.rafaelenes.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Id informado não existe " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Categoria obj) {
        findById(obj.getId());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw  new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }
}
