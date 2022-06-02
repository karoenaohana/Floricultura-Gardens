package br.com.atos.produto.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.atos.produto.model.Produto;
import br.com.atos.produto.repository.ProdutoRepository;
import br.com.atos.produto.service.impl.IProduto;

@Service
public class ProdutoService implements IProduto {
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}
	
	public ResponseEntity<?> findProdutoById(Long id) {
		Produto produtoId = produtoRepository.findById(id).orElse(null);
		if (produtoId != null)
			return new ResponseEntity<>(produtoId, HttpStatus.OK);
		return new ResponseEntity<>("ID do produto informado não existe na base de dados.", HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> save(Produto produto) {
		return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> update(Produto produto, Long id) {

			if (findProdutoById(id) != null) {
				Produto produtoSaved = produtoRepository.findById(id).orElse(null);

				if ((produtoSaved != null && produtoSaved.getId() == id)) {
					produtoSaved.setId(id);
					produtoSaved.setNome(produto.getNome());
					produtoSaved.setPreco(produto.getPreco());
					produtoSaved.setQuantidade(produto.getQuantidade());
					produtoSaved.setCodigo(produto.getCodigo());
					produtoSaved.setCategoria(produto.getCategoria());


					return new ResponseEntity<>(produtoRepository.save(produtoSaved), HttpStatus.CREATED);
				}
				return new ResponseEntity<>("ID do Produto não existe.", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("ID informado para atualização não existe na base de dados.",
					HttpStatus.NOT_FOUND);
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}


}
