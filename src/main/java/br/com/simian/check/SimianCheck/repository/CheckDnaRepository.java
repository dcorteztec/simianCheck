package br.com.simian.check.SimianCheck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.simian.check.SimianCheck.domain.DnaVO;

@Repository
public interface CheckDnaRepository extends JpaRepository<DnaVO, Long>{

	@Query(value = "SELECT d FROM DnaVO d WHERE d.dnaSeq = ?1  ")
	public List<DnaVO> findListByDna(String dnaSeq);

}
