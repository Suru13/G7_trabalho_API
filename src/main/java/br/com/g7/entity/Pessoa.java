package br.com.g7.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long codigo;
	@NotNull
	@Size(max =60, message="O nome pede conter 60 caracteres no maxímo ")
	@Column(nullable = false , length = 60)
	protected String nome;
	@Email
	@NotNull
	protected String email;
	@NotNull
	@Size(max = 11, message = "O telefone deve conter 11 números")
	@Pattern(regexp ="\\d+", message = "O telefone deve conter apenas números")
    protected List<String> telefone;
	
	public List<String> listaTelefone  = new ArrayList<>();
	
	
	public List<String> getListaTelefone() {
		return listaTelefone;
	}
	
	public List <String> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setListaTelefone(List<String> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
