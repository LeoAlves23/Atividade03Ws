package br.com.ws.atividade03.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ws.atividade03.domain.Categoria;
import br.com.ws.atividade03.error.ApiError;
import br.com.ws.atividade03.service.CategoriaService;

@Controller
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok().body(categorias);
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody final Categoria categoria){
        categoriaService.save(categoria);
        return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id){
        try {
            Categoria categoria = categoriaService.findById(id);
            return ResponseEntity.ok().body(categoria);
        } catch (Exception e) {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), "Categoria não encontrada!","/api/v1/categorias/"+id );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria>atualizarCategoria(@PathVariable("id")Long id, @RequestBody Categoria categoria){
        Categoria categoriaOriginal = categoriaService.findById(id);
        categoriaOriginal.setNome(categoria.getNome());
        categoriaService.update(categoriaOriginal);
        return new ResponseEntity<Categoria>(categoriaOriginal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable("id") long id){
        categoriaService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
