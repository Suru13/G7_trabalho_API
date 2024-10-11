package br.com.g7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.g7.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
