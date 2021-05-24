package br.com.zupacademy.bruno.casadocodigo.PaisEstados;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.bruno.casadocodigo.Validator.IsUnico;

public class PaisForm {

	@NotBlank
	@IsUnico(entidade = Pais.class, atributo = "nome")
	private String nome;

	public String getNome() {
		return this.nome;
	}

	public Pais converter() {
		return new Pais(this.nome);
	}

}
