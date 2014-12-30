package edu.nyu.cess.payment.io;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * The type Configuration file.
 */
public class ConfigurationFile
{
	private Properties configProperties;

	private static final Logger LOG = Logger.getLogger(ConfigurationFile.class);

	/**
	 * Instantiates a new Configuration file.
	 *
	 * @throws IOException the iO exception
     */
	public ConfigurationFile()
	{
		configProperties = new Properties();

		InputStream configInputStream = ClassLoader.getSystemResourceAsStream("config.properties");
		if (configInputStream == null) {
			if (LOG.isDebugEnabled())
				LOG.debug("Unable to find config file in classpath");
		}
		else {
			try {
				configProperties.load(configInputStream);
			} catch (IOException e) {
				if (LOG.isDebugEnabled())
					LOG.debug("Config file not found", e);
			}
		}
	}

	/**
	 * Gets path.
	 *
	 * @return the path
     */
	public String getPayoffPath()
	{
    	String path = configProperties.getProperty("path");

		return (path == null) ? "" : path;
	}
}
