package br.com.atos.produto.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.atos.produto.model.Produto;

public interface IProduto {

	public List<Produto> getAll();
	
	public ResponseEntity<?> findProdutoById(Long id);
	
	public ResponseEntity<?> save(Produto produto);
	
	public ResponseEntity<?> update(Produto produto, Long id);
	
	public void delete(Long id);
}
