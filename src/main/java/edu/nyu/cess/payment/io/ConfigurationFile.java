package edu.nyu.cess.payment.io;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * The type Configuration file.
 */
public class ConfigurationFile
{
	private String fileName = "config.properties";
	private Properties properties;
	private static final Logger LOG = Logger.getLogger(ConfigurationFile.class);

	/**
	 * Instantiates a new Configuration file.
	 *
	 * @throws IOException the iO exception
     */
	public ConfigurationFile()
	{
		properties = new Properties();
		try {
			properties.load(new FileInputStream(this.fileName));
		}
		catch (IOException e)
		{
			if (LOG.isDebugEnabled())
                LOG.debug("Config file not found", e);
		}
	}

	/**
	 * Gets path.
	 *
	 * @return the path
     */
	public String getPath()
	{
    	String path = properties.getProperty("path");

		if (path == null)
			return "";

		return path;
	}
}
