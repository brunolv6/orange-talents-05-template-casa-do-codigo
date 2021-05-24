package br.com.zupacademy.bruno.casadocodigo.PaisEstados;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid EstadoForm form) {
		
		Estado estado = form.converter(estadoRepository, paisRepository);
		
		estadoRepository.save(estado);
	}
}
