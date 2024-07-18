package com.tutorialsninjauat.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;

	public WebDriver startBrowserAndApplicationUrl(String browserName)
	{
		if(browserName.equals("Chrome"))
			driver = new ChromeDriver();
		else if(browserName.equals("edge"))
			driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
		return driver;
	
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
