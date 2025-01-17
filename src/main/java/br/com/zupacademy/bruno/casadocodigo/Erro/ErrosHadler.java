package br.com.zupacademy.bruno.casadocodigo.Erro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrosHadler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler( MethodArgumentNotValidException.class )
	public List<ErrosFormularioDto> handle(MethodArgumentNotValidException exception) {
		
		List<ErrosFormularioDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrosFormularioDto erro = new ErrosFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleException(IllegalArgumentException e) {
		ErrosFormularioDto erroDto = new ErrosFormularioDto("banco de dados", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDto);
    }
}
