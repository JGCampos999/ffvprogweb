package com.fatec.sac;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ViewResultMatchers;

public class REQ01CadastrarAgendamentoMAVTests {
	@Autowired
	MockMvc mockMvc;// simula o processamento de uma requisicao web

	@Test
	public void ct01_quando_seleciona_cadastrar_livro_retorna_200() throws Exception {
		// Dado – que o sistema está disponível
		// Quando – o usuário faz uma solicitação do tipo GET -
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/agendamentos/cadastrar"));
		// Então – retorna o HTTP 200
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void ct01_quando_seleciona_agendar_consulta_retorna_http_200() throws Exception {
		// Dado – que o sistema está disponível
		// Quando – o usuário faz uma solicitação do tipo GET
		// localhost:8080/agendamentos/cadastrar
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/agendamentos/cadastrar"));
		ViewResultMatchers view = MockMvcResultMatchers.view();
		// Então – retorna o nome logico da view de agendamento
		resultActions.andExpect(view.name(Matchers.is("cadastrarAgendamento")));
	}
}
