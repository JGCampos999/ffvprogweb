package com.fatec.sac.model;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Long>{

	@Query("SELECT a FROM Agendamento a WHERE a.cpfPaciente = :cpfPaciente")
	public Agendamento findByCpfPaciente(String cpfPaciente);
	
	@Query(value = "SELECT a FROM Agendamento a ORDER BY a.dataConsulta")
	List<Agendamento> buscaTodosAgendamentosOrdenadosPorDataConsulta();	
	
	@Modifying
	@Query(value = "DELETE FROM Agendamento a WHERE a.cpfPaciente=:cpfPaciente and a.dataConsulta=:dataConsulta")
	public Agendamento cancelaAgendamento(@Param("cpfPaciente")String cpfPaciente, @Param("dataConsulta")String dataConsulta);
}
