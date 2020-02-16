package br.com.simian.check.SimianCheck;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.simian.check.SimianCheck.controller.StatsRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatsControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private StatsRestController controller;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testGETStatsController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/stats")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
