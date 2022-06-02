package br.com.atos.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atos.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
