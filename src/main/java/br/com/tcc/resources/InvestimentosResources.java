package br.com.tcc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.DTO.InvestimentosDTO;
import br.com.tcc.models.Investimentos;
import br.com.tcc.services.InvestimentosService;
import br.com.tcc.services.JurosService;

@RestController
@RequestMapping("/investimentos")
public class InvestimentosResources {
	
	@Autowired
	InvestimentosService investimentosService;
	
	@Autowired
	JurosService jurosService;
	
	@GetMapping("/{idInvestimento}")
	public Investimentos getInvestimento(@PathVariable Long idInvestimento) {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> calcular(@RequestBody InvestimentosDTO investimentosDTO) {
		Investimentos investimento = this.investimentosService.calcularInvestimento(investimentosDTO);
		return ResponseEntity.ok(investimento);
	}
}
 