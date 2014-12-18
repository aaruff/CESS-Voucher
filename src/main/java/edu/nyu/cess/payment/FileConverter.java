package edu.nyu.cess.payment;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileConverter
{

	private String payoffFilePath;
	
	public FileConverter(){
		this.payoffFilePath = "";
	}
	
	public String getPDFLocation(){
		return this.payoffFilePath + ".pdf";
	}
	
	public String getPDFName(){
		return (new File(this.payoffFilePath)).getName();
	}
	
	public boolean convertPaymentToVoucherPDF(int horizontalShift, int verticalShift){
		FileReader fileReader = new FileReader(this.payoffFilePath);
		PDFGenerator PDFGenerator = new PDFGenerator(this.payoffFilePath+".pdf", horizontalShift, verticalShift);
		
		ArrayList<Subject> subjects = fileReader.getSubjects();
	
		if(subjects.size() == 0){
			System.out.println("No subjects found.");
		}
		boolean result = PDFGenerator.generateDocument(subjects);
		
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
