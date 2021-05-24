package br.com.zupacademy.bruno.casadocodigo.Cliente;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.bruno.casadocodigo.PaisEstados.Estado;
import br.com.zupacademy.bruno.casadocodigo.PaisEstados.Pais;
import br.com.zupacademy.bruno.casadocodigo.Validator.CPFOrCNPJ;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CPFOrCNPJ
	@NotBlank
	@Column(unique = true)
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne(optional = true)
	private Estado estado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public Cliente() {
	}

	public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, Estado estado, @NotBlank String telefone,
			@NotBlank String cep) {

		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return Id;
	}

	public String getEmail() {
		return email;
	}

	
}
