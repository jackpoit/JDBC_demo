package com.itwn.test.druidtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyTest {
	public static void main(String[] args) throws FileNotFoundException {

		String binPath= PropertyTest.class.getClassLoader().getResource("").getPath();
		System.out.println(binPath);
		System.out.println(binPath+"db.properties");

		FileInputStream fis=new FileInputStream(binPath+"db.properties");

		InputStream inStream = PropertyTest.class.getClassLoader().getResourceAsStream("db.properties");


		Properties props=new Properties();
		try {
			props.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String driver=props.getProperty("jdbc.user");
		System.out.println(driver);
	}
}
