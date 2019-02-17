package br.com.guacom.enterprise.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

public class ConsultorDeVendas extends Funcionario {
	private Integer idConsultor;
	private BigDecimal valorBonusMensal;

	public ConsultorDeVendas(Integer id, String nivel,String nome, List<Dependente> dependentes, BigDecimal valorBonusMensal, String sexo) {
		super(id, nivel, nome, dependentes, sexo);
		if(valorBonusMensal == null)
			throw new IllegalArgumentException("O valor inserido para o campo bônus está incorreto!");
		this.valorBonusMensal = valorBonusMensal;
	}

	public ConsultorDeVendas(String nome, String nivel, List<Dependente> dependentes, BigDecimal valorBonusMensal, String sexo) {
		super(nome, nivel, dependentes, sexo);
		if(valorBonusMensal == null)
			throw new IllegalArgumentException("O valor inserido para o campo bônus está incorreto!");
		this.valorBonusMensal = valorBonusMensal;
	}
	
	public ConsultorDeVendas(String nome, String nivel, BigDecimal valorBonusMensal, String sexo) {
		super(nome, nivel, sexo);
		if(valorBonusMensal == null)
			throw new IllegalArgumentException("O valor inserido para o campo bônus está incorreto!");
		this.valorBonusMensal = valorBonusMensal;
	}

	public ConsultorDeVendas(Integer id, String nome, BigDecimal  valorBonusMensal, String nivel, String sexo) {
		super(id, nivel, nome, sexo);
		if(valorBonusMensal == null)
			throw new IllegalArgumentException("O valor inserido para o campo bônus está incorreto!");
		this.valorBonusMensal = valorBonusMensal;
	}

	public Integer getCodFuncionario() {
		return super.getIdFuncionario();
	}
	
	public Integer getIdConsultor() {
		return idConsultor;
	}

	public BigDecimal getValorBonusMensal() {
		return valorBonusMensal;
	}

	@Override
	public BigDecimal calcularSalario() {
		double valor = super.calcularSalario().doubleValue() + valorBonusMensal.doubleValue();
		return BigDecimal.valueOf(valor);
	}
	
	@Override
	public String tipoFuncionario() {
		return String.format(new Locale("pt", "BR"), "Consultor");
	}
}