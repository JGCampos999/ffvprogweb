package com.fatec.sac;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sac.model.Agendamento;
import com.fatec.sac.model.AgendamentoRepository;

@SpringBootTest
public class REQ01CadastrarAgendamento {

	@Autowired
	AgendamentoRepository repository;
	Agendamento agendamento;
	
	private Validator validator;
	private ValidatorFactory validatorFactory;
	
	@Test
	void cadastra_agendamento_com_sucesso() {
		//Dado - que os dados inseridos são validos
		repository.deleteAll();
		
		// Quando - o agendamento é cadastrado
		Agendamento agendamento = new Agendamento(new Long(1), "11122233344", "123456-0", "15/12/2020", "15:30", "Clínico");
		repository.save(agendamento);
		
		//Então o sistema verifica os dados e confirma a operação
		assertEquals(1, repository.count());
	}
	
	@Test
	void valida_métodos_de_entrada() {
		// Dado = que os dados inseridos são válidos
		repository.deleteAll();

		// Quando - é tentando realizar o agendamento
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		Agendamento agendamento = new Agendamento(new Long(1), "11122233344", "123456-0", "15/12/2020", "15:30",
				"Clínico");

		Set<ConstraintViolation<Agendamento>> violations = validator.validate(agendamento);
		// Então o sistema valida as informações e confirma a operação
		assertTrue(violations.isEmpty());
	}
	
	@Test
	void valida_métodos_de_entrada_dados_invalidos() {
		//Dado = que os dados inseridos são inválidos
		repository.deleteAll();
		
		//Quando - é tentando realizar o agendamento
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		Agendamento agendamento = new Agendamento(new Long(1), "", "123456-0", "15/12/2020", "15:30", "Clínico");
		
		Set<ConstraintViolation<Agendamento>> violations = validator.validate(agendamento);
		
		//Então o sistema valida as informações e retorna mensagem de erro
		assertEquals("CPF deve ter 11 caracteres", violations.iterator().next().getMessage());
	}
}
