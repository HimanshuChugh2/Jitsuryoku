package nec.jr.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import nec.jr.entity.Skill;
import nec.jr.repository.SkillRepository;

public class UserDao implements SkillRepository{

	@Override
	public List findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Skill skill, String[] params) {
		// TODO Auto-generated method stub
		//skill.set(Objects.requireNonNull(
	  //          params[0], "Name cannot be null"));
		
		
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
