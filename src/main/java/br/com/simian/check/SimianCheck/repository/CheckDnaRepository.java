package br.com.simian.check.SimianCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.simian.check.SimianCheck.domain.DnaVO;

@Repository
public interface CheckDnaRepository extends JpaRepository<DnaVO, Long>{

	@Query(value =  "Select COUNT(1) from dna where is_simian=true GROUP BY is_simian ", nativeQuery = true)
	public Integer totalSimian();
	
	@Query(value = "Select COUNT(1) from dna where is_simian=false GROUP BY is_simian ", nativeQuery = true)
	public Integer totalHuman();

	@Query(value = "SELECT d FROM DnaVO d WHERE d.dnaSeq = ?1  ")
	public DnaVO findByDna(String dnaSeq);

}
