package br.com.simian.check.SimianCheck;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.simian.check.SimianCheck.controller.CheckDnaRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckDnaApplicationTests {

	@Autowired
	private CheckDnaRestController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller, is(notNullValue()));
	}

}
