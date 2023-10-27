package br.com.ws.atividade03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ws.atividade03.domain.Produto;
import br.com.ws.atividade03.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public void save(Produto produto) {
        produtoRepository.save(produto);
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void update(Produto produto) {
        if (produtoRepository.existsById(produto.getId())){
            produtoRepository.save(produto);
        }
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }


}
