package SRMS_app_1.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import SRMS_app_1.com.repositories.ReportsRepository;

@Controller
public class ReportsController {
	@Autowired
	ReportsRepository reportsRepo;
	
	@RequestMapping("/getReportsData")
	public String showReportsData() {
		return "showReports";
		
	}

}
