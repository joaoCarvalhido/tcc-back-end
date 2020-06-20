package br.com.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.models.TipoDespesas;

public interface TipoDespesasRepository extends JpaRepository<TipoDespesas, Long> {

}
