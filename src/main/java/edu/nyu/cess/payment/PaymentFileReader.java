package edu.nyu.cess.payment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PaymentFileReader {
	private String filePath;
	private boolean debugging = true;
	
	public PaymentFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public ArrayList<Subject> getSubjects(){
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		
		FileReader fileReader;
		try{
			fileReader = new FileReader(this.filePath);
		}catch(FileNotFoundException fileNotFoundException){
			if(this.debugging){
				System.out.print("FileNotFound Exception: " + fileNotFoundException.getMessage());
			}
			return subjects;
		}
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Read First line
		String currentLine;
		String column[];
		try{
			currentLine = bufferedReader.readLine();
			while(currentLine != null){
				
				column = currentLine.split("\t"); // columns delimited by tabs
				String subjectName = column[1];
				String subjectID = column[0];
				String payoff = column[4];
				
				// Validate payoff format
				try{
					Double.parseDouble(payoff);
					Double.parseDouble(subjectID);
				}catch(NumberFormatException numberFormatException){
					currentLine = bufferedReader.readLine();
					continue;
				}
				
				subjects.add(new Subject(subjectName, payoff));
				
				currentLine = bufferedReader.readLine();
			}
		}catch(IOException ioException){
			if(this.debugging){
				System.out.print("IOException Occured: " + ioException.getMessage());
			}
			return subjects;
		}
	
		try {
			bufferedReader.close();
		} catch (IOException e) {
			if(this.debugging){
				System.out.print("IOException Occured: " + e.getMessage());
			}
		}
		
		return subjects;
	}

}
