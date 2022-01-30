package AllTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import Utilities.TestBase;

public class HomePageNavigationTC02 extends TestBase
{

	 public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		// open browser code 
//		TestBase  tb= new TestBase();
//		driver= TestBase.openBrowser();
	}
	
	@Test
	public static void  homePageNavigationTC02(){
//	public static void main(String[] args) {
		
		extentLog_Pass("******Executing : homePageNavigationTC02");
		log.info("******Executing : homePageNavigationTC02");
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V96\\chromedriver.exe");
		// run time we can download 
		WebDriver driver1 =  new ChromeDriver();// open chrome browser
		
		driver1.get("https://opensource-demo.orangehrmlive.com/");
		
				
		//  enter user
		LoginPage  loginPage= new LoginPage(driver1);		
		loginPage.enter_userName("Admin");		
		// enter pwd
		loginPage.enter_password("admin123");		
		// lcick login 
		loginPage.click_Login();
//***********
		HomePage    homePage =  new HomePage(driver1);
		
		homePage.mouse_Over_AdminTab();
		extentLog_Fail("failing this Tc forcefully ");
		
		extentLog_Pass("******Executed : homePageNavigationTC02");
		log.info("******Executed : homePageNavigationTC02");


	}

}
