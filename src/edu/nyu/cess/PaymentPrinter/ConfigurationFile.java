package edu.nyu.cess.PaymentPrinter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationFile {
	private String fileName = "payment_generator.conf";
	final int LOCATION = 1;
	
	public String read() {
		File configFile = new File(this.fileName);
		String configurationInfo[];
		String defaultPath = "";
		

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(configFile));
			System.out.println("Reading parameters from: " + configFile.getAbsolutePath());

			String line = bufferedReader.readLine();
			configurationInfo = line.split("=");
			if (configurationInfo.length != 2) {
				return defaultPath;
			}
			
			defaultPath = configurationInfo[LOCATION];
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.err.println("File not found." + ex.getMessage());
			return defaultPath;
		} catch (IOException ex) {
			System.err.println("IO Exception Occured.");
			return defaultPath;
		}
		
		return defaultPath;

	}

}
