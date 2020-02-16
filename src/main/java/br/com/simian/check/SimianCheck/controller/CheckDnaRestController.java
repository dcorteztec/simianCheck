package br.com.simian.check.SimianCheck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.simian.check.SimianCheck.component.IValidatorComponent;
import br.com.simian.check.SimianCheck.domain.DnaVO;
import br.com.simian.check.SimianCheck.service.ICheckDnaService;

@RestController
public class CheckDnaRestController implements ICheckDnaRestController{

	@Autowired
	private ICheckDnaService service;

	@Autowired
	private IValidatorComponent componenteValidator;

	@Override
	public ResponseEntity<Object> isSimian(@RequestBody DnaVO dna, HttpServletRequest req, HttpServletResponse res) {
		 if(componenteValidator.validDnaArray(dna)&&service.isSimian(dna.getDnaTable())){
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).build();
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).contentType(MediaType.APPLICATION_JSON).build();
		}
	}

}
