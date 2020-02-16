package br.com.simian.check.SimianCheck;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.simian.check.SimianCheck.controller.CheckDnaRestController;
import br.com.simian.check.SimianCheck.domain.DnaVO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integrationtest") 
public class CheckDnaControllerTest extends CheckDnaApplicationTests{

	private MockMvc mockMvc;
	private DnaVO dna = createDna();
	private DnaVO dnaInvalid = createDnaInvalid();
	
	@Autowired
	private CheckDnaRestController controller;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	private DnaVO createDna() {
		DnaVO dna = new DnaVO();
		String[] dnaTable = new String[] { "CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG" };
		dna.setDnaTable(dnaTable);
		return dna;
	}
	
	private DnaVO createDnaInvalid() {
		DnaVO dna = new DnaVO();
		String[] dnaTable = new String[] { "GGGG", "GGGG", "GGGG", "GGGGX" };
		dna.setDnaTable(dnaTable);
		return dna;
	}

	@Test
	public void testPOSTisSimianController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/simian").
				contentType(MediaType.APPLICATION_JSON).content(toJson(dna))).
		andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
	public void testPOSTisSimianValidationFailedController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/simian").
				contentType(MediaType.APPLICATION_JSON).content(toJson(dnaInvalid))).
		andExpect(MockMvcResultMatchers.status().isNotAcceptable());
    }

	private String toJson(DnaVO dna) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(dna);
		return json;
	}
	
	
}