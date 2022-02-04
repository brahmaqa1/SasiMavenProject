package AllPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.base;

public class LoginPage extends base
{
	public WebDriver driver;
	
	//1.declaration of ele
	
	private WebElement username_TextboxEle; 
	
	private WebElement pwdEle;
	private WebElement loginBtn;
	
	
	//2. Initilase ele
	
	public LoginPage(WebDriver driver)
	{
		username_TextboxEle =driver.findElement(By.name("username"));
		pwdEle = driver.findElement(By.name("pwd"));
		loginBtn = driver.findElement(By.id("loginButton"));// ok
		//a[@id='loginButton']
//		loginBtn = driver.findElement(By.xpath("//a[@id='loginButton']"));// ok
		//a[@id='loginButton']/div
//		loginBtn = driver.findElement(By.xpath("//a[@id='loginButton']/div"));
		
		this.driver=driver;
	}
	
	//3.utilise
	public void enter_UserName(String userName)
	{
		exTest.log(LogStatus.PASS, "Enter user="+userName);
		log.info("Enter user="+userName);
		
		System.out.println("Enter user="+userName);
		username_TextboxEle.sendKeys(userName);
	}
	
	public void enter_Password(String pwd)
	{
		log.info("Enter pwd="+pwd);
		exTest.log(LogStatus.PASS, "Enter pwd="+pwd);
		System.out.println("Enter pwd="+pwd);
		pwdEle.sendKeys(pwd);
	}
	
	
	public void click_LoginBtn()
	{
		System.out.println("click login btn");
		exTest.log(LogStatus.PASS, "click login btn");
		loginBtn.click();		
	}
	
	public void login(String user,String pwd)
	{
		enter_UserName(user);
		enter_Password(pwd);
		click_LoginBtn();
		verify_LoginSuccess();
	}
	
	public boolean verify_LoginSuccess()
	{
		//actiTIME -  Enter Time-Track
		WebDriverWait wait= new WebDriverWait(driver, 20);
		//boolean res=wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		boolean res=wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
		
		//             e "actiTIME -  Enter Time-Track". 
		//Current title: "actiTIME - Enter Time-Track" (tried for 10 second(s) with 500 milliseconds interval)
			
		if(res)
		{
			System.out.println("Home page appears ");
		}
		else
		{
			System.out.println("Home page does not appear ");
		}
		
		return res;		
	}

}
