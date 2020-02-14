package br.com.simian.check.SimianCheck;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.simian.check.SimianCheck.domain.DnaVO;
import br.com.simian.check.SimianCheck.repository.CheckDnaRepository;
import br.com.simian.check.SimianCheck.service.CheckDnaService;
import br.com.simian.check.SimianCheck.service.ICheckDnaService;

@RunWith(SpringRunner.class)
public class CheckDnaServiceTest {

	@TestConfiguration
    static class CheckDnaServiceImplTestContextConfiguration {
  
        @Bean
        public ICheckDnaService employeeService() {
            return new CheckDnaService();
        }
    }
	
	@Autowired
    private CheckDnaService service;
 
    @MockBean
    private CheckDnaRepository repository;
	
    @Before
    public void setUp() {
        DnaVO dna = new DnaVO();
        dna.setDnaSeq("ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCCTA, TCACTA");
        dna.setId(1l);
        Optional<DnaVO> dnaOptional = Optional.ofNullable(dna);
        Mockito.when(repository.findById(dna.getId())).thenReturn(dnaOptional);
    }
	
    @Test
    public void isSimian() {
        String dna = "ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCCTA, TCACTA";
        String dnaArray[] = dna.split(",");
        Boolean bol = service.isSimian(dnaArray);
        assertTrue(bol);
     }
   
}
