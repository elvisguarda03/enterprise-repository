package br.com.guacom.enterprise.model;

public class Dependente {
	private Integer id;
	private String nome;
	private Funcionario funcionario;

	public Dependente(Integer id, String nome, Funcionario funcionario) {
		if (id == null || nome == null || funcionario == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.id = id;
		this.nome = nome;
		this.funcionario = funcionario;
	}

	public Dependente(String nome, Funcionario funcionario) {
		if (nome == null || funcionario == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.nome = nome;
		this.funcionario = funcionario;
	}

	public Dependente(Integer id, String nome) {
		if (id == null || nome == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.id = id;
		this.nome = nome;
	}

	public Integer getIdDependente() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
}