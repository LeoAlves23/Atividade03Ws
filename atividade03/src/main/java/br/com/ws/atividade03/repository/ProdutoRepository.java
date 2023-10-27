package br.com.ws.atividade03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ws.atividade03.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
