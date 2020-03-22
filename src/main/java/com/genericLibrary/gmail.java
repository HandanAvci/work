package com.genericLibrary;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class  gmail{

	
	public static void main(String[] args) throws Throwable {
     WebDriver driver;

	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\nefer\\Downloads\\Chrome_last\\chromedriver.exe");
	ChromeOptions chromeOptions = new ChromeOptions();
	driver = new ChromeDriver(chromeOptions);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	driver.get("https://www.google.com/gmail/about/#");
	
	
	
	//This is second window
	driver.findElement(By.xpath(("(//*[contains(@class,'h-c-header__nav-li-link ')])[4]"))).click();
	
	String MainWindow = driver.getWindowHandle();


	Set<String> s1 = driver.getWindowHandles();
	Iterator<String> i1 = s1.iterator();

	while (i1.hasNext()) {
		TimeUnit.SECONDS.sleep(1);
		String ChildWindow = i1.next();

		if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
			TimeUnit.SECONDS.sleep(1);
		
			driver.switchTo().window(ChildWindow);

			TimeUnit.SECONDS.sleep(1);
			
			
			WebElement submit=driver.findElement(By.xpath("(//*[contains(@class,'whsOnd zHQkBf')])[1]"));
			submit.sendKeys("handanavciqa@gmail.com");
			
	        driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
	       
	        WebElement pswrd=driver.findElement(By.xpath("//*[contains(@name,'password')]"));
	        pswrd.sendKeys("KAlem34!!");
	        
	        /*
	        WebElement next= driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]"));
	        
	        WebDriverWait wait = new WebDriverWait(driver, 30);

	       wait.until(ExpectedConditions.elementToBeClickable(next));
	       next.click();

	       */
	     //Waiting 30 seconds for an element to be present on the page, checking
	        // for its presence once every 5 seconds.
	       // driver.navigate().refresh();
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
	    			.withTimeout(40, TimeUnit.SECONDS) 			
	    			.pollingEvery(4, TimeUnit.SECONDS) 			
	    			.ignoring(NoSuchElementException.class);
	    	
	        WebElement next = wait.until(new Function<WebDriver, WebElement>(){
	    	
	    		public WebElement apply(WebDriver driver ) {
	    			return driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]"));
	    		}
	    	});
	        
	        next.click();
	        
	       
	          }
	        
	
	
	

	

	
	
		}	
	

	}

	}

