package com.fellipegurgel.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
				
//Para criar tabela Categoria com Id e nome:
// Para usar JPA e fazer mapeamento objeto relacional, primeiro adicionar
// 1. @Entity indicando que essa classe sera uma entidade do JPA.
@Entity
public class Categoria implements Serializable {
	//Versao 1 da classe = 1L
	private static final long serialVersionUID = 1L;
	
	//2. Adicionar @id em cima do campo id (chave primaria da tabela do banco)
	
	@Id 
	//3. Definir geracao automatica de IDs (usando a estrategia seguinte), utilizando @GeneratedValue
	// O Identity e compativel com o Banco de Dados H2. Dependendo do banco de dados
	// utilizando, tera que ser usado outro tipo de chave primaria.
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//Comecando com associacoes, uma categoria tera varios produtos, entao, uma lista de produtos. Inicia-la
	//Fazer isso apos criar a classe Produtos (obviamente)
	//Adicionar o mapeamento @ManyToMany e especificar que este mapemaento e apenas um outro lado de um outro
	// mapeamento que foi feito em cima do atributo "categorias"
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	
	public Categoria ()
	{
		
	}
	
	public Categoria (Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	

	
	
	
	
	 
	
	
	
	

}
