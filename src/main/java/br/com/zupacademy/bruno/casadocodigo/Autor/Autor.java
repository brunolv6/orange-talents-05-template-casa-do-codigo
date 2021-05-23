package br.com.zupacademy.bruno.casadocodigo.Autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@NotNull
	private String nome;

	@NotBlank
	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	@NotBlank
	@NotNull
	@Length(max = 400)
	private String descricao;

	@NotNull
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Autor() {

	}

	public Autor(@NotBlank @NotNull String nome, @NotBlank @NotNull @Email String email,
			@NotBlank @NotNull @Length(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
