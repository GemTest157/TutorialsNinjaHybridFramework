package com.tutorialsninjauat.testcase;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninjauat.pages.Base;
import com.tutorialsninjauat.utilities.util;

public class LoginTest extends Base{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver = startBrowserAndApplicationUrl("edge");
	}
	
	@Test(priority=1)
	public void VeriyLoginWithValidEmaiAndPassword()
	{
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("gemtest157@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Qatest@2024");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed(),"Account tab is not displayed");
		
		
	}
	
	@Test(priority=2)
	public void VerifyLoginWithInvalidEmailANDInvalidPassword()
	{
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(util.generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Qtest@2024");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String actualWarningMessage=driver .findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");
		
	}
	
	@Test(priority=3)
	public void VerifyLoginWithInvalidEmaiAndValidPassword()
	{
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(util.generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Qatest@2024");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String actualWarningMessage=driver .findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");
		
	}
	
	@Test(priority=4)
	public void VerifyLoginWithValidEmailAndInvalidPassword()
	{
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("gemtest157@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("test@2024");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String actualWarningMessage=driver .findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");

	}
	
	@Test(priority=5)
	public void VerifyLoginWithoutEmailAndPassword()
	{
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String actualWarningMessage=driver .findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");

	}
	
	
	

}
