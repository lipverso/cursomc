package com.fellipegurgel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fellipegurgel.cursomc.domain.Categoria;
import com.fellipegurgel.cursomc.domain.Produto;

// ** 1 **
@Repository

// ** 2 **
//A interface vai extender outra interface chamada JpaRepository. Tipo Especial
// do Spring capaz de acessar os dados com base em um tipo que eu passar, no caso objetos
// do tipo Categoria. Em seguida, colocar o tipo do atributo identificador. Nesse caso, o Id e 
// um Integer.

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	//Como fazer classe capaz de acessar banco de dados, consultar para acessar
	//dados da tabela Produto?
	//1) Adicionar anotacao @Repository logo acima da classe
	//2) Na verdade o Repository nao sera uma classe, e sim uma interface
	// Apos estas implementacoes, um objeto como este sera capaz de realizar operacoes
	// de acesso a dados (busca, salvar, alterar, deletar, etc) referentes ao objeto categoria
	// que por sua vez esta mapeado a tabela Categoria no banco de dados
}
