package br.com.tcc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.DTO.DespesasDTO;
import br.com.tcc.models.Despesas;
import br.com.tcc.models.Investimentos;
import br.com.tcc.services.DespesasService;
import br.com.tcc.services.JurosService;

@RestController
@RequestMapping("/despesas")
public class DespesasResource {
	
	@Autowired
	DespesasService despesasService;
	
	@Autowired
	JurosService jurosService;
	
	@GetMapping
	public Despesas getInvestimento(Long cdDespesas) {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> calcular(DespesasDTO despesasDTO) {
		Despesas despesa = this.despesasService.calcularDespesas(despesasDTO);
		return ResponseEntity.ok(despesa);
	}
	
	
}
