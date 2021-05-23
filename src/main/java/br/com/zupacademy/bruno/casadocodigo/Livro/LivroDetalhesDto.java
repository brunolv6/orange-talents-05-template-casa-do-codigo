package br.com.zupacademy.bruno.casadocodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.bruno.casadocodigo.Autor.Autor;
import br.com.zupacademy.bruno.casadocodigo.Autor.AutorDetalhesDto;
import br.com.zupacademy.bruno.casadocodigo.Categoria.Categoria;
import br.com.zupacademy.bruno.casadocodigo.Validator.Existe;
import br.com.zupacademy.bruno.casadocodigo.Validator.IsUnico;

public class LivroDetalhesDto {

	@NotBlank
	@NotNull
	@IsUnico(entidade = Livro.class, atributo = "titulo")
	private String titulo;

	@NotBlank
	@NotNull
	@Length(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;

	@NotNull
	@Min(value = 20)
	private BigDecimal preco;

	@ISBN
	@NotNull
	@IsUnico(entidade = Livro.class, atributo = "isbn")
	private String isbn;

	private String dataLancamento;

	@NotNull
	@NotBlank
	private AutorDetalhesDto autor;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public LivroDetalhesDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.preco = livro.getPreco();
		this.isbn = livro.getIsbn();
		this.dataLancamento = livro.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new AutorDetalhesDto(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public AutorDetalhesDto getAutor() {
		return autor;
	}

	public void setAutor(AutorDetalhesDto autor) {
		this.autor = autor;
	}

}
