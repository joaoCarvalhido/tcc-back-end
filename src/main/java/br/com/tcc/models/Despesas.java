package br.com.tcc.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa")
	private Long idDespesa; 
	
	private BigDecimal valorOriginal;
	
	private BigDecimal valorParcela;
	
	private Integer qntMeses;
	
	private Boolean adiantamento;
	
	private Integer freqMesesAdiantamento;
	
	private Integer qntParcelasAdiantamento;
	
	private BigDecimal valorTotal;
	
	private BigDecimal jurosPorMes;
	
	//private List<BigDecimal> parcelas;
	
	//private List<BigDecimal> parcelasAdiantamento;
	
	//private BigDecimal totalAdiantamento;
	
	
	public Long getIdDespesa() {
		return idDespesa;
	}
	public void setIdDespesa(Long idDespesa) {
		this.idDespesa = idDespesa;
	}
	public BigDecimal getValorOriginal() {
		return this.valorOriginal;
	}
	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
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
	public Boolean getAdiantamento() {
		return this.adiantamento;
	}
	public void setAdiantamento(Boolean adiantamento) {
		this.adiantamento = adiantamento;
	}
	public Integer getFreqMesesAdiantamento() {
		return this.freqMesesAdiantamento;
	}
	public void setFreqMesesAdiantamento(Integer freqMesesAdiantamento) {
		this.freqMesesAdiantamento = freqMesesAdiantamento;
	}
	public Integer getQntParcelasAdiantamento() {
		return this.qntParcelasAdiantamento;
	}
	public void setQntParcelasAdiantamento(Integer qntParcelasAdiantamento) {
		this.qntParcelasAdiantamento = qntParcelasAdiantamento;
	}
	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getJurosPorMes() {
		return this.jurosPorMes;
	}
	public void setJurosPorMes(BigDecimal jurosPorMes) {
		this.jurosPorMes = jurosPorMes;
	}
//	public List<BigDecimal> getParcelas() {
//		return this.parcelas;
//	}
//	public void setParcelas(List<BigDecimal> parcelas) {
//		this.parcelas = parcelas;
//	}
//	public List<BigDecimal> getParcelasAdiantamento() {
//		return this.parcelasAdiantamento;
//	}
//	public void setParcelasAdiantamento(List<BigDecimal> parcelasAdiantamento) {
//		this.parcelasAdiantamento = parcelasAdiantamento;
//	}
//	public BigDecimal getTotalAdiantamento() {
//		return this.totalAdiantamento;
//	}
//	public void setTotalAdiantamento(BigDecimal totalAdiantamento) {
//		this.totalAdiantamento = totalAdiantamento;
//	}
	
}
