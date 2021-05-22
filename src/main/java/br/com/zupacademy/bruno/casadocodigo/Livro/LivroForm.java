package br.com.zupacademy.bruno.casadocodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.bruno.casadocodigo.Autor.Autor;
import br.com.zupacademy.bruno.casadocodigo.Autor.AutorRepository;
import br.com.zupacademy.bruno.casadocodigo.Categoria.Categoria;
import br.com.zupacademy.bruno.casadocodigo.Categoria.CategoriaRepository;
import br.com.zupacademy.bruno.casadocodigo.Validator.Existe;
import br.com.zupacademy.bruno.casadocodigo.Validator.IsUnico;

public class LivroForm {

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

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataLancamento;
	
	@NotNull
	@NotBlank
	@Existe(entidade = Categoria.class, atributo = "nome")
	private String nomeCategoria;

	@NotNull
	@NotBlank
	@Existe(entidade = Autor.class, atributo = "email")
	private String emailAutor;

	@JsonCreator
	public LivroForm(String titulo, String resumo,
			String sumario, Integer numeroPaginas, BigDecimal preco, String isbn, LocalDate dataLancamento,
			String nomeCategoria, String emailAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.nomeCategoria = nomeCategoria;
		this.emailAutor = emailAutor;
		
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
		
		Autor autor = autorRepository.findByEmail(emailAutor);

		return new Livro(this.titulo, this.resumo, this.sumario, this.numeroPaginas, this.preco, this.isbn, this.dataLancamento, categoria, autor);
	}
	
}
