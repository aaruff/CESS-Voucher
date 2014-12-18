package edu.nyu.cess.payment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class PaymentPDFGenerator {
	private Document document;
	private String outputFile;
	private int verticalShift;
	private int horizontalShift;
	
	public PaymentPDFGenerator(){
		this.document = new Document(PageSize.A4, 50, 50, 50, 50);
		this.verticalShift = 0;
		this.horizontalShift = 0;
	}
	public PaymentPDFGenerator(int horizontalShift, int verticalShift){
		this.verticalShift = verticalShift;
		this.horizontalShift = horizontalShift; 
	}
	
	public PaymentPDFGenerator(String outputFile){
		this.verticalShift = 0;
		this.horizontalShift = 0;
		this.outputFile = outputFile;
		this.document = new Document(PageSize.A4, 50, 50, 50, 50);
	}
	
	public PaymentPDFGenerator(String outputFile, int horizontalShift, int verticalShift){
		this.verticalShift = verticalShift;
		this.horizontalShift = horizontalShift;
		this.outputFile = outputFile;
		this.document = new Document(PageSize.A4, 50, 50, 50, 50);
	}
	
	
	public boolean generateDocument(ArrayList<Subject> subjects){
		FileOutputStream fileOutputStream;
		PdfWriter pdfWriter;
		BaseFont baseFont;
		
		// Initialize a FileOutputStream
		try{
			fileOutputStream = new FileOutputStream(outputFile);
		}catch(FileNotFoundException fileNotFoundException){
			return false;
		}
	
		// Initialize a PDFWriter 
		try{
			pdfWriter  = PdfWriter.getInstance(document, fileOutputStream);
			document.open();
		}catch(DocumentException documentException){
			return false;
		}
	
		// Initialize BaseFont
		try{
			baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		}catch(DocumentException documentException){
			return false;
		}catch(IOException ioException){
			return false;
		}
				
		// Create a payment PDF file or each subject
		for(Subject subject: subjects){
				PdfContentByte cb = pdfWriter .getDirectContent();
			
				// Lab Number 
				cb.saveState();
				cb.beginText();
				cb.moveText(10 , 15);
				cb.setFontAndSize(baseFont, 12);
				cb.showText(subject.getName());
				cb.endText();
				cb.restoreState();
			
				// Amount
				cb.saveState();
				cb.beginText();
				cb.moveText((122+this.horizontalShift), (404 + this.verticalShift));
// 				cb.moveText((122+ 5), (404 - 50)); // for CV STAR vouchers
				cb.setFontAndSize(baseFont, 12);
				cb.showText(subject.getPayoffInCurrency());
				cb.endText();
				cb.restoreState();

				// Total Expense
				cb.saveState();
				cb.beginText();
				cb.moveText((122 + this.horizontalShift), (307 + this.verticalShift));
//				cb.moveText((122 + 5), (307 - 25)); // for CV STAR vouchers
				cb.setFontAndSize(baseFont, 12);
				cb.showText(subject.getPayoffInCurrency());
				cb.endText();
				cb.restoreState();
				
				// Amount in words
				cb.saveState();
				cb.beginText();
				cb.moveText((100 + this.horizontalShift), (260 + this.verticalShift));
//				cb.moveText((122 + this.horizontalShift), (260 - 30)); // for CV STAR vouchers
				cb.setFontAndSize(baseFont, 12);
				cb.showText("--------------------" + subject.getPayoffInWords() + "--------------------");
				cb.endText();
				cb.restoreState();
				document.newPage();
		}
			document.close();
		
		return true;
	}
}
