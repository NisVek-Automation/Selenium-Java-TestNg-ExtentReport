package com.enums;

import com.utils.PropertyFileHelper;

public class TestEnum {
	public static void main(String arg[]){
		System.out.println(PropertyConfig.URL.toString());
		System.out.println(PropertyFileHelper.get(PropertyConfig.URL.toString()));
	}
}
