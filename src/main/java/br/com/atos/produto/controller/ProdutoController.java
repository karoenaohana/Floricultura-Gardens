package br.com.atos.produto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.atos.produto.model.Produto;
import br.com.atos.produto.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
	
	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@ApiOperation(value = "Retorna uma lista de Produtos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma lista de Produtos"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/")
	public List<Produto> getAll() {
		return produtoService.getAll();
	}
	
	@ApiOperation(value = "Retorna um Produto pelo ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um Produto pelo ID"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<?> findProdutoById(@PathVariable Long id) {
		return produtoService.findProdutoById(id);
	}
	
	@ApiOperation(value = "Registra um novo produto")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Registra um novo produto"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody Produto produto) {		
		return produtoService.save(produto);
	}
	
	@ApiOperation(value = "Altera os dados de um Produto previamente registrado informando um ID")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Altera os dados de um Produto previamente registrado informando um ID"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Produto produto, @PathVariable Long id) {
		return produtoService.update(produto, id);
	}
	
	@ApiOperation(value = "Remove os dados de um Produto previamente registrado informando um ID.")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Remove os dados de um Produto previamente registrado informando um ID."),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if(produtoService.findProdutoById(id) != null) {
			produtoService.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>("Erro na tentativa de remoção: ID do Produto informando não existe.", HttpStatus.NOT_FOUND);
	}

}
