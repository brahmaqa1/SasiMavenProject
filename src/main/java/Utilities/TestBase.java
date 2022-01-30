package Utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

public class TestBase extends ListenersTest
{
	//  add extent report
//	public ExtentTest extest;//  null
	 
	//  add log4j  class
	public static Logger  log =Logger.getLogger("devpinoyLogger");		
	
	
	
	//  Browser common/ generic methods
	  public static WebDriver openBrowser()
	  {
		  //   how  get / acces extetes obj  in current clas
//		  ListenersTest  li =  new ListenersTest();
//		  li.exTest.log(LogStatus.PASS, "I am in open browser");
		  System.out.println("extest in openBrowser ="+exTest);
		  //way2: 
		  exTest.log(LogStatus.PASS, "I m ain open browser");
		  
		  log.info("I m ain open browser");
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftwares\\Alldrivers\\chromedriver_win32V96\\chromedriver.exe");
			// run time we can download 
			WebDriver driver =  new ChromeDriver();// open chrome browser	
			System.out.println("extest="+exTest);
			
			exTest.log(LogStatus.PASS, "Open chrome browser");
			log.info("Open chrome browser");
			System.out.println("Open chrome browser");
			String url= "https://opensource-demo.orangehrmlive.com/";
			exTest.log(LogStatus.PASS, "Open url="+ url);
			log.info("Open url="+ url);
			driver.get(url);
			return driver;
	  }
	
	
	//  textbox  : enter, clear, getval from
//	eX:  
	  public void enter_Val_InTextbox(String Myxpath, String ValueToBeEntered)
	  {		  
		  try
		  {
			exTest.log(LogStatus.PASS, "enter_Val_InTextbox ="+ValueToBeEntered );  
			  
		  }
		  
		  catch (Exception e) {
			
			  exTest.log(LogStatus.FAIL, "Failed.not able to enter vale in text box.Could you please check xpath="+Myxpath);
		  }
	  }
	  
	  public void enter_Val_InTextbox(WebElement textboxEle, String ValueToBeEntered)
	  {
		  
		  
	  }
	  
	  public void Clear_Val_InTextbox(WebElement textboxEle, String ValueToBeEntered)
	  {
		  
		  
	  }
	  
	  public void get_Val_From_Textbox(WebElement textboxEle, String ValueToBeEntered)
	  {
		  
	  }	  
	 
	
	//  button
	// checkbox
	// Dropdown : sleect dropdown val
	// Link
	// Images  
//	..... etc
	
	  
	  // call Extent reporrts msh
	

}
