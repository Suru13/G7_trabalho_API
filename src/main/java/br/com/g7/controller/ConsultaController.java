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

import br.com.g7.entity.Consulta;
import br.com.g7.repository.ConsultaRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Consulta inserir(@Valid @RequestBody Consulta consulta) {
		return repository.save(consulta);
	}

	@PutMapping("{codigo}")
	public ResponseEntity<Consulta> alterarManutencao(@PathVariable Long codigo, @Valid @RequestBody Consulta consulta) {
		if (repository.existsById(codigo)) {
			consulta.setCodigo(codigo); // aqui ele vai fazer o put se não ele iria criar outro novo
			return ResponseEntity.ok(repository.save(consulta));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Consulta> inserirVarios(@RequestBody List<Consulta> consultas) {
		return repository.saveAll(consultas);
	}

	@GetMapping
	public List<Consulta> listar() {
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
