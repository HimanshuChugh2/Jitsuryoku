package nec.jr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nec.jr.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

	 List<Skill> findByUsername(String username);

	
}
