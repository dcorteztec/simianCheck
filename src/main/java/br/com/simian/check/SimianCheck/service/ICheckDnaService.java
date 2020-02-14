package br.com.simian.check.SimianCheck.service;

import br.com.simian.check.SimianCheck.domain.StatDTO;


public interface ICheckDnaService {

	public boolean isSimian(String[] dna);
	public StatDTO getStats();
}
