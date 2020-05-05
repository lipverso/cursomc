package com.fellipegurgel.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fellipegurgel.cursomc.domain.Categoria;

@RestController //Adicionar RestController e RequestMapping para iniciar REST
@RequestMapping(value="/Categorias") //Nome no Plural da Classe, geralmente
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	// 4. Alterar o nome do metodo para retornar uma lista de categorias
	public List <Categoria> listar() 
	{
		//1. Instanciando os primeiros dois objetos Categoria
		Categoria cat1 = new Categoria(1,"Informatica");
		Categoria cat2 = new Categoria (2,"Escritorio");
		
		//2. Criando Lista de Categorias
		//Como List e uma interface, ao criar o objeto e necessario
		// usar uma classe que possa ser implementada, como a ArrayList
		List <Categoria> lista = new ArrayList<>();
		
		// 3. Adicionando os bojetos cat1 e cat2 a lista
		lista.add(cat1);
		lista.add(cat2);
		
		// 5. Retornar a lista
		return lista;
	}
	
}
