package br.com.ws.atividade03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ws.atividade03.domain.Categoria;
import br.com.ws.atividade03.domain.Produto;
import br.com.ws.atividade03.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    Categoria categoria1 = new Categoria();
    Produto produto1 = new Produto();


    public  List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void update(Categoria categoria) {
        if(categoriaRepository.existsById(categoria.getId())){
            categoriaRepository.save(categoria);
        }
    }

    public void delete(long id) {
        categoriaRepository.deleteById(id);
    }

}
