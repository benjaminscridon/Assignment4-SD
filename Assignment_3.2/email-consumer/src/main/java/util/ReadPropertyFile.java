package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class ReadPropertyFile {

	private Properties props;
	private InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("conf.properties");

	public ReadPropertyFile() throws IOException {
		props = new Properties();
		props.load(input);
	}

	public String getProperty(String name) {
		return props.getProperty(name);
	}
}
