package com.gmailAccount;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class gmailTestNg {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nefer\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test 
	public void funWithYahooPage() throws Throwable {
		driver.get("https://www.gmail.com/");
		
		driver.findElement(By.xpath(("//*[contains(@class,'h-c-header__nav-li g-mail-nav-links')])[2]"))).click();
		WebElement submit=driver.findElement(By.xpath("(//*[contains(@class,'whsOnd zHQkBf')])[1]"));
		submit.sendKeys("handanavciqa@gmail.com");
		//Assert.assertEquals("",driver.getTitle());
       // System.out.println(driver.getTitle());
       
      
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}	




}
