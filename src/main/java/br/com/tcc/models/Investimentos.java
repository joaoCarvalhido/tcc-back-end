package br.com.tcc.models;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Investimentos {

	private Long id;
	
	private Usuarios usuario;
	
	private BigDecimal valorParcela;
	
	private Integer qntMeses;
	
	private BigDecimal rendimentoMensal;
	
	private BigDecimal totalInvestido;
	
	private BigDecimal totalFinal;
	
	private ArrayList<BigDecimal> rendimentoParcelas = new ArrayList<BigDecimal>();
	private ArrayList<BigDecimal> valoresAplicados = new ArrayList<BigDecimal>();
	private ArrayList<BigDecimal> apenasRendimento = new ArrayList<BigDecimal>();
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuarios getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public BigDecimal getValorParcela() {
		return this.valorParcela;
	}
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	public Integer getQntMeses() {
		return this.qntMeses;
	}
	public void setQntMeses(Integer qntMeses) {
		this.qntMeses = qntMeses;
	}
	public BigDecimal getRendimentoMensal() {
		return this.rendimentoMensal;
	}
	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
	public BigDecimal getTotalInvestido() {
		return this.totalInvestido;
	}
	public void setTotalInvestido(BigDecimal totalInvestido) {
		this.totalInvestido = totalInvestido;
	}
	public BigDecimal getTotalFinal() {
		return this.totalFinal;
	}
	public void setTotalFinal(BigDecimal totalFinal) {
		this.totalFinal = totalFinal;
	}
	public ArrayList<BigDecimal> getRendimentoParcelas() {
		return this.rendimentoParcelas;
	}
	public void setRendimentoParcelas(ArrayList<BigDecimal> rendimentoParcelas) {
		this.rendimentoParcelas = rendimentoParcelas;
	}
	public ArrayList<BigDecimal> getValoresAplicados() {
		return this.valoresAplicados;
	}
	public void setValoresAplicados(ArrayList<BigDecimal> valoresAplicados) {
		this.valoresAplicados = valoresAplicados;
	}
	public ArrayList<BigDecimal> getApenasRendimento() {
		return this.apenasRendimento;
	}
	public void setApenasRendimento(ArrayList<BigDecimal> apenasRendimento) {
		this.apenasRendimento = apenasRendimento;
	}

	
}
