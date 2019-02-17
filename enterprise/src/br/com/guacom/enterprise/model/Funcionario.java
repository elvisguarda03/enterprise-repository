package br.com.guacom.enterprise.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Funcionario {
	private Integer id;
	private String nome;
	private String sexo;
	private List<Dependente> dependentes;
	private String nivel;

	public Funcionario(Integer id, String nivel, String nome, List<Dependente> dependentes, String sexo) {
		if (id == null || nivel == null || nome == null || dependentes == null || sexo == null)
			throw new IllegalArgumentException("Não foram preenchidos todos os campos.");
		this.nome = nome;
		this.dependentes = dependentes;
		this.id = id;
		this.nivel = nivel;
		this.sexo = sexo;
	}

	public Funcionario(String nome, String nivel, List<Dependente> dependentes, String sexo) {
		if (nome == null || nivel == null || dependentes == null)
			throw new IllegalArgumentException("Não foram preenchidos todos os campos.");
		this.nome = nome;
		this.dependentes = dependentes;
		this.nivel = nivel;
		this.sexo = sexo;
	}

	public Funcionario(Integer id, String nivel, String nome, String sexo) {
		if (id == null || nivel == null || nome == null || sexo == null)
			throw new IllegalArgumentException("Não foram preenchidos todos os campos.");
		this.nome = nome;
		this.id = id;
		if (nivel.compareToIgnoreCase("Senior") == 0)
			this.nivel = nivel.replace('e', 'ê');
		else
			this.nivel = nivel;
		this.sexo = sexo;
	}

	public Funcionario(String nome, String nivel, String sexo) {
		if (nome == null || nivel == null || sexo == null)
			throw new IllegalArgumentException("Não foram preenchidos todos os campos.");
		this.nome = nome;
		if (nivel.compareToIgnoreCase("Senior") == 0)
			this.nivel = nivel.replace('e', 'ê');
		else
			this.nivel = nivel;
		this.sexo = sexo;
	}

	public Funcionario(Integer id) {
		if (nome == null || nivel == null || sexo == null)
			throw new IllegalArgumentException("Não foram preenchidos todos os campos.");
		this.id = id;
	}

	public BigDecimal calcularSalario() {
		if (nivel.equals("Trainee"))
			return BigDecimal.valueOf(2000.00);
		else if (nivel.equals("Pleno"))
			return BigDecimal.valueOf(3500.00);
		return BigDecimal.valueOf(5000.00);
	}

	public Integer getIdFuncionario() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null)
			throw new IllegalArgumentException("O id não foi gerado.");
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public List<Dependente> getDependentes() {
		return Collections.unmodifiableList(dependentes);
	}

	public String getNivel() {
		return nivel;
	}

	public void setDependentes(List<Dependente> dependentes) {
		if (dependentes == null)
			throw new IllegalArgumentException("Os dependentes não foram cadastrados!");
		this.dependentes = dependentes;
	}

	public String tipoFuncionario() {
		return String.format(new Locale("pt", "BR"), "Normal");
	}
}