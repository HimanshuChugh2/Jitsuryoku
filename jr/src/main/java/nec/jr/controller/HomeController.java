package nec.jr.controller;

 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

 import nec.jr.entity.SignUpUserDetails;

  
@Controller
public class HomeController {
	
 
	
	
	@GetMapping("/index")
	public String funindex() {
		return "index";
	}
	  
	  @GetMapping("/")
	    public String root(Model model) {
		  
		  
		  SignUpUserDetails objDetails=new SignUpUserDetails();
		  model.addAttribute("signUpUser",objDetails);
	        return "accessible";
	    }


	 	@GetMapping("/ask-question")
		public String askQuestion(Model model)
		{
			
		 	
			return "ask-question";
		}
	  @GetMapping("/accessible")
	  public String accessible()
	  {
		  return "accessible";
	  }
	  
	/*
	 * @GetMapping("/login") public String login(Model model) { return "login"; }
	 */
	/*
	 * @GetMapping("/user") public String userIndex() { return "user/index"; }
	 */
	
}
