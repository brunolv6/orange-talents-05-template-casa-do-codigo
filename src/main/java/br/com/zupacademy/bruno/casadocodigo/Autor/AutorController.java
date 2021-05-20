package br.com.zupacademy.bruno.casadocodigo.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@PersistenceContext
    private EntityManager em;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid AutorForm form) {

		Autor autor = form.converter();
		
		em.persist(autor);
		
	}
}
