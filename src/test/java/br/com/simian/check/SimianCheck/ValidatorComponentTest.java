package br.com.simian.check.SimianCheck;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.simian.check.SimianCheck.component.ValidatorComponent;
import br.com.simian.check.SimianCheck.domain.DnaVO;

public class ValidatorComponentTest {

	private ValidatorComponent validator = new ValidatorComponent();

	@Test
	public void testEmptyDnaReturnFalse() {
		assertFalse(validator.checkValidDna(new DnaVO()));
	}

	@Test
	public void testNullDnaReturnFalse() {
		assertFalse(validator.checkValidDna(null));
	}

	@Test
	public void testValidDnaReturnTrue() {
		String[] dnaTable = new String[] { "GGGG", "GGGG", "GGGG", "GGGG" };
		DnaVO dna = new DnaVO();
		dna.setDnaTable(dnaTable);
		assertTrue(validator.checkValidDna(dna));
	}
	
	@Test
    public void testValidLenghtReturnFalse(){
        String[] dnaTable= new String[]{"AAA", "AAA", "AAA"};
        DnaVO dna= new DnaVO();
        dna.setDnaTable(dnaTable);
        assertFalse(validator.checkValidDna(dna));
    }
	
	@Test
    public void testvalidMatrizReturnFalse(){
        String[] dnaTable= new String[]{"AAAA", "GGGG", "AAAA","AAAAA"};
        DnaVO dna= new DnaVO();
        dna.setDnaTable(dnaTable);
        assertFalse(validator.checkValidDna(dna));
    }
	
	@Test
    public void invalidValuesDna(){
        String[] dnaTable= new String[]{"AAAA", "AAYA", "AAAA","AAAZ"};
        DnaVO dna= new DnaVO();
        dna.setDnaTable(dnaTable);
        assertFalse(validator.checkValidDna(dna));
    }
}
