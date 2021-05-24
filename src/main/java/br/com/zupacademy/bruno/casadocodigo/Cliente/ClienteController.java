package br.com.zupacademy.bruno.casadocodigo.Cliente;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.bruno.casadocodigo.PaisEstados.EstadoRepository;
import br.com.zupacademy.bruno.casadocodigo.PaisEstados.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public ResponseEntity<ClienteIdDto> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
		Cliente cliente = form.converter(paisRepository, estadoRepository);
		
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(new ClienteIdDto(cliente));
	}
}
