package br.com.tcc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.DTO.DespesasDTO;
import br.com.tcc.models.Despesas;
import br.com.tcc.services.DespesasService;
import br.com.tcc.services.JurosService;

@RestController
@RequestMapping("/despesas")
public class DespesasResource {
	
	@Autowired
	DespesasService despesasService;
	
	@Autowired
	JurosService jurosService;
	
	@GetMapping("/{cdDespesas}")
	public ResponseEntity<?> getInvestimento(@PathVariable Long cdDespesas) {
		DespesasDTO despesaDTO = this.despesasService.getDespesasDTO(cdDespesas);
		if (despesaDTO != null)
			return ResponseEntity.ok(despesaDTO);
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping
	public ResponseEntity<?> calcular(DespesasDTO despesasDTO) {
		Despesas despesa = this.despesasService.calcularDespesas(despesasDTO);
		if(despesa != null)
			return ResponseEntity.ok().build();
		return ResponseEntity.badRequest().build();
	}
	
}
