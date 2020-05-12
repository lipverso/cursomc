package com.fellipegurgel.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//Checar checklist material de apoio para criar as entidades (JavaBeans)
//Indicar que e uma entidade
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private Double preco;

	// Um produto tem uma ou mais categorias. Criar lista de categorias
	// Apos todos mapeamentos feitos, falta mapear o relacionamento. Por exemplo,
	// entre as classes Produto e Categoria, existe um relacionamento.
	// Como existe relacionamento de muito para muitos, tenho que fazer tal
	// mapeamento
	// utilizando as anotacoes do JPA.
	// Quando se tem duas tabelas com relacao muitos pra muitos, sera criada uma\
	// terceita tabela contendo os IDs das tuas tabelas.
	// No JPA quando voce tem uma lista de cada lado, coloca-se @ManyToMany
	// nos dois lados
	// e em seguida colocar anotacao @JoinTable, que ira definidir a tabela
	// que ira fazer o muitos pra muitos no banco de dados relacional
	
	@ManyToMany //name sera o nome da terceira tabela criada.
	@JoinTable(name = "PRODUTO_CATEGORIA",
	//JoinColumn e para espificar qual sera o nome da tabela correspondente ao codigo do produto. Chave Estrangeira
		joinColumns = @JoinColumn(name = "produto_id"),
	//Apos isso, inverseJoinColumns para colocar nome da outra chave estrangeira que ira referenciar a Categoria
		inverseJoinColumns = @JoinColumn(name = "categoria_id")	
	)
	private List<Categoria> categorias = new ArrayList<>();

	public Produto() {

	}

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

}
