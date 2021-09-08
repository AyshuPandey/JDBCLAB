package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PersonDetails {

	public static void main(String[] args) throws IOException {
		File f1 = new File("../JDBCLAB/resource/PersonPropDetail.properties");
		InputStream is = new FileInputStream(f1);
		
		Properties prop = new Properties();
		prop.load(is);
		
		Set<String> str = prop.stringPropertyNames();
		for(String s:str) {
			System.out.println(s+" " + prop.getProperty(s));
			}
			System.out.println("\n________________");
			System.out.println(prop.getProperty("age"));
			System.out.println(prop.getProperty("firstname"));
			Set<Object> k=prop.keySet();
			for(Object s:k) {
			System.out.println(s+" " + prop.get(s));
			}
			}
			}