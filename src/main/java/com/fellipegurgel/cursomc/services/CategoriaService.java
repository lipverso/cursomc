package com.fellipegurgel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fellipegurgel.cursomc.domain.Categoria;
import com.fellipegurgel.cursomc.repositories.CategoriaRepository;


/* 1) Adicionar anotacao @Service do Spring
 * 2) Criar uma operacao Capaz de buscar uma categoria por codigo
 */

// ** 1 ** 
@Service
public class CategoriaService {
	
	//Quando voce declara uma dependencia dentro de uma classe e adiciona
	//a anotacao @Autowired, essa dependencia sera automaticamente instanciada pelo Spring
	// pelo mecanismo de injecao de dependencia ou inversao de controle
	
	// 4) Como faco para usar o objeto repo para buscar no banco de dados Categoria
	// dado um certo ID? Adicionar como parametro o Integer id, e adicionar o codigo de busca.
	
	// ** 3 **
	@Autowired
	private CategoriaRepository repo;

	// ** 2 **			** 4 **
	public Categoria find(Integer id) {
		//Como implementar um servico que busca uma categoria?
		// Este servico tera que chamar uma operacao do objeto de acesso a dados
		//(objeto do tipo CategoriaRepository
		//3) Para isso, temos que declarar um objeto do tipo CategoriaRepository.
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		}
	

	
}
