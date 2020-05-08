package com.fellipegurgel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fellipegurgel.cursomc.domain.Categoria;
import com.fellipegurgel.cursomc.repositories.CategoriaRepository;

@SpringBootApplication						// ** 1 **
public class CursomcApplication implements CommandLineRunner {
	// ** 2 **
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
		//"Macete" para instanciar no momento que aplicacao iniciar, dessa forma o banco de dados sera criado assim que a 
		// a apliacao for executada, nao necessitando ser manualmente inserida no banco de dados
		
		//1) Classe implementa CommandLineRunner, permite implementar um metodo auxiliar para executar uma acao
		// quando a aplicacao iniciar
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Aqui instancio os objetos que estao na instancia preparada (UML)
		//cat1 e cat2
		
		//Deixo ID nulo porque o banco de dados ira gera-la automaticamente
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		//Chamar objeto e chamar operacao para salvar (saveAll para salvar lista de objetos.)
		//Criando este objeto, a lsita sera criada automaticamente no banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		//2) Agora preciso salvar os objetos no banco de dados
		//Quem no banco de dados e capaz de acessar os dados e salvar no objeto?
		//O Repository. Entao CategoriaRepository sera o objeto responsavel por salvar.
		//Entao temos que instancia-lo.
		
		
		
	}

}


