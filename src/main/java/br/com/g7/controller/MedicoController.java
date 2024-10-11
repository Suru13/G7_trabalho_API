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

import br.com.g7.entity.Medico;
import br.com.g7.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medico inserir(@Valid @RequestBody Medico paciente) {
		return repository.save(paciente);
	}

	@PutMapping("{codigo}")
	public ResponseEntity<Medico> alterarManutencao(@PathVariable Long codigo, @Valid @RequestBody Medico medico) {
		if (repository.existsById(codigo)) {
			medico.setCodigo(codigo); // aqui ele vai fazer o put se não ele iria criar outro novo
			return ResponseEntity.ok(repository.save(medico));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Medico> inserirVarios(@RequestBody List<Medico> medicos) {
		return repository.saveAll(medicos);
	}

	@GetMapping
	public List<Medico> listar() {
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
