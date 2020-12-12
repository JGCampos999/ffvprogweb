package com.fatec.sac.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Long>{

	@Query("SELECT a FROM Agendamento a WHERE a.cpfPaciente = :cpfPaciente")
	public Agendamento findByCpfPaciente(String cpfPaciente);
	
	@Query(value = "SELECT a FROM Agendamento a ORDER BY a.dataConsulta")
	List<Agendamento> buscaTodosAgendamentosOrdenadosPorDataConsulta();	
	
	@Query("SELECT a FROM Agendamento a WHERE a.crmMedico = :crmMedico")
	public Agendamento findByCrmMedico(String crmMedico);
}
