package br.com.simian.check.SimianCheck;

import static org.junit.Assert.assertFalse;
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

import br.com.simian.check.SimianCheck.component.IValidatorComponent;
import br.com.simian.check.SimianCheck.component.ValidatorComponent;
import br.com.simian.check.SimianCheck.domain.DnaVO;
import br.com.simian.check.SimianCheck.repository.CheckDnaRepository;

@RunWith(SpringRunner.class)
public class ValidatorComponentTest {

	@TestConfiguration
    static class ValidatorComponentTestContextConfiguration {
  
        @Bean
        public IValidatorComponent validatorComponent() {
            return new ValidatorComponent();
        }
    }
	
	@Autowired
    private IValidatorComponent validator;
	
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
	public void testEmptyDnaReturnFalse() {
		assertFalse(validator.validDnaArray(new DnaVO()));
	}

	@Test
	public void testNullDnaReturnFalse() {
		assertFalse(validator.validDnaArray(null));
	}

	@Test
	public void testValidDnaReturnTrue() {
		String[] dnaTable = new String[] { "GGGG", "GGGG", "GGGG", "GGGG" };
		DnaVO dna = new DnaVO();
		dna.setDnaTable(dnaTable);
		assertTrue(validator.validDnaArray(dna));
	}
	
	@Test
    public void testValidLenghtReturnFalse(){
        String[] dnaTable= new String[]{"AAA", "AAA", "AAA"};
        DnaVO dna= new DnaVO();
        dna.setDnaTable(dnaTable);
        assertFalse(validator.validDnaArray(dna));
    }
	
	@Test
    public void testvalidMatrizReturnFalse(){
        String[] dnaTable= new String[]{"AAAA", "GGGG", "AAAA","AAAAA"};
        DnaVO dna= new DnaVO();
        dna.setDnaTable(dnaTable);
        assertFalse(validator.validDnaArray(dna));
    }
	
	@Test
    public void invalidValuesDna(){
        String[] dnaTable= new String[]{"AAAA", "AAYA", "AAAA","AAAZ"};
        DnaVO dna= new DnaVO();
        dna.setDnaTable(dnaTable);
        assertFalse(validator.validDnaArray(dna));
    }
}
