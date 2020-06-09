package br.com.tcc.DTO;

import java.math.BigDecimal;
import java.util.List;

import br.com.tcc.models.Usuarios;
import br.com.tcc.services.JurosService;

public class InvestimentosDTO {
	
	private Usuarios usuario;
	
	private JurosService juros;
	
	private BigDecimal valorParcela;
	
	private Integer qntMeses;
	
	private List<BigDecimal> parcelas; 
	
	private BigDecimal rendimentoMensal;
	
	private BigDecimal totalInvestido;
	
	private BigDecimal totalFinal;


	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public JurosService getJuros() {
		return this.juros;
	}

	public void setJuros(JurosService juros) {
		this.juros = juros;
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

	public List<BigDecimal> getParcelas() {
		return this.parcelas;
	}

	public void setParcelas(List<BigDecimal> parcelas) {
		this.parcelas = parcelas;
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

}
