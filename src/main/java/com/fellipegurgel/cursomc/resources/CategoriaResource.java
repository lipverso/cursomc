package com.fellipegurgel.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Adicionar RestController e RequestMapping para iniciar REST
@RequestMapping(value="/Categorias") //Nome no Plural da Classe, geralmente
public class CategoriaResource {
	
	//Como isso e uma requisicao para obter dados, eu uso o GET
	//E importante usar os verbos adequados
	// POST = Se eu fosse salvar / criar um novo dado
	// DELETE = Se eu fosse deletar algo
	@RequestMapping(method=RequestMethod.GET)
	public String listar() 
	{
		return "REST esta funcionando";
		//Para isso ser uma funcao REST, tenho que associar ela com
		//algum dos verbos HTTP.
	}
	
}
