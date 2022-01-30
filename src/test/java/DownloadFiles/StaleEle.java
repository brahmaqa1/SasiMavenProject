package DownloadFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StaleEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\Alldrivers\\chromedriver_win32V96\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();	
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");

		
		// get all links names
		
		List<WebElement>  allLinks=	driver.findElements(By.tagName("a"));

		for(int i=0;i<=allLinks.size()-1 ;i++)
		{
			System.out.println("click link ="+allLinks.get(i).getText());
			allLinks.get(i).click();
			
			driver.navigate().back();
			System.out.println("go back to homepage");
			//StaleElementReferenceException: stale element reference: element is not attached to the page document
			
			allLinks=	driver.findElements(By.tagName("a"));
			
			
		}

		System.out.println("Ends ");
		
//		ExpectedConditions.textToBePresentInElement(ele, "Ramy")

	}

}
