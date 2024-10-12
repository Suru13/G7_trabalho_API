package br.com.g7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.g7.entity.Paciente;
import br.com.g7.repository.PacienteRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente inserir(@Valid @RequestBody Paciente paciente) {
		return repository.save(paciente);
	}

	@PutMapping("{codigo}")
	public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long codigo, @Valid @RequestBody Paciente paciente) {
		if (repository.existsById(codigo)) {
			paciente.setCodigo(codigo);
			return ResponseEntity.ok(repository.save(paciente));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public List<Paciente> listarPacientes() {
		return repository.findAll();
	}

	@DeleteMapping("{codigo}")
	public ResponseEntity<Void> apagar(@PathVariable Long codigo) {
		if (repository.existsById(codigo)) {
			repository.deleteById(codigo);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}	

}
