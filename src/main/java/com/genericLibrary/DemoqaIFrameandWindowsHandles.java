package com.genericLibrary;

import java.awt.List;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DemoqaIFrameandWindowsHandles {
	
public static void main(String[] args) throws InterruptedException {
	
		 WebDriver driver;

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\nefer\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
			
				//Req-for url
			driver.get("https://demoqa.com/");
			
			//Req-for title
			driver.getTitle();
			System.out.println("Print Parent Window's title :"+"" + driver.getTitle());
			
			
				
			//Req-for swich window
			WebElement childWindow=driver.findElement(By.xpath("(//*[text()='Automation Practice Switch Windows'])[2]"));
			childWindow.click();
		    
			
			 
			
			
			 WebElement newbrowser=driver.findElement(By.xpath("//*[contains(text(),'New Browser Tab')]"));
			 newbrowser.click();
			 
			String MainWindow = driver.getWindowHandle();
		
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				TimeUnit.SECONDS.sleep(1);
				String ChildWindow = i1.next();

				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
					TimeUnit.SECONDS.sleep(1);
				
					driver.switchTo().window(ChildWindow);
					Thread.sleep(2);
					

					TimeUnit.SECONDS.sleep(1);
					
					
				}
		
		}
			Assert.assertEquals("Free QA Automation Tools Tutorial for Beginners with Examples", driver.getTitle());
			System.out.println("Print Child Window's title :"+"" + driver.getTitle());
			
          driver.switchTo().window(MainWindow);
          
          
          driver.findElement(By.xpath("//*[contains(text(),'IFrame practice page')]")).click();
         
          JavascriptExecutor js = (JavascriptExecutor) driver;
          
          
          Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
          System.out.println("Number of iframes on the page are : "+ " " + numberOfFrames);
          

         //Scroll down Iframe 1 and click on Appium 
          js.executeScript("window.scrollBy(0,600)");
         driver.switchTo().frame("iframe1");
         driver.findElement(By.xpath("(//*[contains(text(),'Appium')])[2]")).click();
         
         //switch back to Parent Frame and Print text
         driver.switchTo().defaultContent();
         WebElement textElement = driver.findElement(By.xpath("(//*[contains(@class,'content-right twelve columns')])[1]"));
         String text = textElement.getText();
         System.out.println("TEXT FROM PARENT FRAME: " + "------------------------------------------------------------------------------------------------------------------------------------------"+ ""  + text );

         
         System.out.println("--------------------------------------------------------------------------------------------------------");
       
         //switch  to  Frame 1 and Print text
         
         driver.switchTo().frame("iframe1");
         WebElement textElementforFrame1 = driver.findElement(By.xpath("//*[contains(@class,'no-js')]"));
         String text1 = textElementforFrame1.getText();
         System.out.println("TEXT FROM FRAME ONE : "+ "-----------------------------------------------------------------------------------------------------------------------------------------"+" " + text1 );
        
        
     System.out.println("--------------------------------------------------------------------------------------------------------");
     
     
     //((JavascriptExecutor) driver).executeScript("scroll(0, -600);");
     driver.switchTo().defaultContent();
     driver.findElement(By.xpath("(//*[contains(@class,'content-right twelve columns')])[1]")).click();
     Thread.sleep(3000);
     
   //Scrolldown and switch to Frame 2 and Print text
     //js.executeScript("window.scrollBy(0,1000)");
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       driver.switchTo().frame(2);
       
       WebElement textElementforFrame2 = driver.findElement(By.xpath("//*[contains(@name,'iframe2')]"));
   js.executeScript("arguments[0].scrollIntoView();", textElementforFrame2);
       
       String text2 = textElementforFrame2.getText();
       System.out.println("TEXT FROM FRAME TWO : " + ".............................. "+ text2);
       
        

}


}
			

	