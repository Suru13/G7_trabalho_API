package br.com.g7.enums;


public enum Status {
	
	AGUARDANDO("Aguardando"),
	EM_ATENDIMENTO("Em atendimento"),
	ATENDIDO("Atendido");
	
	private final String status;

	public String getStatus() {
		return status;
	}
	
	Status (String status){
		this.status = status;
	}
		
}
	
	

