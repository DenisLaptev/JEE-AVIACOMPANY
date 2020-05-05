package main.java.application;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HamletInternational {

	public static void main(String[] args) {
		System.out.println("1 — английский /n 2 — белорусский \n любой — русский ");
		char ch = 0;
		try {

			ch = (char) System.in.read();

		} catch (IOException e) {
			e.printStackTrace();
		}

		String country = "";
		String language = "";

		switch (ch) {
		case '1':
			country = "US";
			language = "EN";
			break;
		case '2':
			country = "BY";
			language = "BE";
			break;
		}
		
		Locale current = new Locale(language, country);
		//System.out.println(current);
		ResourceBundle rb = ResourceBundle.getBundle("property\text.properties", current);
		
		String s1 = rb.getString("str1");
		System.out.println(s1);
		
		String s2 = rb.getString("str2");
		System.out.println(s2);
		
		System.out.println("\u0420\u0443\u0441\u0441\u043A\u0438\u0439");
	}
}