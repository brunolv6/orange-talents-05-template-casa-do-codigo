package br.com.zupacademy.bruno.casadocodigo.PaisEstados;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.bruno.casadocodigo.Validator.Existe;

public class EstadoForm {
	
	@NotBlank
	private String nomeEstado;
	
	@NotBlank
	@Existe(entidade = Pais.class, atributo = "nome")
	private String nomePais;
	

	public EstadoForm(String nomeEstado, String nomePais) {
		this.nomeEstado = nomeEstado;
		this.nomePais = nomePais;
	}


	public Estado converter(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		
		Pais pais = paisRepository.findByNome(this.nomePais);
		
		Optional<Estado> estado = estadoRepository.findByNomeAndPais(this.nomeEstado, pais);
		
		if(estado.isPresent()) {
			throw new IllegalArgumentException("O estado já esta cadastrado neste país");
		}
		
		return new Estado(this.nomeEstado, pais);
	}	
}
