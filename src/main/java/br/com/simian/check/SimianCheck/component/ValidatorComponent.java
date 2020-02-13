package br.com.simian.check.SimianCheck.component;

import org.springframework.stereotype.Component;

import br.com.simian.check.SimianCheck.domain.DnaVO;

@Component
public class ValidatorComponent {
	
	public boolean checkValidDna(DnaVO dna) {
		if(!validIsNotNull(dna)) {
			return false;
		}else if(!validLength(dna.getDnaTable())) {
			return false;
		}else if(!validTable(dna.getDnaTable())) {
			return false;
        }else if(!validChars(dna.getDnaTable())) {
        	return false;
        }
        return true;
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
