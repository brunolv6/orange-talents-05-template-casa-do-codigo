package br.com.zupacademy.bruno.casadocodigo.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {
	private Long id;

	private String titulo;

	public LivroDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroDto> converter(List<Livro> listaLivros) {

		return listaLivros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
