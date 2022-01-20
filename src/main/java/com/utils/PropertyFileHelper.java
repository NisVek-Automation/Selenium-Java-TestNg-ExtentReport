package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.constants.FrameworkConstant;
import com.enums.PropertyConfig;

/**
 * Represents the property file reader.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class PropertyFileHelper {

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstant.propertyFilePath);
			property.load(fis);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Get the property value based on property name
	 * @param Name of property
	 * @return Value of property
	 */
	public static String get(PropertyConfig key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toUpperCase()))) {
			try {
				throw new Exception("Property name '" + key.toString().toLowerCase() + "' not found. Please check FrameworkConfig.properties");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return CONFIGMAP.get(key.name().trim().toUpperCase());
	}
	
}
