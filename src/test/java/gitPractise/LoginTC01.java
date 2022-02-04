package gitPractise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.LoginPage;
import Utilities.TestBase;

public class LoginTC01 extends TestBase
{
	@Test
	public void loginTC01()
	{
		
		extentLog_Pass("loginTC01 started execution ");
		log.info("loginTC01 started execution ");
//	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V96\\chromedriver.exe");
//		// run time we can download 
//		WebDriver driver1 =  new ChromeDriver();// open chrome browser
//		
//		driver1.get("https://opensource-demo.orangehrmlive.com/");
//		TestBase  tb= new TestBase();
//		WebDriver driver =tb.openBrowser();
		
		//  2nd way use inheritance call  openBrowser
		extentLog_Pass("Step1:open browser");
		WebDriver driver = openBrowser();
		
//		//  enter user
//		LoginPage  loginPage= new LoginPage(driver);		
//		loginPage.enter_userName("Admin");		
//		// enter pwd
//		loginPage.enter_password("admin123");		
//		// lcick login 
//		loginPage.click_Login();
		
		// optimise code 	
	
		LoginPage loginPage=  new LoginPage(driver);
		extentLog_Pass("logintoOrangeHRMSAppl");
		loginPage.logintoOrangeHRMSAppl("Admin", "admin123");
		
		extentLog_Pass("loginTC01 is executed successfully");
		log.info("loginTC01 is executed successfully");
		

	}

}
