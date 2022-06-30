package nec.jr.controller;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
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

import ch.qos.logback.classic.Logger;
import nec.jr.entity.Skill;
import nec.jr.repository.SkillRepository;
import nec.jr.service.SkillService;
import nec.jr.wrapper.CertificationFileAndSkill;

@Controller
@RequestMapping("/user-centre")
public class UserController {
	org.jboss.logging.Logger logger = LoggerFactory.logger(UserController.class);

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // getting the
																									// principal

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	@Autowired
	SkillService skillService;

	@GetMapping
	public String getMappingStringCreators() {
		return "user-centre";
	}

	@GetMapping("add-skill")
	public String addSkill() {

		LinkedList<Integer> chain=new LinkedList<Integer>();

		
		
		
		
		logger.info("*******HELLO info**********");

		return "add-skill";
	}

	@GetMapping("admin-screen")
	public String adminScreen() {
		return "admin-screen";
	}

	@GetMapping("user-profile")
	public String userProfile(Model model) throws Exception {
		System.out.println("LOGGED IN USER IS************* " + getLoggedInUserName());

		List<Skill> skillDataList = skillService.getSkillDataForUsername(getLoggedInUserName());
		System.out.println("skillDataList********** " + skillDataList.size());
		System.out.println("skillDataList********** ");
		// skillService.downloadFile(skillDataList.get(2).getCertificationFile());
		// skillService.uploadFile(skillDataList.get(1)[3]);
		model.addAttribute("skillDataList", skillDataList);

		// Check this tomorrow
		// https://stackoverflow.com/questions/8600724/how-to-iterate-through-list-of-object-arrays
		return "user-profile";
	}

	@PostMapping("download-file")
	public ResponseEntity<String> downloadFile(@RequestBody Integer fileId) throws Exception {
		
		skillService.downloadFile(fileId);
		return new ResponseEntity<>("result successful result", HttpStatus.OK);
	}

	@PostMapping("/add-skill")
	public ResponseEntity<String> addSkill(@RequestBody CertificationFileAndSkill certificationFileAndSkill, Model model) {
		// System.out.println("*************** in controller " +
		// skill.getCertificationFile());

		logger.info("*************** in controller " + certificationFileAndSkill.getCertificationDate());
		skillService.addSkill(certificationFileAndSkill);
		return new ResponseEntity<>("result successful result", HttpStatus.OK);
	}
	

	@GetMapping("edit-skill")
	public String editScreen() {
		return "edit-skill";
	}
	
	@PostMapping("edit-skill")
	public ResponseEntity<String> editSkill(@RequestBody Integer skillId) throws Exception {
		
		if(skillService.editSkill(skillId)!="true")
		{return new ResponseEntity<>("failed request", HttpStatus.INTERNAL_SERVER_ERROR);}
		return new ResponseEntity<>("result successful result", HttpStatus.OK);
	}
	
	

}