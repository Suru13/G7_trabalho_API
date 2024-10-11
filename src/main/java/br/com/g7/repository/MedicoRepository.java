package br.com.g7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.g7.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
