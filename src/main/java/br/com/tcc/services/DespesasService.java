package br.com.tcc.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcc.DTO.DespesasDTO;
import br.com.tcc.models.Despesas;

@Service
public class DespesasService {

	private List<Integer> indicadorAdiantamento = new ArrayList<>();
	private List<BigDecimal> evolucaoAdiantamento = new ArrayList<>();
	private List<BigDecimal> parcelas = new ArrayList<>();
	private List<BigDecimal> parcelasAdiantamento = new ArrayList<>();

	@Autowired
	JurosService jurosService;

	public Despesas calcularDespesas(DespesasDTO despesasDTO) {
		Despesas despesa = new Despesas();
		BigDecimal valorTotal = despesasDTO.getValorParcela().multiply(BigDecimal.valueOf(despesasDTO.getQntMeses()));

		despesa.setValorOriginal(despesasDTO.getValorOriginal());
		despesa.setValorParcela(despesasDTO.getValorParcela());
		despesa.setQntMeses(despesasDTO.getQntMeses());
		despesa.setValorTotal(valorTotal);
		despesa.setFreqMesesAdiantamento(despesasDTO.getFreqMesesAdiantamento());
		despesa.setQntParcelasAdiantamento(despesasDTO.getQntParcelasAdiantamento());

		BigDecimal juros = this.jurosService.descobreJuros(despesa.getValorTotal(), despesa.getValorOriginal(),
				despesa.getQntMeses());
		despesa.setJurosPorMes(juros);
		
		for (int i = 0; i < despesa.getQntMeses(); i++) {
			this.parcelas.add(despesa.getValorParcela());
			this.parcelasAdiantamento.add(despesa.getValorParcela());
		}
		despesa.setParcelas(this.parcelas);

		DespesasDTO dadosAdiantamento = this.setIndicadorAdiantamento(despesasDTO);
		despesa.setParcelasAdiantamento(dadosAdiantamento.getParcelasAdiantamento());
		despesa.setTotalAdiantamento(dadosAdiantamento.getTotalAdiantamento());

		return despesa;
	}

	private DespesasDTO setIndicadorAdiantamento(DespesasDTO despesa) {
		despesa.setParcelasAdiantamento(this.parcelasAdiantamento);
		for (int i = 1; i <= despesa.getParcelasAdiantamento().size(); i++) {
			if (i + despesa.getQntParcelasAdiantamento() <= despesa.getParcelasAdiantamento().size() + 1) {
				if (i % despesa.getFreqMesesAdiantamento() == 0) {
					this.indicadorAdiantamento.add(1);
					for (int k = 0; k < despesa.getQntParcelasAdiantamento(); k++)
						despesa.getParcelasAdiantamento().remove(despesa.getParcelasAdiantamento().size() - 1);
				} else {
					indicadorAdiantamento.add(0);
				}
			}
		}

		BigDecimal totalAdiantamento = BigDecimal.ZERO;
		for (int i = 0; i < indicadorAdiantamento.size(); i++) {
			if (indicadorAdiantamento.get(i) == 1) {
				BigDecimal total = despesa.getValorParcela().multiply(BigDecimal.valueOf(despesa.getQntParcelasAdiantamento()));
				totalAdiantamento = totalAdiantamento.add(total);
				this.evolucaoAdiantamento.add(totalAdiantamento);
			}
		}
		despesa.setTotalAdiantamento(totalAdiantamento);
		return despesa;
	}

}
