package br.com.tcc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.DTO.UsuarioDTO;
import br.com.tcc.models.Usuarios;
import br.com.tcc.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResources {
	
	@Autowired
	UsuariosService usuariosService;
	
	@GetMapping("/{cdUsuario}")
	public ResponseEntity<?> getById(@PathVariable Long cdUsuario) {
		UsuarioDTO usuarioDTO = this.usuariosService.getById(cdUsuario);
		
		return (usuarioDTO != null) ? ResponseEntity.ok(usuarioDTO) :  ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
		Usuarios usuario = this.usuariosService.cadastrar(usuarioDTO);
		return (usuario != null) ? ResponseEntity.ok(usuario) :  ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/ultimo")
	public ResponseEntity<?> getUltimoUsuario() {
		UsuarioDTO usuarioDTO = this.usuariosService.ultimo();
		return (usuarioDTO != null) ? ResponseEntity.ok(usuarioDTO) :  ResponseEntity.badRequest().build();
	}

}
