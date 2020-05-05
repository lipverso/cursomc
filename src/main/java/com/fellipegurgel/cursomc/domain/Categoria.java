package com.fellipegurgel.cursomc.domain;

import java.io.Serializable;
						//** 6.1 **
public class Categoria implements Serializable {
	//Versao 1 da classe = 1L
	
	//** 6.2 **
	private static final long serialVersionUID = 1L;
	
	//Checklist para classe de dominio (criar entidades)
	//1) Criar Atributos Basicos
	//2) Associacoes (inicie as colecoes)
	//3)  Construtores (Nao incluir colecoes no construtor com parametros
	//4) Getters e Setters
	//5) hashCode e equals (impletancao padrao somente ID), para que
	//os objeto sejam comparados pelo conteudo, nao ponteiro memoria
	//6) Serializable (padrao: 1L). Assim, objetos da classe poderao
	// ser convertidos para uma sequencia de bytes, para que
	// os objetos possam ser gravados em arquivos, trafegar em rede, etc.
	
	// **1**
	private Integer id;
	private String nome;
	
	// **2**
	//Esta classe categoria esta associada com classe Produto
	//Porem, como estou comecando a testar somente a Categoria
	//Nao irei fazer a associacao agora. Ignorar passo 2
	
	//** 3 **
	public Categoria ()
	{
		
	}
	
	public Categoria (Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	//** 4 **
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
	
	// ** 5 **
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
