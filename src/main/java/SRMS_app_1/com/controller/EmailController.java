package SRMS_app_1.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SRMS_app_1.com.util.EmailService;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam("leadsId")String email,ModelMap modelMap) {
		modelMap.addAttribute("email", email);
		return "composeEmail";
	}
	@RequestMapping("/send")
	public String sendEmail(@RequestParam("toEmail") String to, @RequestParam("subject") String sub, @RequestParam("emailBody") String emailBody) {
		emailService.sendEmail(to, sub, emailBody);
		return "composeEmail";
	}
}
