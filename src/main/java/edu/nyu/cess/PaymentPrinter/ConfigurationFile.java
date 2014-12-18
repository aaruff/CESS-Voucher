package edu.nyu.cess.PaymentPrinter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationFile {
	private String fileName = "config.properties";
	private String path;
	public ConfigurationFile() throws IOException {
		read();
	}
	
	public void read() throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(this.fileName));
		this.path = properties.getProperty("path");
	}

	public String getPath() {
		System.out.println(this.path);
		return this.path;
	}
}
