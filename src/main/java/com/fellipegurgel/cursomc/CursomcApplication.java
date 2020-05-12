package com.fellipegurgel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fellipegurgel.cursomc.domain.Categoria;
import com.fellipegurgel.cursomc.domain.Produto;
import com.fellipegurgel.cursomc.repositories.CategoriaRepository;
import com.fellipegurgel.cursomc.repositories.ProdutoRepository;

@SpringBootApplication					
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	// ** 5 **
	@Autowired 
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
		//"Macete" para instanciar no momento que aplicacao iniciar, dessa forma o banco de dados sera criado assim que a 
		// a apliacao for executada, nao necessitando ser manualmente inserida no banco de dados
		
		//Classe implementa CommandLineRunner, permite implementar um metodo auxiliar para executar uma acao
		// quando a aplicacao iniciar
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//Deixo ID nulo porque o banco de dados ira gera-la automaticamente
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		//1. Criada a Classe Produto, tambem tenho que instanciar os 3 produtos
		Produto p1 = new Produto(null, "Computador",200.00);
		Produto p2 = new Produto(null, "Impressora",800.00);
		Produto p3 = new Produto(null, "Mouse",80.00);
		
		//2. Porem, as Listas que contem que produto pertence a qual categoria e vice-versa
		//Ainda estao vazias.Entao, tenho que pegar a cat1 e falar que ela estao associadas
		//a os 3 produtos acima, conforme diagrama, e a cat2 apenas com Produto 2. Pra isso:
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//3. Agora as categorias ja conhecem qual produtos estao associadas a elas. Porem,
		//os produtos ainda nao conhecem qual categorias estao associadas a eles, entao:
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		//Chamar objeto e chamar operacao para salvar (saveAll para salvar lista de objetos.)
		//Criando este objeto, a lsita sera criada automaticamente no banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		//4. Agora tenho que criar um repository para produtos para salvar os produtos
		//Copiei e coloei CategoriaRepository e alterei o nome para ProdutoRepository
		
		//5. Instanciar ProdutoRepository
		
		//6 . Mandar salvar todos os produtos
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
		
		
	}

}


