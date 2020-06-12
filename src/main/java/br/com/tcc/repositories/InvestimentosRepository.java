package br.com.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.models.Investimentos;

@Repository
public interface InvestimentosRepository extends JpaRepository<Investimentos, Long>{

}
