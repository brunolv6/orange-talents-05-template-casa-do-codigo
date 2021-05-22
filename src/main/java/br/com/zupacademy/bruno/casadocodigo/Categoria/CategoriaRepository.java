package br.com.zupacademy.bruno.casadocodigo.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNome(String nomeCategoria);
}
