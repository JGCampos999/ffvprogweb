package com.fatec.sac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sac.model.Agendamento;
import com.fatec.sac.model.AgendamentoRepository;

@SpringBootTest
public class REQ03CancelarAgendamento {

	@Autowired
	AgendamentoRepository repository;
	Agendamento agendamento;

	@Test
	void cancela_consulta_por_cpf_e_data_especifica() {
		// Dado - que o cpf inserido é válido, e existe um agendamento para esse cpf
		repository.deleteAll();

		// Quando - o o agendamento é buscado
		Agendamento agendamento = new Agendamento(new Long(1), "11122233344", "123456-0", "15/12/2020", "15:30", "Clínico");
		repository.save(agendamento);

		repository.cancelaAgendamento("11122233344", "15/12/2020");
		// Então o sistema verifica os dados, deleta o agendamento e confirma a operação
		assertEquals(repository.findByCpfPaciente("11122233344"), null);
	}
}
