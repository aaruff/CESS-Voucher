package edu.nyu.cess.payment;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class PaymentFileConverter {

	private String payoffFilePath;
	
	public PaymentFileConverter(){
		this.payoffFilePath = "";
	}
	
	public String getPDFLocation(){
		return this.payoffFilePath + ".pdf";
	}
	
	public String getPDFName(){
		return (new File(this.payoffFilePath)).getName();
	}
	
	public boolean convertPaymentToVoucherPDF(int horizontalShift, int verticalShift){
		PaymentFileReader paymentFileReader = new PaymentFileReader(this.payoffFilePath);
		PaymentPDFGenerator paymentPDFGenerator = new PaymentPDFGenerator(this.payoffFilePath+".pdf", horizontalShift, verticalShift);
		
		ArrayList<Subject> subjects = paymentFileReader.getSubjects();
	
		if(subjects.size() == 0){
			System.out.println("No subjects found.");
		}
		boolean result = paymentPDFGenerator.generateDocument(subjects);
		
		if(!result){
			System.out.println("Faled to generate pdf document.");
			return false;
		}
		return true;
	}
	
	public boolean printVouchers(String fileToPrint){
		FileInputStream psStream;
        try {  
            psStream = new FileInputStream(fileToPrint);  
            } catch (FileNotFoundException ffne) {  
              ffne.printStackTrace();  
              return false;
            }  
        
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;  
        
        Doc paymentVoucherPDF = new SimpleDoc(psStream, psInFormat, null);    
        
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();  
        PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);  
          
        // this step is necessary because I have several printers configured  
        PrintService myPrinter = null;  
        for (int i = 0; i < services.length; i++){  
            System.out.println("service found: ");  
            String svcName = services[i].toString();             
            if (svcName.contains("printer closest to me")){  
                myPrinter = services[i];  
                System.out.println("my printer found: "+svcName);  
                break;  
            }  
        }  
          
        if (myPrinter != null) {              
            DocPrintJob job = myPrinter.createPrintJob();  
            try {  
	            job.print(paymentVoucherPDF, aset);  
	            return true;
            } catch (Exception pe) {
            	pe.printStackTrace();
            	return false;
            }  
        } else {  
            System.out.println("no printer services found");  
            return false;
        }  
	}
	
	public void setFileInfo(String payoffFilePath){
		this.payoffFilePath = payoffFilePath;
	}
	
	public boolean isFileInfoSet(){
		return !this.payoffFilePath.equals("");
	}
}
