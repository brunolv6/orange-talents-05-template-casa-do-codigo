
package br.com.zupacademy.bruno.casadocodigo.Livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.Autor.AutorRepository;
import br.com.zupacademy.bruno.casadocodigo.Categoria.CategoriaRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid LivroForm form) {

		Livro livro = form.converter(categoriaRepository, autorRepository);
		
		em.persist(livro);
		
	}
}

