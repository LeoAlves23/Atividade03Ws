package br.com.ws.atividade03.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @Column(nullable = false)
    private String nome;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

   @ManyToMany
    @JoinTable(name = "categorias_produtos",
        joinColumns = @JoinColumn(name = "id_categoria_fk"),
        inverseJoinColumns = @JoinColumn(name="id_produto_fk"))


    List<Produto> produto;

}
