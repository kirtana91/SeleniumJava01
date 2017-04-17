package com.ky.selenium;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\swdtools\\SeleniumDrivers\\geckodriver.exe");
		GoogleSearch gs = new GoogleSearch();
		String query = "Kirtana Yeluripati";
		gs.search(query);
	}

}
