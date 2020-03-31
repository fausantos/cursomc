package com.flaviosantos.cursomc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flaviosantos.cursomc.domain.Cliente;
import com.flaviosantos.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	//	Cliente cat1 = new Cliente(1, "Infomatica");
	//	Cliente cat2 = new Cliente(2, "Escritorio");
	///	
///		List<Cliente> listaCliente  = new ArrayList<>();
	//	listaCliente.add(cat1);
	//	listaCliente.add(cat2);
		
		
	//	return listaCliente;	
	}
	
}
