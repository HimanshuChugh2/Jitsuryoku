package nec.jr.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.classic.Logger;
import nec.jr.controller.UserController;
import nec.jr.entity.CertificationFiles;
import nec.jr.entity.Skill;
import nec.jr.repository.CertificationFileRepository;
import nec.jr.repository.SkillRepository;
import nec.jr.wrapper.CertificationFileAndSkill;

@Service
public class SkillService {
	org.jboss.logging.Logger logger = LoggerFactory.logger(UserController.class);

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // getting the
																									// principal

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private CertificationFileRepository certificationFileRepository;

	public ResponseEntity<String> addSkill(CertificationFileAndSkill certificationFileAndSkill) {

		Skill skill = new Skill();
		CertificationFiles certificationFiles = new CertificationFiles();

		// populating Cert
		certificationFiles.setFileName(getLoggedInUserName() + "_" + certificationFileAndSkill.getSkillName()); // sets
		certificationFiles.setUsername(getLoggedInUserName());
		certificationFiles.setCertificationFile(certificationFileAndSkill.getCertificationFile());

		// populating Skill
		skill.setUsername(getLoggedInUserName());
		skill.setCertificationDate(certificationFileAndSkill.getCertificationDate());

		if (certificationFileAndSkill.getCertificationFile().equals("")) {
			skill.setCertificationFileUploadedFlag(false);
		} else {

			skill.setCertificationFileUploadedFlag(true);
			logger.info("******TRUE**********");
		}
		skill.setCurrentLevel(certificationFileAndSkill.getCurrentLevel());
		skill.setFileName(certificationFileAndSkill.getFileName());
		skill.setSkillCategory(certificationFileAndSkill.getSkillCategory());
		skill.setSkillName(certificationFileAndSkill.getSkillName());
		skill.setTheCertificationFiles(certificationFiles);

		certificationFileRepository.save(certificationFiles);

		logger.info("id is ************** " + skillRepository.save(skill).getId());
		logger.info("*************** in service" + skill.getCertificationDate());
		logger.info("*************** in service" + skill.getCurrentLevel() + " " + skill.getSkillCategory());
		return new ResponseEntity<>("result successful result", HttpStatus.OK);

	}

	public List<Skill> getSkillDataForUsername(String username) {

		List<Skill> tempList = skillRepository.findByUsername(username);
		System.out.println("TEMPLIST********** " + tempList.size());

		return skillRepository.findByUsername(username);
	}

	/*
	 * https://stackoverflow.com/questions/71498811/how-to-decode-file-from-base64-
	 * in-spring-boot-java
	 */
	public String downloadFile(Integer fileId) throws Exception {
		// If you are using Java 8 or above
		// Note preferred way of declaring an array variable
		System.out.println("*********DOWNLOADING********** " + fileId);
		System.out.println(System.getProperty("user.home"));
		Optional<CertificationFiles> certificationFiles = certificationFileRepository.findById(fileId);

		String base64 = certificationFiles.get().getCertificationFile();
		byte[] decodedImg = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
		Path destinationFile = Paths.get(System.getProperty("user.home") + "\\Downloads",
				certificationFiles.get().getUsername() + " Certificate id " + certificationFiles.get().getId()
						+ ".jpg");
		Files.write(destinationFile, decodedImg);
		return "true";
	}

	public String editSkill(Integer skillId) {
		logger.info("*********EDITING SKILL******");
		
		
		return "true";
	}
}