package br.com.tcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TipoDespesas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_despesas")
	private Long idTipoDespesas;
	
	private String nome;

	public Long getIdTipoDespesas() {
		return idTipoDespesas;
	}

	public void setIdTipoDespesas(Long idTipoDespesas) {
		this.idTipoDespesas = idTipoDespesas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
