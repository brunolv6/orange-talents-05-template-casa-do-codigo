package br.com.zupacademy.bruno.casadocodigo.PaisEstados;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	Estado findByNome(String nomeEstado);
	
	Optional<Estado> findByNomeAndPais(String nomeEstado, Pais pais);
	
	List<Estado> findByPais_Id(Long id);

}
