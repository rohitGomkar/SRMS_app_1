package SRMS_app_1.com.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService2 {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmailPdf(String toAddress, String filePath) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toAddress);
			helper.setSubject("payment Slip");
			helper.setText("Please download invoice pdf");
			helper.addAttachment("Invoice", new File(filePath));
			javaMailSender.send(message);
		} catch (MessagingException  e) {
			e.printStackTrace();
		}
	}

}
