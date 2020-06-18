package br.com.tcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcc.DTO.UsuarioDTO;
import br.com.tcc.models.Usuarios;
import br.com.tcc.repositories.UsuarioRepository;

@Service
public class UsuariosService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioDTO getById(Long cdUsuario) {
		Optional<Usuarios> usuario =  this.usuarioRepository.findById(cdUsuario);
		if(usuario.isPresent()) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setIdUsuario(usuario.get().getIdUsuario());
			usuarioDTO.setNome(usuario.get().getNome());
			usuarioDTO.setEmail(usuario.get().getEmail());
			
			return usuarioDTO;
		}
		
		return null;
	}
	
	public Usuarios cadastrar(UsuarioDTO usuarioDTO) {
		Usuarios usuario = new Usuarios();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		return this.usuarioRepository.save(usuario);
	}

	public UsuarioDTO ultimo() {
		Usuarios usuario = this.usuarioRepository.findUltimo();
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		usuarioDTO.setNome(usuario.getNome());
		usuarioDTO.setEmail(usuario.getEmail());
		return usuarioDTO;
	}

}
