package nec.jr.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Lob;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import nec.jr.entity.CertificationFiles;

  
public interface CertificationFileRepository extends JpaRepository<CertificationFiles, Integer> {
	
	Optional<CertificationFiles> findById(Integer fileId);
	
	 
	
}
