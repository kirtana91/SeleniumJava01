package com.ky.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {
	WebDriver driver;
	Wait<WebDriver> wait;

	public void search(String query){
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		driver.get("http://google.com");

		boolean result;
		try{
			result = firstPageContainsQuery(query);
		}catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally{
			driver.close();
		}

		System.out.println("Test " + (result? "passed." : "failed."));
		if(!result){
			System.exit(1);
		}

	}

	private boolean firstPageContainsQuery(String query) {
		//type search query
		driver.findElement(By.name("q")).sendKeys(query);

		//click search
		driver.findElement(By.name("btnG")).click();

		//wait for search to complete
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver){
				System.out.println("Searching....");
				return webDriver.findElement(By.id("resultStats"))!=null;
			}
		});

		return driver.findElement(By.tagName("body")).getText().contains("kirtana");
	}

}
