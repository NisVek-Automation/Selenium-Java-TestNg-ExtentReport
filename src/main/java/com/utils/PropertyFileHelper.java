package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.constants.FrameworkConstant;

/**
 * Represents the property file reader.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class PropertyFileHelper {

	/**
	 * Get the property value based on property name
	 * @param propertyname -> name of property
	 * @return propertyValue -> value of property
	 */
	public static String get(String propertyname) {
		
		String propertyValue=null;
		Properties property = new Properties();
		try {
			FileInputStream file = new FileInputStream(FrameworkConstant.propertyFilePath);
			property.load(file);
			propertyValue = property.getProperty(propertyname);
			if(propertyValue==null) {
				throw new Exception("Property named "+propertyname+ "not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return propertyValue;
	}
	
	/**
	 * Set the property value based on property name
	 * @param propertyname -> name of property
	 * @return propertyValue -> value of property
	 */
	public static void set(String propertyname, String propertyValue){
		//Set the property
		if(propertyValue != null || propertyValue != ""){
			Properties property = new Properties();
			try {
				FileInputStream file = new FileInputStream(FrameworkConstant.propertyFilePath);
				property.load(file);
				property.setProperty(propertyname, propertyValue);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
