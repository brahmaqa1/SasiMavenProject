package DownloadFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFilesInChrome {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V96\\chromedriver.exe");		//
		//
//		HashMap<String, Object> hm= new HashMap<String, Object>();
//		hm.put("profile.default_content_settings.popups", 0);
//		hm.put("download.default_directory", "D:\\Practise\\FrameWorkDeisgnsPractiseWorkSpace\\SasiMavenProject\\src\\test\\resources\\AllDownloads");
//		
//		
//		ChromeOptions choptions = new ChromeOptions();
//		choptions.setExperimentalOption("prefs", hm);
//		
//		// pass chromoptin obj to chromedriver
//		WebDriver driver= new ChromeDriver(choptions);	
//		
//		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_html_download_link2");
//		//
//				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//				//		driver.findElement(By.xpath("//*[@alt='W3Schools']")).click();/// nok
//		//
//				driver.switchTo().frame("iframeResult");
//				WebElement ele=  driver.findElement(By.xpath("//*[@alt='W3Schools']"));
//				Actions act = new Actions(driver);
//				act.click(ele).perform();// ok
//					// verify file is exist or not
//				File f = new File("D:\\Practise\\FrameWorkDeisgnsPractiseWorkSpace\\SasiMavenProject\\src\\test\\resources\\AllDownloads\\w3logo.jpg");
//				
//				boolean isFileExist=  f.exists();
//				System.out.println("isFileExist="+isFileExist);//
				
				

		//************************************

		

		//**************************************
		//  HW firefox    very old code - may no work
//		to view firefox browser seting >  about:connfig 
		
		//  old code 
//		FirefoxProfile profile = new FirefoxProfile(); 

		//to down load set =2
//		profile.setPreference("browser.download.folderList", 2);     

		//to which dir, u want to download 
//		profile.setPreference("browser.download.dir","D:\\test");

		//dont ask em where to download, u wont get any dialog box. it downloads directly rsp folder
		// "application/msword,application/x-rar-compressed,application/octet-stream,application/csv,text/csv");

//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword,application/x-rar-compressed,application/octet-stream,application/csv,text/csv");
		//chk by going praremters...we can't see .to chk values are updated..

//		MIME :Multipurpose Internet Mail Extensions (MIME)
//		A MIME type is a label used to identify a type of data. It is used so software can know how to handle the data. It serves the same purpose on the Internet that file extensions do on Microsoft Windows.

//		So if a server says "This is text/html" the client can go "Ah, this is an HTML document,

//		.txt	Text, (generally ASCII or ISO 8859-n)	text/plain
//		.csv	Comma-separated values (CSV)	         text/csv
		
//		.doc	Microsoft Word	             application/msword
//		.docx	Microsoft Word (OpenXML)	application/vnd.openxmlformats-officedocument.wordprocessingml.document
//		.jar	Java Archive (JAR)	        application/java-archive
//		.xml	XML	                        application/xml
		
//		.avi	AVI: Audio Video Interleave	    video/x-msvideo
//		.bmp	Windows OS/2 Bitmap Graphics	image/bmp
//		.jpeg    .jpg	JPEG images	            image/jpeg
//		
		
//		WebDriverManager.firefoxdriver().setup();
		//	  MIME-Multipurpose Internet Mail Extensions
//		WebDriver driver2 = new FirefoxDriver(profile);// old veriosn
		//  error 
		//**************************
		WebDriverManager.firefoxdriver().setup();
		// instance of FirefoxOptions class
	      FirefoxOptions ffOptions = new FirefoxOptions();
//	       adding browser preferences with addPreference method profile.addPreference("browser.download.folderList", 2);
	      // location of downloaded file
	    //to down load set =2//	   
	      ffOptions.addPreference("browser.download.folderList", 2);
	      ffOptions.addPreference("browser.download.dir", "D:\\Practise\\Download FromSelenium");
//	      ffOptions.addPreference("browser.helperApps.neverAsk.openFile", "text/csv,application/x-msexcel,application/excel," + "application/x-excel,application/vnd.ms-excel," + "image/png,image/jpeg,text/html,text/plain," + "application/msword,application/xml");
	      //  even if u dont write also ,, works fine
	      
	      ffOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel," + "application/excel," + "application/x-excel," +"application/vnd.ms excel,image/png,image/jpeg,text/html," +"text/plain,application/msword,application/xml");
//	     
//	      // connecting browser options to webdriver
	      WebDriver driver2 = new FirefoxDriver(ffOptions);
//
		driver2.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_html_download_link2");
//
		driver2.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver2.switchTo().frame("iframeResult");
		WebElement ele=  driver2.findElement(By.xpath("//*[@alt='W3Schools']"));
		Actions act = new Actions(driver2);
		act.click(ele).perform();
//


		//*************************************
		//HW: IE 

InternetExplorerOptions  ieOptions = new InternetExplorerOptions();

//ieOptions.set


		System.out.println("ends");

	}

}
