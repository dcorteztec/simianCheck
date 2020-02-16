package br.com.simian.check.SimianCheck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.simian.check.SimianCheck.domain.DnaVO;

public interface ICheckDnaRestController {

	@PostMapping(value = "simian")
	public ResponseEntity<Object> isSimian(@RequestBody DnaVO dna, HttpServletRequest req, HttpServletResponse res);
	
}
