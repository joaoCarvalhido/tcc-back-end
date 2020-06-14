package br.com.tcc.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Despesas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa")
	private Long idDespesa; 
	
	@ManyToOne
	@JoinColumn(name="id_tipo_despesas", referencedColumnName="id_tipo_despesas")
	private TipoDespesas tipoDespesa;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
	private Usuarios usuario;
	
	private BigDecimal valorOriginal;
	
	private BigDecimal valorParcela;
	
	private Integer qntMeses;
	
	private Boolean adiantamento;
	
	private Integer freqMesesAdiantamento;
	
	private Integer qntParcelasAdiantamento;
	
	private Integer parcelasFinaisComAdiantamento;
	
	private BigDecimal apenasAdiantamento;
	
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

	public TipoDespesas getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesas tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
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
