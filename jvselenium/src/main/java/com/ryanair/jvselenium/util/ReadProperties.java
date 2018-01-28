package com.ryanair.jvselenium.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

  protected Properties prop;
  
  public String getProperty(String key) {
	 return  prop.getProperty(key);

  }
	
  public ReadProperties() {
	  
	prop = new Properties();

	InputStream input = null;

	try {

		input = ReadProperties.class.getResourceAsStream("/config.properties");
		// load a properties file
		prop.load(input);


		//prop.load(new FileInputStream(ReadProperties.class.getResource("/config.properties")));
		
		
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

  }
}