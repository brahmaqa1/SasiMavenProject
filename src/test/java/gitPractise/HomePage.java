package AllPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.base;

public class HomePage extends base
{
	public WebDriver driver;

	//1.declaration of ele
	
	private WebElement menuName; 
	
	
	
	
	//2. Initilase ele
	
	public HomePage(WebDriver driver)
	{
		//menuName =driver.findElement(By.xpath("//div[text()='Users']"));
		
		this.driver =driver;
	}
	

	//3.  utilise 
	
	public void navigateToMenu(String menuName)
	{
		String menuNamexpath= "//div[text()='" +menuName + "']";
		System.out.println("Click on menu="+menuName);
		log.info("Click on menu="+menuName);
		 driver.findElement(By.xpath(menuNamexpath)).click();
		 
		 if(menuName.equals("Users"))
		 {
			 menuName="User";
		 }
		 wait_For_Title(menuName);
	}
	
	public void wait_For_Title(String title)
	{
		System.out.println("wait_For_Title contains given="+title);
		log.info("wait_For_Title contains given="+title);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		//boolean res=wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		boolean res=wait.until(ExpectedConditions.titleContains(title));
	}

}
