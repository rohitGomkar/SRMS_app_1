package SRMS_app_1.com.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SRMS_app_1.com.entities.Leads;
import SRMS_app_1.com.entities.PendingPayment;
import SRMS_app_1.com.entities.RecordsPayment;
import SRMS_app_1.com.entities.Reports;
import SRMS_app_1.com.repositories.LeadsRepository;
import SRMS_app_1.com.repositories.PendingPaymentRepository;
import SRMS_app_1.com.repositories.RecordsPaymentRepository;
import SRMS_app_1.com.repositories.ReportsRepository;
import SRMS_app_1.com.util.EmailService;
import SRMS_app_1.com.util.EmailService2;
import SRMS_app_1.com.util.PdfGenerator;

@Controller
public class RecordsPaymentController {
	
	@Autowired
	EmailService2 emailService2;
	
	@Autowired
	PdfGenerator pdfGen;
	
	@Autowired
	ReportsRepository reportsRepo;
	
	@Autowired
	private PendingPaymentRepository pendingRepo;
	
	@Autowired
	private LeadsRepository leadsRepo;
	
	@Autowired
	private RecordsPaymentRepository recordsRepo;
	
	@RequestMapping("/recordspage")
	public String showRecordsPage() {
		return "recordPayment";
		
	}
	
	
	@RequestMapping("/records")
	public String getRecordsInquiry(@RequestParam("leadsId")Long id, ModelMap modelMap) {
		Optional<Leads> findById = leadsRepo.findById(id);
		Leads leads = findById.get();

		modelMap.addAttribute("leads", leads);
		return"recordPayment";
	}
		
	@RequestMapping("/saveRecords")
    public String saveRecords(@RequestParam("id")Long id,@RequestParam("firstName")String firstName, 
    		@RequestParam("lastName")String lastName,
    		@RequestParam("courseName")String courseName,
    		@RequestParam("amountPaid")Long amountPaid,
    		@RequestParam("totalAmount")Long totalAmount, 
    		@RequestParam("balanceAmount")Long balanceAmount,
    		@RequestParam("date")@DateTimeFormat(pattern = "MM-dd-yyyy")Date date,
    		@RequestParam("email")String email,
    		@RequestParam("phone")String phone, 
    		ModelMap modelMap) {
		RecordsPayment records = new RecordsPayment();
		records.setId(id);
		records.setFirstName(firstName);
		records.setLastName(lastName);
		records.setCourseName(courseName);
		records.setAmountPaid(amountPaid);
		records.setTotalAmount(totalAmount);
		records.setBalanceAmount(balanceAmount);
		records.setDate(date);
		records.setEmail(email);
		records.setPhone(phone);
		
		String filePath="C:\\Users\\rohit\\Documents\\workspace-spring-tool-suite-4-4.7.2.RELEASE\\SRMS_app_1\\Ticket"+"ticket"+ records.getId() + ".pdf";
		recordsRepo.save(records);
		
		pdfGen.generateInvoice(filePath, records);
		
		emailService2.sendEmailPdf(records.getEmail(), filePath);
		
		
		Optional<RecordsPayment> findById = recordsRepo.findById(records.getId());
		RecordsPayment payment = findById.get();
		
		if (records.getBalanceAmount()!=0) {
			PendingPayment pending = new PendingPayment();
			pending.setId(payment.getId());
			pending.setFirstName(payment.getFirstName());
			pending.setLastName(payment.getLastName());
			pending.setCourseName(payment.getCourseName());
			pending.setAmountPaid(payment.getAmountPaid());
			pending.setTotalAmount(payment.getTotalAmount());
			pending.setBalanceAmount(payment.getBalanceAmount());
			pending.setDate(payment.getDate());
			pending.setEmail(payment.getEmail());
			pending.setPhone(payment.getPhone());
			
			pendingRepo.save(pending);
			Optional<PendingPayment> findById2 = pendingRepo.findById(id);
			PendingPayment payment2 = findById2.get();
			modelMap.addAttribute("payment2", payment2);
			return "showPendingPayment";
		}
		else {
		Reports reports = new Reports();
		reports.setId(payment.getId());
		reports.setFirstName(payment.getFirstName());
		reports.setLastName(payment.getLastName());
		reports.setCourseName(payment.getCourseName());
		reports.setAmountPaid(payment.getAmountPaid());
		reports.setTotalAmount(payment.getTotalAmount());
		reports.setBalanceAmount(payment.getBalanceAmount());
		reports.setDate(payment.getDate());
		reports.setEmail(payment.getEmail());
		reports.setPhone(payment.getPhone());
		
		reportsRepo.save(reports);
       modelMap.addAttribute("reports", reports);
		return"showReports";	
	}
	}
}