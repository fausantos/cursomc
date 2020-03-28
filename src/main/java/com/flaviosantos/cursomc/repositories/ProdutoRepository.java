package com.flaviosantos.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.flaviosantos.cursomc.domain.Categoria;
import com.flaviosantos.cursomc.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	
}
