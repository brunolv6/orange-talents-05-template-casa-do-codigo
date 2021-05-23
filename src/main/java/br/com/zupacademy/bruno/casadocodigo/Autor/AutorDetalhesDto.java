package br.com.zupacademy.bruno.casadocodigo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.bruno.casadocodigo.Validator.IsUnico;

public class AutorDetalhesDto {

	@NotBlank
	@NotNull
	private String nome;

	@NotBlank
	@Length(max = 400)
	private String descricao;

	public AutorDetalhesDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
