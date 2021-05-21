package br.com.zupacademy.bruno.casadocodigo.Categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.bruno.casadocodigo.Validator.IsUnico;

public class CategoriaForm {

	@NotBlank
	@IsUnico(entidade = Categoria.class, atributo = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		return new Categoria(this.nome);
	}

}
