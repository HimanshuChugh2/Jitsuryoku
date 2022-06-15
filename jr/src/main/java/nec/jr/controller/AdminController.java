package nec.jr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin-centre")
	public String admincentre() {
		return "admin-centre";
	}
	
 

}