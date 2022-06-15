package nec.jr.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import nec.jr.dao.Skill;
import nec.jr.repository.SkillRepository;

@Service
public class SkillService {


	@Autowired
	private SkillRepository skillRepository;
	
	
 	public ResponseEntity<String> addSkill(Skill skill) {
		
 		skill.setUsername(null);
		skillRepository.save(skill);
		System.out.println("*************** in service" + skill.getCertificationDate());	
		System.out.println("*************** in service" + skill.getCurrentlevel() + " " + skill.getSkillCategory());	

		return new ResponseEntity<>("result successful result", HttpStatus.OK);
	}
	
 	public List<Skill> getSkillDataForUsername(String username) {
		
 		
 		List<Skill> tempList=skillRepository.findByUsername(username);
		System.out.println("TEMPLIST********** "+	tempList.get(1));

		return skillRepository.findByUsername(username);
	}

}