package br.com.g7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.g7.entity.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
