package com.fatec.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
	private String cpfPaciente;
	
	@NotNull
	private String crmMedico;
	
	@NotNull
	private String dataConsulta;
	
	@NotNull
	private String horaConsulta;
	
	@NotNull
	private String tipoAtendimento;
	
	public Agendamento(Long id, String cpfPaciente, String crmMedico, String dataConsulta, String horaConsulta,
			String tipoAtendimento) {
		this.id = id;
		this.cpfPaciente = cpfPaciente;
		this.crmMedico = crmMedico;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.tipoAtendimento = tipoAtendimento;
	}
	
	public Agendamento() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCpfPaciente() {
		return cpfPaciente;
	}
	
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
	
	public String getCrmMedico() {
		return crmMedico;
	}
	
	public void setCrmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}
	
	public String getDataConsulta() {
		return dataConsulta;
	}
	
	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	public String getHoraConsulta() {
		return horaConsulta;
	}
	
	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
	
	public String getTipoAtendimento() {
		return tipoAtendimento;
	}
	
	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (cpfPaciente == null) {
			if (other.cpfPaciente != null)
				return false;
		} else if (!cpfPaciente.equals(other.cpfPaciente))
			return false;
		if (crmMedico == null) {
			if (other.crmMedico != null)
				return false;
		} else if (!crmMedico.equals(other.crmMedico))
			return false;
		if (dataConsulta == null) {
			if (other.dataConsulta != null)
				return false;
		} else if (!dataConsulta.equals(other.dataConsulta))
			return false;
		if (horaConsulta == null) {
			if (other.horaConsulta != null)
				return false;
		} else if (!horaConsulta.equals(other.horaConsulta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoAtendimento == null) {
			if (other.tipoAtendimento != null)
				return false;
		} else if (!tipoAtendimento.equals(other.tipoAtendimento))
			return false;
		return true;
	}	
}
