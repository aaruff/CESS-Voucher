package edu.nyu.cess.experiment.payment.voucher.printer.io;

import edu.nyu.cess.experiment.payment.voucher.printer.exceptions.FileNotSelectedException;
import edu.nyu.cess.experiment.payment.voucher.printer.exceptions.NoSubjectsFoundException;
import edu.nyu.cess.experiment.Subject;
import edu.nyu.cess.experiment.payment.voucher.printer.PDFGenerator;
import edu.nyu.cess.experiment.payment.voucher.printer.exceptions.FailedFileConversionException;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ZTreePayFileConverter
{

	private String payoffFilePath;
	
	public ZTreePayFileConverter()
	{
		payoffFilePath = "";
	}
	
	public String getPDFLocation()
	{
		return this.payoffFilePath + ".pdf";
	}
	
	public String getPDFName()
	{
		return (new File(this.payoffFilePath)).getName();
	}
	
	public void convertPaymentToVoucherPDF() throws FileNotSelectedException, FailedFileConversionException, IOException, NoSubjectsFoundException
	{
		if (isFileInfoSet() == false)
			throw new FileNotSelectedException("Error: The file payoff file must be selected first.");

		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File(getPDFLocation());
				Desktop.getDesktop().open(myFile);
			}
			catch(IOException e) {
				throw new IOException("Error: Unable to auto open selected file.");
			}
		}

		FileReader fileReader = new FileReader(payoffFilePath);
		PDFGenerator PDFGenerator = new PDFGenerator(payoffFilePath + ".pdf");
		
		ArrayList<Subject> subjects = fileReader.getSubjects();
		if(subjects.isEmpty())
			throw new NoSubjectsFoundException();

		if(PDFGenerator.generateDocument(subjects) == false)
			throw new FailedFileConversionException("Error: Failed to convert payment file. Please check the format.");
	}
	
	public boolean printVouchers(String fileToPrint)
	{
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
	
	public void setFileInfo(String payoffFilePath)
	{
		this.payoffFilePath = payoffFilePath;
	}
	
	public boolean isFileInfoSet()
	{
		return !this.payoffFilePath.equals("");
	}
}
