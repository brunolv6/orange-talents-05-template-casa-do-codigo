package br.com.zupacademy.bruno.casadocodigo.Cliente;

public class ClienteIdDto {

	private Long id;

	private String email;

	public ClienteIdDto(Cliente cliente) {
		this.id = cliente.getId();
		this.email = cliente.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

}
