package br.com.tcc.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import br.com.tcc.DTO.DespesasDTO;
import br.com.tcc.models.Despesas;
import br.com.tcc.repositories.DespesasRepository;

@Service
public class DespesasService {
	
	@Autowired
	JurosService jurosService;
	
	@Autowired
	DespesasRepository despesasRepository;
	
	public DespesasDTO getDespesasDTO(Long cdDespesas) {
		Optional<Despesas> despesas = this.despesasRepository.findById(cdDespesas);
		if (despesas.isPresent()) {
			DespesasDTO despesaDTO = new DespesasDTO();
			despesaDTO.setValorOriginal(despesas.get().getValorOriginal());
			despesaDTO.setValorParcela(despesas.get().getValorParcela());
			despesaDTO.setValorTotal(despesas.get().getValorTotal());
			despesaDTO.setAdiantamento(despesas.get().getAdiantamento());
			despesaDTO.setFreqMesesAdiantamento(despesas.get().getFreqMesesAdiantamento());
			despesaDTO.setJurosPorMes(despesas.get().getJurosPorMes());
			despesaDTO.setQntMeses(despesas.get().getQntMeses());
			despesaDTO.setQntParcelasAdiantamento(despesas.get().getQntParcelasAdiantamento());
			
			return despesaDTO;
		}
		return null;
	}

	public Despesas calcularDespesas(DespesasDTO despesasDTO) {
		 List<Integer> indicadorAdiantamento = new ArrayList<>();
		 List<BigDecimal> evolucaoAdiantamento = new ArrayList<>();
		 List<BigDecimal> parcelas = new ArrayList<>();
		 List<BigDecimal> parcelasAdiantamento = new ArrayList<>();
		
		
		Despesas despesa = new Despesas();
		BigDecimal valorTotal = despesasDTO.getValorParcela().multiply(BigDecimal.valueOf(despesasDTO.getQntMeses()));

		despesa.setValorOriginal(despesasDTO.getValorOriginal());
		despesa.setValorParcela(despesasDTO.getValorParcela());
		despesa.setQntMeses(despesasDTO.getQntMeses());
		despesa.setValorTotal(valorTotal);
		despesa.setAdiantamento(despesasDTO.getAdiantamento());
		despesa.setFreqMesesAdiantamento(despesasDTO.getFreqMesesAdiantamento());
		despesa.setQntParcelasAdiantamento(despesasDTO.getQntParcelasAdiantamento());

		BigDecimal juros = this.jurosService.descobreJuros(despesa.getValorTotal(), despesa.getValorOriginal(),
				despesa.getQntMeses());
		despesa.setJurosPorMes(juros);
		
		for (int i = 0; i < despesa.getQntMeses(); i++) {
			parcelas.add(despesa.getValorParcela());
			parcelasAdiantamento.add(despesa.getValorParcela());
		}
		//despesa.setParcelas(parcelas);
		
		this.setIndicadorAdiantamento(despesasDTO, parcelasAdiantamento, indicadorAdiantamento, evolucaoAdiantamento);
		//DespesasDTO dadosAdiantamento = this.setIndicadorAdiantamento(despesasDTO, parcelasAdiantamento, indicadorAdiantamento, evolucaoAdiantamento);
		//despesa.setParcelasAdiantamento(dadosAdiantamento.getParcelasAdiantamento());
		//despesa.setTotalAdiantamento(dadosAdiantamento.getTotalAdiantamento());

		return this.despesasRepository.save(despesa);
	}

	private DespesasDTO setIndicadorAdiantamento(DespesasDTO despesa, List<BigDecimal> parcelasAdiantamento, List<Integer> indicadorAdiantamento, List<BigDecimal> evolucaoAdiantamento) {
		despesa.setParcelasAdiantamento(parcelasAdiantamento);
		for (int i = 1; i <= despesa.getParcelasAdiantamento().size(); i++) {
			if (i + despesa.getQntParcelasAdiantamento() <= despesa.getParcelasAdiantamento().size() + 1) {
				if (i % despesa.getFreqMesesAdiantamento() == 0) {
					indicadorAdiantamento.add(1);
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
				evolucaoAdiantamento.add(totalAdiantamento);
			}
		}
		despesa.setTotalAdiantamento(totalAdiantamento);
		return despesa;
	}

}
