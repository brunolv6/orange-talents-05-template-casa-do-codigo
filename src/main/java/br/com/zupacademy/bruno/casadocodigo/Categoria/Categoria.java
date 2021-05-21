package br.com.zupacademy.bruno.casadocodigo.Categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@NotNull
	@Column(unique = true)
	private String nome;

	public Categoria() {

	}

	public Categoria(@NotNull String nome) {
		this.nome = nome;
	}

}
