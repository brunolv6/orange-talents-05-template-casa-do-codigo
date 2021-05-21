package br.com.zupacademy.bruno.casadocodigo.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@PersistenceContext
    private EntityManager em;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CategoriaForm form) {

		Categoria categoria = form.converter();
		
		em.persist(categoria);
		
	}
}

