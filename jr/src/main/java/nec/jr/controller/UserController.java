package nec.jr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import nec.jr.dao.Skill;
import nec.jr.repository.SkillRepository;
import nec.jr.service.SkillService;

@Controller
@RequestMapping("/user-centre")
public class UserController {
	

	@Autowired
	SkillService skillService;

	@GetMapping
	public String getMappingStringCreators() {
		return "user-centre";
	}

	@GetMapping("add-skill")
	public String addSkill() {
		return "add-skill";
	}

	@GetMapping("admin-screen")
	public String adminScreen() {
		return "admin-screen";
	}

	@GetMapping("user-profile")
	public String userProfile() {
		System.out.println("LOGGED IN USER IS************* "+getLoggedInUserName());
		skillService.getSkillDataForUsername(getLoggedInUserName());
		return "user-profile";
	}

	@PostMapping("/add-skill")
	public ResponseEntity<String> addSkill(@RequestBody Skill skill, Model model) {
		//System.out.println("*************** in controller " + skill.getCertificationFile());

		System.out.println("*************** in controller " + skill.getCertificationDate());
		skillService.addSkill(skill);
		return new ResponseEntity<>("result successful result", HttpStatus.OK);
	}

}