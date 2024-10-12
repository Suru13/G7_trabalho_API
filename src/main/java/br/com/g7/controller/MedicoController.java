package br.com.g7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.g7.entity.Medico;
import br.com.g7.entity.Paciente;
import br.com.g7.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medico inserir(@Valid @RequestBody Medico medico) {
		return repository.save(medico);
	}

	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Medico> inserirVarios(@RequestBody List<Medico> medicos) {
		return repository.saveAll(medicos);
	}
	
	@GetMapping
	public List<Medico> listarMedicos() {
		return repository.findAll();
	}


}
