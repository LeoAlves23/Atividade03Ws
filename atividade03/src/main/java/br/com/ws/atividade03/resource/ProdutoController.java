package br.com.ws.atividade03.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ws.atividade03.domain.Produto;
import br.com.ws.atividade03.error.ApiError;
import br.com.ws.atividade03.service.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id){
        try {
            Produto produto = produtoService.findById(id);
            return ResponseEntity.ok().body(produto);
        } catch (Exception e) {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), "Produto não encontrado!", "/api/v1/produtos/"+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Produto> criarProduto(@RequestBody final Produto produto){
        produtoService.save(produto);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        List<Produto> produto = produtoService.findAll();
        return ResponseEntity.ok().body(produto);

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produto){
        Produto produtoOriginal = produtoService.findById(id);
        produtoOriginal.setNome(produto.getNome());
        produtoService.update(produtoOriginal);
        return new ResponseEntity<Produto>(produtoOriginal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable("id")Long id){
        produtoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
