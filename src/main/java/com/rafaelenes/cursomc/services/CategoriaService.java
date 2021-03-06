package com.rafaelenes.cursomc.services;

import com.rafaelenes.cursomc.domain.Categoria;
import com.rafaelenes.cursomc.domain.Cliente;
import com.rafaelenes.cursomc.dto.CategoriaDTO;
import com.rafaelenes.cursomc.repositories.CategoriaRepository;
import com.rafaelenes.cursomc.services.exceptions.DataIntegrityException;
import com.rafaelenes.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Categoria newObj = findById(obj.getId());
        updateData(newObj, obj);
        return categoriaRepository.save(newObj);
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

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO objDto) {
        return new Categoria(objDto.getId(), objDto.getNome());
    }

    private void updateData(Categoria newObj, Categoria obj) {
        newObj.setNome(obj.getNome());
    }
}
