package br.com.tcc.DTO;

import java.math.BigDecimal;
import java.util.List;

import br.com.tcc.models.Usuarios;

public class DespesasDTO {
	
	private Long idDespesas;
	private Usuarios usuario;
	private BigDecimal valorOriginal;
	private BigDecimal valorParcela;
	private Integer qntMeses;
	private Boolean adiantamento;
	private Integer freqMesesAdiantamento;
	private Integer qntParcelasAdiantamento;
	private BigDecimal valorTotal;
	private BigDecimal jurosPorMes;
	private List<BigDecimal> parcelas;
	private List<BigDecimal> parcelasAdiantamento;
	private BigDecimal totalAdiantamento;
	private Integer parcelasFinaisComAdiantamento;
	private BigDecimal apenasAdiantamento;
	private Long cdTipoDespesa;
	private String dsTipoDespesa;
	
	
	
	public Long getIdDespesas() {
		return idDespesas;
	}
	public void setIdDespesas(Long idDespesas) {
		this.idDespesas = idDespesas;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}
	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	public Integer getQntMeses() {
		return qntMeses;
	}
	public void setQntMeses(Integer qntMeses) {
		this.qntMeses = qntMeses;
	}
	public Boolean getAdiantamento() {
		return adiantamento;
	}
	public void setAdiantamento(Boolean adiantamento) {
		this.adiantamento = adiantamento;
	}
	public Integer getFreqMesesAdiantamento() {
		return freqMesesAdiantamento;
	}
	public void setFreqMesesAdiantamento(Integer freqMesesAdiantamento) {
		this.freqMesesAdiantamento = freqMesesAdiantamento;
	}
	public Integer getQntParcelasAdiantamento() {
		return qntParcelasAdiantamento;
	}
	public void setQntParcelasAdiantamento(Integer qntParcelasAdiantamento) {
		this.qntParcelasAdiantamento = qntParcelasAdiantamento;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getJurosPorMes() {
		return jurosPorMes;
	}
	public void setJurosPorMes(BigDecimal jurosPorMes) {
		this.jurosPorMes = jurosPorMes;
	}
	public List<BigDecimal> getParcelas() {
		return parcelas;
	}
	public void setParcelas(List<BigDecimal> parcelas) {
		this.parcelas = parcelas;
	}
	public List<BigDecimal> getParcelasAdiantamento() {
		return parcelasAdiantamento;
	}
	public void setParcelasAdiantamento(List<BigDecimal> parcelasAdiantamento) {
		this.parcelasAdiantamento = parcelasAdiantamento;
	}
	public BigDecimal getTotalAdiantamento() {
		return totalAdiantamento;
	}
	public void setTotalAdiantamento(BigDecimal totalAdiantamento) {
		this.totalAdiantamento = totalAdiantamento;
	}
	public Integer getParcelasFinaisComAdiantamento() {
		return parcelasFinaisComAdiantamento;
	}
	public void setParcelasFinaisComAdiantamento(Integer parcelasFinaisComAdiantamento) {
		this.parcelasFinaisComAdiantamento = parcelasFinaisComAdiantamento;
	}
	public BigDecimal getApenasAdiantamento() {
		return apenasAdiantamento;
	}
	public void setApenasAdiantamento(BigDecimal apenasAdiantamento) {
		this.apenasAdiantamento = apenasAdiantamento;
	}
	public Long getCdTipoDespesa() {
		return cdTipoDespesa;
	}
	public void setCdTipoDespesa(Long cdTipoDespesa) {
		this.cdTipoDespesa = cdTipoDespesa;
	}
	public String getDsTipoDespesa() {
		return dsTipoDespesa;
	}
	public void setDsTipoDespesa(String dsTipoDespesa) {
		this.dsTipoDespesa = dsTipoDespesa;
	}
	
	
}
