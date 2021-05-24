package br.com.zupacademy.bruno.casadocodigo.PaisEstados;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long>{

	Pais findByNome(String nomePais);
	
}
