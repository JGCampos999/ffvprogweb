package com.fatec.sac.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.sac.model.Agendamento;
import com.fatec.sac.servico.AgendamentoServico;

@Controller
@RequestMapping(path="/agendamentos")
public class SacController {
	
	Logger logger = LogManager.getLogger(SacController.class);
	
	@Autowired
	AgendamentoServico servico;
	
	@GetMapping("/cadastrar")
	public ModelAndView retornaFormDeCadastroDe(Agendamento agendamento) {
		ModelAndView mv = new ModelAndView("cadastrarAgendamento");
		mv.addObject("agendamento", agendamento);
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Agendamento agendamento, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("cadastrarAgendamento");
		try {
			servico.save(agendamento);
			modelAndView.addObject("agendamentos: ", servico.findAll());
			modelAndView.addObject("message", "agendamento cadastrado");
		} catch (Exception e) {
			if (result.hasErrors()) {
				logger.info("======================> entrada de dados invalida na pagina cadastrar agendamento");
				modelAndView.addObject("message", "");
			} else {
				modelAndView.addObject("message", "Agendamento ja cadastrado");
			}
		}
		return modelAndView;
	}
}
