package br.com.simian.check.SimianCheck.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.simian.check.SimianCheck.domain.StatDTO;
import br.com.simian.check.SimianCheck.service.IStatsService;

@RestController
public class StatsRestController implements IStatsRestController{
	
	@Autowired
	private IStatsService statsService;

	@Override
	public ResponseEntity<Optional<StatDTO>> stats(HttpServletRequest req, HttpServletResponse res) {
		StatDTO stats = statsService.getStats();
		return new ResponseEntity<Optional<StatDTO>>(Optional.of(stats), HttpStatus.OK);
	}
	
}
