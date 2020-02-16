package br.com.simian.check.SimianCheck.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.simian.check.SimianCheck.domain.StatDTO;

public interface IStatsRestController {

	@RequestMapping(value = "stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<StatDTO>> stats(HttpServletRequest req, HttpServletResponse res);
}
