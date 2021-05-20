package br.com.zupacademy.bruno.casadocodigo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AutorForm {

	@NotBlank
	@NotNull
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Length(max = 400)
	private String descricao;

	public AutorForm(@NotBlank @NotNull String nome, @NotBlank @Email String email,
			@NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
}
