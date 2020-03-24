package com.flaviosantos.cursomc.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flaviosantos.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Infomatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria> listaCategoria  = new ArrayList<>();
		listaCategoria.add(cat1);
		listaCategoria.add(cat2);
		
		
		return listaCategoria;	
	}
	
}
