package com.fatec.sac.servico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.sac.model.Agendamento;
import com.fatec.sac.model.AgendamentoRepository;

@Service
public class AgendamentoServicoI implements AgendamentoServico{
	
	Logger logger = LogManager.getLogger(AgendamentoServico.class);

	@Autowired
	AgendamentoRepository repository;
	
	@Override
	public Iterable<Agendamento> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Agendamento agendamento) {
		repository.save(agendamento);
	}
	
}
