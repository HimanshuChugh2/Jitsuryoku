package nec.jr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nec.jr.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

	List<Skill> findByUsername(String username);

 
	/*
	 * Optional<T> get(long id);
	 * 
	 * List<T> getAll();
	 * 
	 * void save(T t);
	 * 
	 * 
	 * void delete(T t);
	 * 
	 * void update(Skill skill, String[] params);
	 */

}