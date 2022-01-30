package Utilities;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenersTest implements ITestListener
{
	//  genreate report file name only once
	public static ExtentReports exReports;
	public  static ExtentTest exTest;
	static Date d = new Date();
	//public static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	public static String fileName = "MyExtent_Reports"+ ".html";
	public void onStart(ITestContext context) {
		System.out.println("on Start .extest="+exTest);
		// TODO Auto-generated method stub
		
	
		//Mon Jan 03 16:12:46 IST 2022.html
		Date d= new Date();		
		 System.out.println("da="+  d.toString().replace(":", "_").replace(" ", "_"));
		 // Mon Jan 03 1_12_46 IST 2022.html
		 //Mon_Jan_03_1_12_46_IST_2022.html
		//	String fileName= "D:\\Practise\\FrameWorkDeisgnsPractiseWorkSpace\\SasiMavenProject\\MyExtentReports\\MyhtmlExtentReports" +d.toString().replace(":", "_").replace(" ", "_")+ ".html";
//			MyhtmlExtentReportsMon_Jan_03_16_16_19_IST_2022.html
			System.out.println("Report File path= "+fileName);	
				exReports = new ExtentReports(fileName);
		 // gets executed only once  - so  res file willl be genearetd only once
//	
	}
	
	
	public void onTestStart(ITestResult result) {
		//   gets exuted for eaac test method
//		 exTest=  exReports.startTest("TC1: testA");
//		 get test case name
		 String TCName= result.getName();
		 System.out.println("before  startTest:  " +TCName  + ",exTest="+exTest);
		 exTest=  exReports.startTest(TCName);		 
		 System.out.println("after startTest:  " +TCName  + ",exTest="+exTest);
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		exReports.endTest(exTest);		
		exReports.flush();
	
	}
	
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	  
	  public static void extentLog_Pass(String msg)
	  {
		  System.out.println("extest in extentLog_Pass="+exTest);
		  exTest.log(LogStatus.PASS, msg);
	  }
	  
	  public static  void extentLog_Fail(String msg)
	  {
		  exTest.log(LogStatus.FAIL, msg);
	  }
	
}
