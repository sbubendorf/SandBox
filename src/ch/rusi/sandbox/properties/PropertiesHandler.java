package ch.rusi.sandbox.properties;

import ch.rusi.sandbox.string.StringUtil;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesHandler {
	
	private final String propFileName;
	private Properties prop = new Properties();
	
	public PropertiesHandler(String propertiesFileName) {
		this.propFileName = propertiesFileName;
		loadProperties();
	}

	public static void main(String[] args) {
		
		PropertiesHandler ph = new PropertiesHandler("config/test.properties");
		ph.testWrite();
		System.out.println(ph.toString());
		
	}
	
	public static PropertiesHandler getInstance(String propertiesFileName) {
		return new PropertiesHandler(propertiesFileName);
	}
	
	private void testWrite() {

		prop.setProperty("db.url", "ora1server:1521:databasename");
		prop.setProperty("db.user", "B040910");
		prop.setProperty("db.password", "pwd4simon");
		
		writeProperties();
		
	}
	
	public PropertiesHandler setProperty(String propertyName, String propertyValue) {
		prop.setProperty(propertyName, propertyValue);
		return this;
	}
	
	public Properties getProperties() {
		return prop;
	}

	public String getProperty(String propertyName) {
		return getProperty(propertyName, null);
	}
	
	public String getProperty(String propertyName, String defaultValue) {
		return prop.getProperty(propertyName, defaultValue);
	}
	
	public void writeProperties() {
		
		try {
			OutputStream out = new FileOutputStream(propFileName);
			prop.store(out, "This file was written by test class " + this.getClass().getName());
			System.out.println("Properties saved to file " + propFileName + " : " + System.lineSeparator() + this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void loadProperties() {
		try {
			InputStream input = new FileInputStream(propFileName);
			this.prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String toString() {
		
		String keyPaddingChar = ".";

		StringBuilder out = new StringBuilder();

		Set x = prop.keySet();
		String[] keys = prop.keySet().toArray(new String[0]);

		int keyLen = StringUtil.getLongestString(keys).length();

		for (String key : keys) {
			out.append(String.format("%1$-" + keyLen + "s", key).replace(" ", keyPaddingChar)).append(" : ").append(prop.getProperty(key)).append(System.lineSeparator());
		}
		return out.toString();
	}
	
}
