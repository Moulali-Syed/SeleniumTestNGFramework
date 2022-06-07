package org.selenium.pom.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class PropertyUtils {

	public static Properties propertyLoader(String filePath) {
		Properties properties = new Properties();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			try {
				properties.load(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("failed to load properties File "+filePath);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("properties file not found at "+filePath);
		}
		return properties;
	}
}
