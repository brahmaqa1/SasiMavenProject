package AllPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.TestBase;

public class HomePage extends TestBase
{
	public static  WebDriver driver;
	
	// 1  Define elemenst	
	@FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]")
	public WebElement admin_Tab;
	
	@FindBy(css ="#menu_admin_UserManagement")
	public WebElement UserManagementLink;
	
	@FindBy(id ="menu_admin_viewSystemUsers")
	public WebElement usersList;
	
	@FindBy(id="searchSystemUser_userName")
	public WebElement UsernameSearchboxEle;

	@FindBy(id="btnAdd")
	public WebElement  AddBtn;
	
	@FindBy(id="systemUser_userType")
	public WebElement  userRole_Dropdown;
	
	@FindBy(id="systemUser_employeeName_empName")
	public WebElement  employeeName_Textbox;
	
	@FindBy(id="systemUser_userName")
	public WebElement  Username_Textbox;
	
	@FindBy(id="systemUser_status")
	public WebElement  Status_Dropdown;
	
	@FindBy(id="systemUser_password")
	public WebElement  Password_Textbox;	
	
	@FindBy(id="systemUser_confirmPassword")
	public WebElement  ConfirmPassword_Textbox;
	
	
	@FindBy(id="btnSave")
	public WebElement  SaveBtn;
	
	
	@FindBy(id="btnDelete")
	public WebElement  deleteBtn;
	
	
	@FindBy(id="dialogDeleteBtn")
	public WebElement  OKBtnDeleteRecords;
	
	//2  initiall all lee -- const
	
	public HomePage(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
		this.driver=driver1;
	}
	
		
	//3  use all those eleents in methods
	public void mouse_Over_AdminTab()
	{			
		System.out.println("mouse_Over_AdminTab");
		System.out.println("driver ="+driver);
		extentLog_Pass("mouse_Over_AdminTab");
		log.info("mouse_Over_AdminTab");
		Actions act = new Actions(driver);
		act.moveToElement(admin_Tab).perform();	
		
		act.moveToElement(UserManagementLink).perform();
		extentLog_Pass("click usersList");
		usersList.click();
		
		if(UsernameSearchboxEle.isDisplayed())
		{
			System.out.println("User page is displayed");
			extentLog_Pass("User page is displayed");
		}
		else
		{
			System.out.println("Users page is not displayed");
			extentLog_Fail("Users page is not displayed");
		}
		
	}

	public void create_New_User(String emplName,String userName) throws InterruptedException
	{
		System.out.println("Click add btn");
		extentLog_Pass("Click add btn");
		AddBtn.click();
		System.out.println("Select user role");
		extentLog_Pass("Select user role");
		Select sel = new Select(userRole_Dropdown);
		sel.selectByVisibleText("Admin");
		
		System.out.println("enter employee name");
		extentLog_Pass("enter employee name");
		employeeName_Textbox.sendKeys(emplName);		
		
		System.out.println("enter user name="+userName);
		extentLog_Pass("enter user name="+userName);
		Username_Textbox.sendKeys(userName);
		
		Select sel2 = new Select(Status_Dropdown);
		sel2.selectByVisibleText("Enabled");
		
		userName=userName+"@123321" ;
		extentLog_Pass("enter user name="+userName);		
		Password_Textbox.sendKeys(userName);
		
		
		ConfirmPassword_Textbox.sendKeys(userName);
		
		Thread.sleep(3000);
		//SaveBtn.click();
		Actions act = new Actions(driver);
		act.click(SaveBtn).perform();
		// wait for data to be visible 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String myxpath= "//table[@id='resultTable']//td/a[text()='"+ userName +"']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myxpath)));
		
		System.out.println("Verify user is exist in table or not");
		
		if(driver.findElement(By.xpath(myxpath)).isDisplayed())
		{
			System.out.println("User=" + userName+   " created ");
			extentLog_Pass("User=" + userName+   " created ");
		}
		else
		{
			System.out.println("User=" + userName+   " is not created ");
			extentLog_Fail("User=" + userName+   " is not created ");
		}	
	}
	
	public  void delete_User(String user)
	{
		String myxpath ="//table[@id='resultTable']//td/a[text()='" + user +"']/../preceding-sibling::td/input";
		driver.findElement(By.xpath(myxpath)).click();
				
		deleteBtn.click();	
		
		OKBtnDeleteRecords.click();
//		Successfully Deleted
		
		// verify user is delete or not
		String userXpath= "//table[@id='resultTable']//td/a[text()='"+ user +"']";
		
	
		
//		if(driver.findElement(By.xpath(userXpath)).isDisplayed()) // exeption
//		{
//			System.out.println("Fail.User=" + user+   " is exist in table ");
//		}
//		else
//		{
//			System.out.println("Pass.User=" + user+   " is not exist in table ");
//		}
		
//		try
//		{
//			driver.findElement(By.xpath(userXpath)).isDisplayed();
//			System.out.println("Fail.User=" + user+   " is exist in table ");
//			
//		}
//		catch (Exception e) {
//			System.out.println("Pass.User=" + user+   " is not exist in table ");
//		}
		
		//   using cnt 
		int cnt=	driver.findElements(By.xpath(userXpath)).size();// 0 or 1
			if(cnt ==0 )
			{
				System.out.println("Pass.User=" + user+   " is not exist in table ");				
			}
			else
			{
				System.out.println("Fail.User=" + user+   " is exist in table ");
			}	
	}
	

	public void deleteCheckBoxyBasedOnUserRole(String UserRole)
	{
        //xpaath= //*[@id="resultTable"]/tbody/tr/td[text()='Admin']/parent::tr/td[1]
		String myxpath= " //*[@id=\"resultTable\"]/tbody/tr/td[text()='"+UserRole+"']/parent::tr/td[1]";
		System.out.println("myxpath="+myxpath);
		log.info("in allpages homepage");

		try
		{
			driver.findElement(By.xpath(myxpath)).click();	

			deleteBtn.click();
		 OKBtnDeleteRecords.click();

			
			
			
		}
		catch (Exception e) {
			System.out.println("Activity Code=" +UserRole +"  is not found.plz check ur data or xpath="+myxpath);
			System.out.println("exception details="+e);
		}
	}
	
	
	
	
	
	// HW:   is_User_Exist_UseraTable()
	
	
	// Hw1: is_User_Not_Exist_UseraTable()
	
	
	//  HW: Search 
	 public void search_Valid_User()
	 {
		 
	 }
	
	 // HW:
	 public void search_InValid_User()
	 {
		 
	 }
	
	 // HW :  add job title	 
	 public void createNewJobTitle()
	 {
		 
	 }
	 
	 // Hw:  open given job
	 
	 
	 
}
