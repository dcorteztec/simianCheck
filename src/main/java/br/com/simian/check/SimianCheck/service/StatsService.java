package br.com.simian.check.SimianCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simian.check.SimianCheck.domain.StatDTO;
import br.com.simian.check.SimianCheck.repository.StatsRepository;

@Service
public class StatsService implements IStatsService{

	@Autowired
	private StatsRepository statsRepository;
	
	@Override
	public StatDTO getStats() {
		int totalSimin = 0;
		int totalHuman = 0;
		if(statsRepository.totalSimian()!=null) {
			totalSimin = statsRepository.totalSimian(); 
		}else if(statsRepository.totalHuman()!=null) {
			totalHuman = statsRepository.totalHuman();
		}
		return new StatDTO(totalSimin, totalHuman);
	}

}
