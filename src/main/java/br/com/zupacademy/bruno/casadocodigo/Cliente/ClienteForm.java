package br.com.zupacademy.bruno.casadocodigo.Cliente;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.bruno.casadocodigo.Categoria.Categoria;
import br.com.zupacademy.bruno.casadocodigo.PaisEstados.Estado;
import br.com.zupacademy.bruno.casadocodigo.PaisEstados.EstadoRepository;
import br.com.zupacademy.bruno.casadocodigo.PaisEstados.Pais;
import br.com.zupacademy.bruno.casadocodigo.PaisEstados.PaisRepository;
import br.com.zupacademy.bruno.casadocodigo.Validator.CPFOrCNPJ;
import br.com.zupacademy.bruno.casadocodigo.Validator.Existe;
import br.com.zupacademy.bruno.casadocodigo.Validator.IsUnico;

public class ClienteForm {
	
	@Email
	@NotBlank
	@IsUnico(entidade = Cliente.class, atributo = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CPFOrCNPJ
	@NotBlank
	@IsUnico(entidade = Cliente.class, atributo = "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	@Existe(entidade = Pais.class, atributo = "nome")
	private String nomePais;

	private String nomeEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String nomePais, String nomeEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.nomePais = nomePais;
		this.nomeEstado = nomeEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		
		Pais pais = paisRepository.findByNome(nomePais);
		
		if(this.precisaDeEstado(estadoRepository, pais)) {
			Optional<Estado> estado = estadoRepository.findByNomeAndPais(nomeEstado, pais);
			
			return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado.get(), telefone, cep);
		}
		
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, null, telefone, cep);

	}

	private boolean precisaDeEstado(EstadoRepository estadoRepository, Pais pais) {
		List<Estado> estados = estadoRepository.findByPais_Id(pais.getId());
		
		if(estados.isEmpty()) {
			return false;
		}
		
		boolean anyMatch = estados.stream().anyMatch(estado -> estado.getNome().equals(this.nomeEstado));
		
		if(!anyMatch || this.nomeEstado.isBlank() || this.nomeEstado == null) {
			throw new IllegalArgumentException("Esta faltando o Estado ou não existe para este país");
		} 
		
		return true;
	}
	
	
}
