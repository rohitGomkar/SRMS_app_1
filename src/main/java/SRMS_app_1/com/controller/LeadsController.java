package SRMS_app_1.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import SRMS_app_1.com.entities.Leads;
import SRMS_app_1.com.repositories.LeadsRepository;

@Controller
public class LeadsController {
	
	@Autowired
	private LeadsRepository leadsRepo;
	
	@RequestMapping("/newLeads")
	public String showNewLeadsPage() {
		return "newLeads";
	}
	
	@RequestMapping("/saveLeads")
	public String saveLeadData(@ModelAttribute("leads")Leads leads,ModelMap modelMap) {
		leadsRepo.save(leads);
		modelMap.addAttribute("msg", "Saved Successfully...!!!");
		return"newLeads";
	}
	
	@RequestMapping("/inquiry")
	public String getInquiry(ModelMap modelMap) {
		 List<Leads> leads = leadsRepo.findAll();
		modelMap.addAttribute("leads", leads);
		return "showInquiry";
	}
}
