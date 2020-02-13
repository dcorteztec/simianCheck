package br.com.simian.check.SimianCheck.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.simian.check.SimianCheck.component.ValidatorComponent;
import br.com.simian.check.SimianCheck.domain.DnaVO;
import br.com.simian.check.SimianCheck.domain.StatDTO;
import br.com.simian.check.SimianCheck.service.ICheckDnaService;

@RestController
public class CheckDnaController implements ICheckDnaController{

	@Autowired
	private ICheckDnaService service;

	@Autowired
	private ValidatorComponent componenteValidator;

	@Override
	public ResponseEntity<Object> isSimian(@RequestBody DnaVO dna, HttpServletRequest req, HttpServletResponse res) {
		if (!componenteValidator.checkValidDna(dna)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).contentType(MediaType.APPLICATION_JSON).build();
		} else {
			service.isSimian(dna.getDnaTable());
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).build();
		}
	}

	@Override
	public ResponseEntity<Optional<StatDTO>> stats(HttpServletRequest req, HttpServletResponse res) {
		StatDTO stats = service.getStats();
		return new ResponseEntity<Optional<StatDTO>>(Optional.of(stats), HttpStatus.OK);
	}

}
