package AllTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.TestBase;
import AllPages.HomePage;
import AllPages.LoginPage;

public class Deleteuser_byuserrole_Test  extends TestBase{

	
	@Test
	public void deleteusertest()
	{
		
		//1 open browser
	WebDriver driver;
	extentLog_Pass("loginTC01 started execution ");
	log.info("loginTC01 started execution ");

	extentLog_Pass("Step1:open browser");
  driver = openBrowser();
	
	LoginPage loginPage=  new LoginPage(driver);
	extentLog_Pass("logintoOrangeHRMSAppl");
	loginPage.logintoOrangeHRMSAppl("Admin", "admin123");
	log.info("loged in successfull to orange hrms");

	
		 //  open user page
	
        extentLog_Pass("on homepage class mouse_over_admintab ");
   	HomePage homePage= new HomePage(driver);

		 homePage.mouse_Over_AdminTab();
		 
		 // deleet user
        extentLog_Pass("on homepage class delete_user method ");

		 homePage.deleteCheckBoxyBasedOnUserRole("Admin");
			log.info("deleted selected user role records");

	
}
	
	

	
	
	
}
