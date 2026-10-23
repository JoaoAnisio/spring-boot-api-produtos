package com.example.exercicios_sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercicios_sb.model.entities.Produto;
import com.example.exercicios_sb.model.repositories.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Produto salvarProduto(@RequestBody @Valid Produto prod) {
		return produtoRepository.save(prod);
	}

	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		return produtoRepository.searchByNameLike(parteNome);
	}

	@GetMapping("/pagina/{numPag}/{qtdePag}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numPag, @PathVariable int qtdePag) {
		if(qtdePag >= 5) qtdePag = 5;
		Pageable page = PageRequest.of(numPag, qtdePag);
		return produtoRepository.findAll(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirProduto(@PathVariable int id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
