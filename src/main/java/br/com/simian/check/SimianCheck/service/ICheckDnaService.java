package br.com.simian.check.SimianCheck.service;

import org.springframework.stereotype.Controller;

import br.com.simian.check.SimianCheck.domain.StatDTO;

@Controller
public interface ICheckDnaService {

	public boolean isSimian(String[] dna);
	public StatDTO getStats();
}
