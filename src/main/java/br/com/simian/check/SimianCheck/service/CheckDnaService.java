package br.com.simian.check.SimianCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simian.check.SimianCheck.domain.DnaVO;
import br.com.simian.check.SimianCheck.domain.StatDTO;
import br.com.simian.check.SimianCheck.repository.CheckDnaRepository;

@Service
public class CheckDnaService implements ICheckDnaService{

	@Autowired
	private CheckDnaRepository repository;
	
    private int seqPrincipal;
	
	public boolean isSimian(String[] dna){
		seqPrincipal = 0;
        boolean isSimian= false;
        int i=0;
        int j=0;
        while((i<dna.length && !isSimian ) || seqPrincipal == 0){
            while(j<dna[i].length() && !isSimian) {
            	isSimian = isSimianTestDna(dna, i, j);
                j++;
            }
            j=0;
            i++;
        }
        repository.save(preparaDna(stringToStringArray(dna),isSimian));
        return isSimian;
    }

    private DnaVO preparaDna(String dna, boolean isSimian) {
    	DnaVO dnaObj = new DnaVO();
    	dnaObj.setDnaSeq(dna);
    	dnaObj.setSimian(isSimian);
		return dnaObj;
	}

	private boolean isSimianTestDna(String[] dna, int i, int j){
    	setSeqPrincipal(seqPrincipal+=analiseVertical(dna, i, j));
    	setSeqPrincipal(seqPrincipal+=analiseHorizontal(dna, i, j));
    	setSeqPrincipal(seqPrincipal+=analiseDiagonalPrincipal(dna, i, j));
    	setSeqPrincipal(seqPrincipal+=analiseDiagonalSecundaria(dna, i, j));
    	if(seqPrincipal>1) {
    		return true;
    	}
        return false;
    }

    private int analiseHorizontal(String dna[], int i, int j){
    	int seqEquals = 0;
    	if(dna[i].length()-j<4){
            return seqEquals;
        }
        if(dna[i].charAt(j)==dna[i].charAt(j+1) && dna[i].charAt(j)==dna[i].charAt(j+2)
                && dna[i].charAt(j)==dna[i].charAt(j+3)){
        	seqEquals=+1;
            return seqEquals;
        }
        return seqEquals;
    }

    private int analiseVertical(String dna[], int i, int j){
    	int seqEquals = 0;
        if(dna.length-i<4){
            return seqEquals;
        }
        if(dna[i].charAt(j)==dna[i+1].charAt(j) && dna[i+2].charAt(j)==dna[i].charAt(j)
                && dna[i].charAt(j)==dna[i+3].charAt(j)){
        	seqEquals=+1;
            return seqEquals;
        }
        return seqEquals;
    }

    private int analiseDiagonalPrincipal(String dna[], int i, int j){
    	int seqEquals = 0;
        if(i<3 || dna[i].length()-j<3){
            return seqEquals;
        }
        if(dna[i].charAt(j)==dna[i-1].charAt(j+1) && dna[i].charAt(j)==dna[i-2].charAt(j+2)
                && dna[i].charAt(j)==dna[i-3].charAt(j+3)){
        	seqEquals=+1;
            return seqEquals;
        }
        return seqEquals;
    }

    private int analiseDiagonalSecundaria(String dna[], int i, int j){
    	int seqEquals = 0;
        if(dna.length-i<3 || dna[i].length()-j<3){
            return seqEquals;
        }
        if(dna[i].charAt(j)==dna[i+1].charAt(j+1) && dna[i].charAt(j)==dna[i+2].charAt(j+2)
                && dna[i].charAt(j)==dna[i+3].charAt(j+3)){
        	seqEquals=+1;
            return seqEquals;
        }
        return seqEquals;
    }

	public int getSeqPrincipal() {
		return seqPrincipal;
	}

	public void setSeqPrincipal(int seqPrincipal) {
		this.seqPrincipal = seqPrincipal;
	}
	
	public String stringToStringArray(String[] stringArray){
        StringBuilder builder= new StringBuilder();
        builder.append(stringArray[0]);
        for(int i=1; i<stringArray.length; i++){
            builder.append(", ").append(stringArray[i]);
        }
        return builder.toString();
    }

	public StatDTO getStats() {
		int totalSimin = 0;
		int totalHuman = 0;
		if(repository.totalSimian()!=null) {
			totalSimin = repository.totalSimian(); 
		}else if(repository.totalHuman()!=null) {
			totalHuman = repository.totalHuman();
		}
		return new StatDTO(totalSimin, totalHuman);
	}

	
}
