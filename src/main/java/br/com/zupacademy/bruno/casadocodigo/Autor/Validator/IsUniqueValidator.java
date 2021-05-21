package br.com.zupacademy.bruno.casadocodigo.Autor.Validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
	
public class IsUniqueValidator implements ConstraintValidator<IsUnique, String>{
	
	@PersistenceContext
	private EntityManager em;
	
	private Class<?> entidade;
	
	private String atributo;
	
	@Override
	public void initialize(IsUnique anotacao) {
		this.entidade = anotacao.entidade();
		this.atributo = anotacao.atributo();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Query query = em.createQuery("select 1 from " + entidade.getName() + " where " + atributo + "= :value");
		
		query.setParameter("value", value);
		
		List<?> resultado = query.getResultList();
		
		return resultado.isEmpty();
	}

}
