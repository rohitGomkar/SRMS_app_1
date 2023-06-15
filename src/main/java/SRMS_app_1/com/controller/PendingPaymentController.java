package SRMS_app_1.com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import SRMS_app_1.com.entities.PendingPayment;
import SRMS_app_1.com.repositories.PendingPaymentRepository;
@Controller
public class PendingPaymentController {
	@Autowired
	PendingPaymentRepository pendingRepo;
	
	@RequestMapping("/getPendingPaymentData")
	public String showPendingPaymentData(ModelMap modelMap) {
	   List<PendingPayment> list = pendingRepo.findAll();
		modelMap.addAttribute("list", list);
		return "showPendingPayment";
	}
}
