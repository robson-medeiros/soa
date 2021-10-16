package br.ufrpe.dc.restfullservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControlador {
	
	private List<Cliente> clientes;
	
	public ClienteControlador() {
		this.clientes = new ArrayList<Cliente>();
		
		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		cliente1.setNome("Robson Medeiros");
		Endereco end1 = new Endereco();
		end1.setLogradouro("Rua Teste");
		end1.setNumero(334);
		cliente1.setEndereco(end1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2);
		cliente2.setNome("Wagner Medeiros");
		Endereco end2 = new Endereco();
		end2.setLogradouro("Rua do Teste");
		end2.setNumero(90);
		cliente2.setEndereco(end2);
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		
	}
	
	//GET /clientes
	
	@GetMapping("/clientes")
	public List<Cliente> getCliente(){
		
		return clientes;
	}
	
	//GET /clientes/{id}
	
	@GetMapping("/clientes/{id}")
	public Cliente getClienteById(@PathVariable int id) {
		
		for (Iterator iterator = clientes.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			
			if(cliente.getId() == id) {
				return cliente;
			}
			
		}
		return null;
	
	}
	
	//POST /clientes
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public int cadastrarCliente(@RequestBody Cliente cliente) {
		
		int id = this.clientes.size() + 1;
		cliente.setId(id);
		clientes.add(cliente);
		return id;
	}
	
	//DELETE /clientes/{id}
	@DeleteMapping("/clientes/{id}")
	public Cliente remover(@PathVariable int id) {
		
		for (Iterator iterator = clientes.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			
			if(cliente.getId() == id) {
				iterator.remove();
				return cliente;
			}
			
		}
		return null;
		
	}
	
	// PUT /clientes
	
	

}
