package AllTestCases;

import org.openqa.selenium.WebDriver;

public class A4 {
	static int i;// 0    // instance var
	float salary; // 0.0 
	String ename; //   null
	public WebDriver driver; //  null	
	public boolean  isEmpExist; //  false 
	
	public static void main(String[] args) {
		
		A4  aobj= new A4();
		System.out.println("i="+i);
		
		System.out.println("saley= "+aobj.salary);
		System.out.println("ename= "+aobj.ename);
		System.out.println("driver= "+aobj.driver);
		System.out.println("isEmpExist= "+aobj.isEmpExist);
		int b;// local var  must be initialsed 
//		System.out.println("b="+b);//isEmpExist= false
		
	}

}
