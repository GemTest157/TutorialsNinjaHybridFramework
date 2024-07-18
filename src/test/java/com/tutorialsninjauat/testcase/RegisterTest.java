package com.tutorialsninjauat.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninjauat.pages.Base;
import com.tutorialsninjauat.utilities.util;

public class RegisterTest extends Base{
	@BeforeMethod
	public void setUp()
	{
		driver = startBrowserAndApplicationUrl("Chrome");
	}
	
	@Test(priority=1)
	public void verifyRegisteredWithMandatoryFields()
	{
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Aman");
		driver.findElement(By.id("input-lastname")).sendKeys("Pal");
		driver.findElement(By.id("input-email")).sendKeys(util.generateEmailTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567567");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualRegistredSuccessMessage= driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualRegistredSuccessMessage,"Your Account Has Been Created!");
	
	}
	
	@Test(priority=2)
	public void verifyRegisteredWithAllFields()
	{
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Aman");
		driver.findElement(By.id("input-lastname")).sendKeys("Pal");
		driver.findElement(By.id("input-email")).sendKeys(util.generateEmailTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567567");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualRegistredSuccessMessage= driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualRegistredSuccessMessage,"Your Account Has Been Created!");
	
	}
	
	@Test(priority=3)
	public void verifyRegisteredWithDuplicateEmail()
	{
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Aman");
		driver.findElement(By.id("input-lastname")).sendKeys("Pal");
		driver.findElement(By.id("input-email")).sendKeys("gemtest157@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567567");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarnMessage= driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertEquals(actualWarnMessage,"Warning: E-Mail Address is already registered!");
	}
	
	@Test(priority=4)
	public void verifyRegisteredWithoutFields()
	{
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualPrivacyPolicyWarnMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(actualPrivacyPolicyWarnMessage);
		Assert.assertTrue(actualPrivacyPolicyWarnMessage.contains("Warning: You must agree to the Privacy Policy!"),"Warning message is not displayed");
		
		String actualFirstNameWarnMessage = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(actualFirstNameWarnMessage, "First Name must be between 1 and 32 characters!","First Name warn message is not displayed");
		
		String actualLastNameWarnMessage = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(actualLastNameWarnMessage, "Last Name must be between 1 and 32 characters!","Last Name warn message is not displayed");
		
		String actualEmailWarnMessage = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(actualEmailWarnMessage, "E-Mail Address does not appear to be valid!","E-mail Addrses warn message is not displayed");
		
		String actualTelephoneWarnMessage = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(actualTelephoneWarnMessage, "Telephone must be between 3 and 32 characters!","Telephone warn message is not displayed");
		
		String actualPasswordWarnMessage = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(actualPasswordWarnMessage, "Password must be between 4 and 20 characters!","Password warn message is not displayed");	
		
	}
	

}
