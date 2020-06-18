package br.com.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tcc.models.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	
	public Usuarios findByEmail(String email);
	
	@Query(value = "SELECT TOP 1* FROM usuarios ORDER BY id_usuario DESC", nativeQuery = true)
	public Usuarios findUltimo();

}
