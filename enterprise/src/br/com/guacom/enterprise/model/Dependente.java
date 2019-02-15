package br.com.guacom.enterprise.model;

public class Dependente {
	private Integer id;
	private String nome;
	private Funcionario funcionario;
	
	public Dependente(Integer id, String nome, Funcionario funcionario) {
		this.id = id;
		this.nome = nome;
		this.funcionario = funcionario;
	}
	
	public Dependente(String nome, Funcionario funcionario) {
		this.nome = nome;
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
}