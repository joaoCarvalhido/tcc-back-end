package br.com.tcc.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcc.DTO.InvestimentosDTO;
import br.com.tcc.models.Investimentos;
import br.com.tcc.models.Usuarios;
import br.com.tcc.repositories.InvestimentosRepository;
import br.com.tcc.repositories.UsuarioRepository;

@Service
public class InvestimentosService {
	
	@Autowired
	InvestimentosRepository investimentoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;;

	public Investimentos calcularInvestimento(InvestimentosDTO investimentoDTO) {
		ArrayList<BigDecimal> rendimentoParcelas = new ArrayList<BigDecimal>();
		ArrayList<BigDecimal> valoresAplicados = new ArrayList<BigDecimal>();
		ArrayList<BigDecimal> apenasRendimento = new ArrayList<BigDecimal>();
		
		
		Investimentos investimento = new Investimentos();
		
		//Usuarios usuario = this.usuarioRepository.findById(1l).get();
		
		
		BigDecimal rendimentoMensal = investimentoDTO.getRendimentoMensal().divide(BigDecimal.valueOf(100));
		BigDecimal parcelaAtual = BigDecimal.ZERO;
		
		BigDecimal parcelaAtualParcela = BigDecimal.ZERO;
		for(int i = 0; i < investimentoDTO.getQntMeses(); i++){
			valoresAplicados.add(investimentoDTO.getValorParcela());
			parcelaAtualParcela  = parcelaAtual.add(investimentoDTO.getValorParcela());
			parcelaAtual = parcelaAtualParcela.multiply(rendimentoMensal).add(parcelaAtualParcela);
		
			rendimentoParcelas.add(parcelaAtual);
			apenasRendimento.add(rendimentoParcelas.get(i).subtract(investimentoDTO.getValorParcela().multiply(BigDecimal.valueOf(i + 1))));
		}
		
		//investimento.setUsuario(usuario);
		investimento.setUsuario(investimentoDTO.getUsuario());
		investimento.setValorParcela(investimentoDTO.getValorParcela());
		investimento.setQntMeses(investimentoDTO.getQntMeses());
		investimento.setRendimentoMensal(rendimentoMensal);
		investimento.setTotalInvestido(this.setTotalInvestido(investimentoDTO.getQntMeses(), investimentoDTO.getValorParcela()));
		investimento.setTotalFinal(rendimentoParcelas.get(rendimentoParcelas.size()-1));
//		investimento.setRendimentoParcelas(rendimentoParcelas);
//		investimento.setValoresAplicados(valoresAplicados);
//		investimento.setApenasRendimento(apenasRendimento);
//		
		return this.investimentoRepository.save(investimento);
	}
	
	
	public BigDecimal setTotalInvestido(Integer qntMeses, BigDecimal valorParcela) {
		BigDecimal total = valorParcela.multiply(BigDecimal.valueOf(qntMeses));
		return total;
	}

}
