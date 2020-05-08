package com.fellipegurgel.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fellipegurgel.cursomc.domain.Categoria;
import com.fellipegurgel.cursomc.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

//Atualizando o Resource (Controlador Rest) para ser capaz de buscar uma categoria
// 1) Acrescentar que no end point categoria ainda vai receber o id da categoria, nao somente a palavra categoria. 

@RestController 
@RequestMapping(value="/categorias") 
public class CategoriaResource {
	
	// ** 4 **
	@Autowired
	private CategoriaService service;
	
	// ** 1 **
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	//Isto significa que o end point do metodo abaixo agora sera /categorias/id
	//2) Em seguida, tenho que alterar o metodo para especificar que ele ira receber 
	//como parametro uma id que vai vir na minha URL.
	//Para que o Spring saiba que esse id da url vai ter que vir pro id da variavel,
	// incluo a anotacao @PathVariable
	
	//3)Alterar o retorno do metodo para ResponseEntity. Este e um tipo especial
	//do Spring que ja encapsula varias informacoes de uma resposta HTTP para um servico REST
	// Passarei o tipo ? para informar que pode ser de qualquer tipo (encontrar, nao encontrar,etc.)
	public ResponseEntity<?> find(@PathVariable Integer id) 
	{
		//4) O que seria encontrar uma Categoria com o id acima?
		// Vou adicionar uma declaracao CategoriaService service, colocar o @Autowired
		// e dentro do metodo: 
		//5) adiciono uma declaracao de uma categoria obj recebendo o servico find, metodo que implementamos
		// anteriormente no CategoriaService
		
		// ** 5 **
		Categoria obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
}
