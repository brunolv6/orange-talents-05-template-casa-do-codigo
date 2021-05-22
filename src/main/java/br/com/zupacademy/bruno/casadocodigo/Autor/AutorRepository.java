package br.com.zupacademy.bruno.casadocodigo.Autor;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Autor findByEmail(String emailAutor);

}
