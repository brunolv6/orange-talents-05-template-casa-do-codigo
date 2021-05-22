package br.com.zupacademy.bruno.casadocodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.bruno.casadocodigo.Autor.Autor;
import br.com.zupacademy.bruno.casadocodigo.Categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@NotNull
	@Column(unique = true)
	private String titulo;

	@Lob
	@NotBlank
	@NotNull
	@Length(max = 500)
	@Basic(fetch = FetchType.LAZY)
	private String resumo;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String sumario;

	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;

	@NotNull
	@Min(value = 20)
	private BigDecimal preco;

	@ISBN
	@NotNull
	@Column(unique = true)
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataLancamento;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	@NotNull
	@ManyToOne
	private Autor autor;

	public Livro() {

	}

	@JsonCreator
	public Livro(String titulo, String resumo, String sumario, Integer numeroPaginas, BigDecimal preco, String isbn,
			LocalDate dataLancamento, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
