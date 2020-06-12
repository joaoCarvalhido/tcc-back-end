package br.com.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.models.Despesas;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {

}
