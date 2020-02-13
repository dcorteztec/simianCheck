package br.com.simian.check.SimianCheck.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="dna")
public class DnaVO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dna_seq_generator")
    @SequenceGenerator(
            name = "dna_seq_generator",
            sequenceName = "dna_id_sequence"
    )
	private Long id;

	@Transient
	@JsonProperty("dna")
	private String[] dnaTable;
	@Column(unique=true)
	private String dnaSeq;
	private boolean isSimian;

	public String[] getDnaTable() {
		return dnaTable;
	}

	public void setDnaTable(String[] tabelaDna) {
		this.dnaTable = tabelaDna;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isSimian() {
		return isSimian;
	}

	public void setSimian(boolean isSimian) {
		this.isSimian = isSimian;
	}

	public String getDnaSeq() {
		return dnaSeq;
	}

	public void setDnaSeq(String dnaSeq) {
		this.dnaSeq = dnaSeq;
	}
	
}
