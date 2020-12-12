package com.fatec.sac.servico;

import com.fatec.sac.model.Agendamento;

public interface AgendamentoServico {
	public Iterable<Agendamento> findAll();
	public void save(Agendamento agendamento);
}
