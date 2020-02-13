package br.com.simian.check.SimianCheck.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.simian.check.SimianCheck.domain.DnaVO;
import br.com.simian.check.SimianCheck.domain.StatDTO;

public interface ICheckDnaController {

	@PostMapping(value = "simian")
	public ResponseEntity<Object> isSimian(@RequestBody DnaVO dna, HttpServletRequest req, HttpServletResponse res);
	
	@RequestMapping(value = "stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<StatDTO>> stats(HttpServletRequest req, HttpServletResponse res);
}
