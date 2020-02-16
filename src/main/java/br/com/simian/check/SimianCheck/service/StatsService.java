package br.com.simian.check.SimianCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simian.check.SimianCheck.domain.StatDTO;
import br.com.simian.check.SimianCheck.repository.StatsRepository;

@Service
public class StatsService implements IStatsService {

	@Autowired
	private StatsRepository statsRepository;

	@Override
	public StatDTO getStats() {

		StatDTO stats = new StatDTO();
		
		stats.setCountSimian(statsRepository.totalSimian());

		stats.setCountHuman(statsRepository.totalHuman());

		return new StatDTO(stats.getCountSimian(), stats.getCountHuman());
	}

}