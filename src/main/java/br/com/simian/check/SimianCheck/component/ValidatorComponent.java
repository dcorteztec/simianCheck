package br.com.simian.check.SimianCheck.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.simian.check.SimianCheck.domain.DnaVO;
import br.com.simian.check.SimianCheck.repository.CheckDnaRepository;
import br.com.simian.check.SimianCheck.utils.UtilTransform;

@Component
public class ValidatorComponent implements IValidatorComponent{
	
	@Autowired
	private CheckDnaRepository repository;
	
	public boolean validDnaArray(DnaVO dna) {
		if(!validIsNotNull(dna)||!checkValidateDnaSeq(dna.getDnaTable())) {
			return false;
		}else if(!validLength(dna.getDnaTable())||!validTable(dna.getDnaTable())) {
			return false;
		}else if(!validChars(dna.getDnaTable())) {
        	return false;
        }
        return true;
    }

	public boolean checkValidateDnaSeq(String[] dnaSeq) {
		if(repository.findListByDna(UtilTransform.stringToStringArray(dnaSeq)).size()==0) {
			return true;
		}
		return false;
	}
	
	
    private boolean validIsNotNull(DnaVO dna){
        if(dna == null || dna.getDnaTable() == null){
           return false;
        }
		return true;
    }

    private boolean validLength(String[] dna){
        if(dna.length<4) {
        	 return false;
        }
		return true;
    }

    private boolean validTable(String[] dna){
        if(!validArrayLenght(dna) || dna.length != dna[0].length()) {
        	 return false;
        }
		return true;
    }

    private boolean validChars(String[] dna){
        int i=0;
        while(i<dna.length){
            if(!(dna[i].matches("[ACTG]*"))){
                return false;
            }
            i++;
        }
        return true;
        
    }

    private boolean validArrayLenght(String[] stringArray){
        int i=1;
        boolean areEquals= true;
        int actualSize= stringArray[0].length();
        while (areEquals && i<stringArray.length){
            areEquals= actualSize == stringArray[i].length();
            actualSize= stringArray[i].length();
            i++;
        }
        return areEquals;
    }
}
