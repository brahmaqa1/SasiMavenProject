package AllTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import Utilities.TestBase;

public class CreateNewEmployeeTC4Test 
{

	@Test
	public void createNewEmployeeTC03() throws InterruptedException
	{
//	public static void main(String[] args) throws InterruptedException {
		
		
		//1 open browser
		 TestBase tb= new TestBase();
		 WebDriver driver=  tb.openBrowser();
		
		 // login to appl
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.logintoOrangeHRMSAppl("Admin", "admin123");
		 
		 //  open user page
		 HomePage homePage= new HomePage(driver);
		 homePage.mouse_Over_AdminTab();
		 
		 //  create new employee
		 
		 homePage.create_New_User("Ananya Dash", "Samuel");
		 
		 

	}

}
