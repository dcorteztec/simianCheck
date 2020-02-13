package br.com.simian.check.SimianCheck.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class StatDTO {

	@JsonProperty("count_simian_dna")
	private int countSimian;
	@JsonProperty("count_human_dna")
	private int countHuman;
	@JsonProperty("ratio")
	private float ratio;
	
	public StatDTO(int countSimian, int countHuman) {
		this.countSimian = countSimian;
		this.countHuman = countHuman;
		setRadio();
	}
	public int getCountSimian() {
		return countSimian;
	}
	public void setCountSimian(int countSimian) {
		this.countSimian = countSimian;
	}
	public int getCountHuman() {
		return countHuman;
	}
	public void setCountHuman(int countHuman) {
		this.countHuman = countHuman;
	}
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	
	private void setRadio(){
        if(countSimian>0 && countHuman>0) {
            ratio =(float)Math.round((float) countSimian / (countHuman + countSimian)*100)/100;
        }else if(countSimian==0){
            ratio= 0;
        }else {
            ratio= 1;
        }
    }
	

}
