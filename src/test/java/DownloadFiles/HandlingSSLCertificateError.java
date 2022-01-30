package DownloadFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLCertificateError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V96\\chromedriver.exe");		//
		//		//
		//				WebDriver driver = new ChromeDriver();
		//				driver.get("https://expired.badssl.com/");
		//				String getTitle=driver.getTitle();
		//				System.out.println("getTitle="+getTitle);
		//		//getTitle=Privacy error
		//		//Your connection is not private
		//		//Attackers might be trying to steal your information from expired.badssl.com
		//				//(for example, passwords, messages, or credit cards)
		//				
		//*************************************

		// handing SSL in chrome:


		//		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V96\\chromedriver.exe");		//
		////		
		////		// Create the object of DesiredCapabilities class using chrome
		//		DesiredCapabilities capability=DesiredCapabilities.chrome();
		////		 
		////		// Set ACCEPT_SSL_CERTS variable to true
		//		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		////		 
		////		
		//		WebDriver driver=new ChromeDriver(capability);
		//		  driver.get("https://expired.badssl.com/"); //Care":???? not handled.. 
		//		  //  getting SSL erro getTitle=Privacy error
		//					  String getTitle=driver.getTitle();
		//					  System.out.println("getTitle="+getTitle);;
		//		

		//  way2:  prev code is not working -- 

		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V96\\chromedriver.exe");		//
		
		ChromeOptions chOptions = new 	ChromeOptions();
		chOptions.setAcceptInsecureCerts(true);


		WebDriver driver = new ChromeDriver(chOptions);

		driver.get("https://expired.badssl.com/");  
		// SSL certificcate error got handled
		//			  
		String getTitle=driver.getTitle();
		System.out.println("getTitle="+getTitle);
//getTitle=expired.badssl.com

		
		//*********************************
		//HW:  firefox
		
		FirefoxOptions  ffOptions = new FirefoxOptions();
		
		
		//HW  IE:
//		InternetExplorerOptions
		


	}

}
