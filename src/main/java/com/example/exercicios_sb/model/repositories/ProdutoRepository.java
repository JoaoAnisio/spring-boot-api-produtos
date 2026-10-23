package com.example.exercicios_sb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.exercicios_sb.model.entities.Produto;

public interface ProdutoRepository 
	extends CrudRepository<Produto, Integer>,
	PagingAndSortingRepository<Produto, Integer>{

	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome")String parteNome);

}
