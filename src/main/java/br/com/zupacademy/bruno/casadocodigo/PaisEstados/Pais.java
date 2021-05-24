package br.com.zupacademy.bruno.casadocodigo.PaisEstados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String nome;

	public Pais() {

	}

	public Pais(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
}
