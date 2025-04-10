package com.sis.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * Author MOKSHITH
 */

public class PropertyfileUtility {
	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/configuration_data.properties");
		Properties file=new Properties();
		file.load(fis);
		String data=file.getProperty(key);
		return data;
		
	}

}
