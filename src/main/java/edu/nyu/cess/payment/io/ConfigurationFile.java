package edu.nyu.cess.payment.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Configuration file.
 */
public class ConfigurationFile {
	private String fileName = "config.properties";
	private String path;

	/**
	 * Instantiates a new Configuration file.
	 *
	 * @throws IOException the iO exception
     */
	public ConfigurationFile() throws IOException {
		readPropertiesFile();
	}

	/**
	 * Read properties file.
	 *
	 * @throws IOException the iO exception
     */
	public void readPropertiesFile() throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(this.fileName));
		this.path = properties.getProperty("path");
	}

	/**
	 * Gets path.
	 *
	 * @return the path
     */
	public String getPath() {
		System.out.println(this.path);
		return this.path;
	}
}
