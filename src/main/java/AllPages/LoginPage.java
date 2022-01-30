package AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ListenersTest;
import Utilities.TestBase;

public class LoginPage extends TestBase
{
	ListenersTest  li = new ListenersTest();
	
	 public WebDriver driver;
	// 1.   define elemnsts with locatos
	@FindBy(name="txtUsername")
	public WebElement username_Textboox;
	
	@FindBy(id="txtPassword")
	public WebElement pwd_Textboox;
	
	@FindBy(xpath="//input[@name='Submit']")
	public WebElement loginBtn;
	
	@FindBy(id="welcome")
	public WebElement WelcomeMsg;
	
	//2 intilaise element  // constr
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
//		PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	
	
	
	
	//3  .. use all elemsnt   in methods
	public void enter_userName(String user)
	{
//		driver.findElement(null).sendKeys("");//   dont neeed to write driver.findEleemnt()
		System.out.println("enter_userName ="+user);
		System.out.println("driver="+driver  + ",username_Textboox="+username_Textboox);
//		exTest.log(LogStatus.PASS, "enter_userName ="+user);
		extentLog_Pass("enter_userName ="+user);
		log.info("enter_userName ="+user);
//		driver=null,username_Textboox=null
		username_Textboox.sendKeys(user);
//		enter_Val_InTextbox(user, user);
		
//		Exception in thread "main" java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.WebElement.sendKeys(java.lang.CharSequence[])" 
		//because "this.username_Textboox" is null
	}
	
	public void enter_password(String pwd)
	{
		System.out.println("enter_password ="+pwd);
		log.info("enter_password ="+pwd);
		
//		ListenersTest  li = new ListenersTest();
//		li.exTest.log(LogStatus.PASS,"enter_password ="+pwd);
		
		extentLog_Pass("enter_password ="+pwd);
		pwd_Textboox.sendKeys(pwd);
	}
	
	
	public void click_Login()
	{
		System.out.println("click_Login");
//		ListenersTest  li = new ListenersTest(); //  dont create obj again again ..create in class level
//		li.exTest.log(LogStatus.PASS, "click_Login");
		
		extentLog_Pass("click_Login =");
		loginBtn.click();
		

	}	
		
//		*********************************************
//		Method Name	:  LogintoOrangeHRMSAppl
//		Arguments	:
//		Return Type	:  void
//		Author   	: Brahma
//		
//		Modfied Date : 
			
//		*********************************************
		public void logintoOrangeHRMSAppl(String user,String pwd)
		{
			
			enter_userName(user);
			enter_password(pwd);
			click_Login();
//			WebDriverWait  wait = new webdri
			
			if(WelcomeMsg.isDisplayed()) //  no such ele 
			{
				System.out.println("Login is successfull for user="+user);
				extentLog_Pass("Login is successfull");
			}
			else
			{
				System.out.println("Login is not  successfull");
				extentLog_Fail("Login is not  successfull for user="+user);
			}
		}
		
		
		
	

}
