package SRMS_app_1.com.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import SRMS_app_1.com.entities.RecordsPayment;

@Component
public class PdfGenerator {

	public void generateInvoice(String filePath,RecordsPayment recordPayment) {

		Document document = new Document();
		try {
	PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
		
		Paragraph p = new Paragraph();	
		
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		document.add(Chunk.NEWLINE);
			
			document.add(generateTable(recordPayment));
		document.close();	
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private Element generateTable(RecordsPayment recordPayment) {
		
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Record Invoice"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(recordPayment.getFirstName());
		
		table.addCell("Last Name");
		table.addCell(recordPayment.getLastName());
		
		table.addCell("Course Name");
		table.addCell(recordPayment.getCourseName());
		
		table.addCell("Amount Paid");
		table.addCell(recordPayment.getAmountPaid().toString());
		
		table.addCell("Total Amount ");
		table.addCell(recordPayment.getTotalAmount().toString());
		
		table.addCell("Balance Amount ");
		table.addCell(recordPayment.getBalanceAmount().toString());
		
		table.addCell("DATE");
		table.addCell(recordPayment.getDate().toString());
		
		table.addCell("Phone ");
		table.addCell(recordPayment.getPhone());
		
		table.addCell("Email ");
		table.addCell(recordPayment.getEmail());
		
		return table;
	}
}
