package br.com.simian.check.SimianCheck.domain;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class StatDTO {

	@JsonProperty("count_simian_dna")
	private Optional<Integer> countSimian;
	@JsonProperty("count_human_dna")
	private Optional<Integer> countHuman;
	@JsonProperty("ratio")
	private float ratio;
	
	public StatDTO() {
		
	}
	
	public StatDTO(Optional<Integer> countSimian, Optional<Integer> countHuman) {
		this.countSimian = countSimian;
		this.countHuman = countHuman;
		setRadio();
	}
	public Optional<Integer> getCountSimian() {
		if(!countSimian.isPresent()) {
			return Optional.ofNullable(0);
		}
		return countSimian;
	}
	public void setCountSimian(Optional<Integer> countSimian) {
		this.countSimian = countSimian;
	}
	public Optional<Integer> getCountHuman() {
		if(!countHuman.isPresent()) {
			return Optional.ofNullable(0);
		}
		return countHuman;
	}
	public void setCountHuman(Optional<Integer> countHuman) {
		this.countHuman = countHuman;
	}
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	
	private void setRadio(){
        if(countSimian.get()>0 && countHuman.get()>0) {
            ratio =(float)Math.round((float) countSimian.get() / (countHuman.get() + countSimian.get())*100)/100;
        }else if(countSimian.get()==0 && countHuman.get()>0){
            ratio= 1;
        }else if(countSimian.get()>0 && countHuman.get()==0) {
            ratio= 1;
        }else {
        	ratio= 0;
        }
	
    }
	

}
