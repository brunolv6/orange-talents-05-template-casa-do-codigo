package br.com.zupacademy.bruno.casadocodigo.PaisEstados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	Optional<Estado> findByNomeAndPais(String nomeEstado, Pais pais);

}
