package SRMS_app_1.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountantController {
	
	@RequestMapping("/showLogin")
public String showLoginPage() {
	
	return "login/accLogin";
}
	
	@RequestMapping("/homePage")
	public String showHomePage() {
		return"home";
	}
}
